/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import com.au.splashinc.JControl.JController.AButtonDownUpExecute;
import com.au.splashinc.JControl.JController.AMouseMoveExecute;
import com.au.splashinc.JControl.JController.SimpleKeyPress;
import com.au.splashinc.JControl.JController.SimpleKeyRelease;
import com.au.splashinc.JControl.JController.SimpleMouseMove;
import com.au.splashinc.JControl.JController.SimpleMousePress;
import com.au.splashinc.JControl.JController.SimpleMouseRelease;
import com.au.splashinc.JControl.Util.MyVariables;
import com.au.splashinc.JControl.Util.MyVariables.ControllerAction;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;

/**
 *
 * @author bob_l
 */
public class JsonLoaderHelper {
    private JSONObject jo;
    private Map<String, AButtonDownUpExecute> keyDownMap;
    private Map<String, AButtonDownUpExecute> keyUpMap;
    private Map<String, AMouseMoveExecute> mouseMoveMap;
    private Map<String, AButtonDownUpExecute> mouseButtonDownMap;
    private Map<String, AButtonDownUpExecute> mouseButtonUpMap;
    
    public JsonLoaderHelper(JSONObject jo){
        this.jo = jo;
        keyDownMap = new HashMap<>();
        keyUpMap = new HashMap<>();
        mouseMoveMap = new HashMap<>();
        mouseButtonDownMap = new HashMap<>();
        mouseButtonUpMap = new HashMap<>();
        populateMaps();
    }
    
    public Map<String, AButtonDownUpExecute> getKeyDownMap(){
        return keyDownMap;
    }
    
    public Map<String, AButtonDownUpExecute> getKeyUpMap(){
        return keyUpMap;
    }
    
    public Map<String, AMouseMoveExecute> getMouseMoveMap(){
        return mouseMoveMap;
    }
    
    public Map<String, AButtonDownUpExecute> getMouseButtonDownMap(){
        return mouseButtonDownMap;
    }
    
    public Map<String, AButtonDownUpExecute> getMouseButtonUpMap(){
        return mouseButtonUpMap;
    }
    
    private void populateMaps(){
        Set keys = jo.keySet();
        //Collection co = jo.values();
        Object[] objKey = keys.toArray();
        for(Object key : objKey){
            System.out.println("Key: " + key.toString());
            JSONObject value = (JSONObject) jo.get(key);
            if(value.containsKey(ControllerAction.SIMPLE_BUTTON.toString())){
                int button = (int)value.get(ControllerAction.SIMPLE_BUTTON.toString());
                AButtonDownUpExecute down = new SimpleKeyPress(button);
                keyDownMap.put(key.toString(), down);
                AButtonDownUpExecute up = new SimpleKeyRelease(button);
                keyUpMap.put(key.toString(), up);                
            }
            else if(value.containsKey(ControllerAction.SIMPLE_MOUSE.toString())){
                Object obj = value.get(ControllerAction.SIMPLE_MOUSE.toString());
                try{
                    int mouse = Integer.parseInt(obj.toString());
                    if(mouse != 224){
                        AButtonDownUpExecute down = new SimpleMousePress(mouse);
                        mouseButtonDownMap.put(key.toString(), down);
                        AButtonDownUpExecute up = new SimpleMouseRelease(mouse);
                        mouseButtonUpMap.put(key.toString(), up);
                    }
                }catch(NumberFormatException ex){
                    String mouse = obj.toString();
                    String moveDirection = "";
                    switch(mouse){
                        case "LeftRight":
                            moveDirection = "x";
                            break;
                        case "UpDown":
                            moveDirection = "y";
                            break;
                        default:
                            moveDirection = "unknown";
                            break;
                    }
                    if(moveDirection.equals("unknown")){
                    } else {
                        AMouseMoveExecute mme = new SimpleMouseMove(moveDirection);
                        mouseMoveMap.put(key.toString(), mme);
                    }
                }
            }
        }
    }
}