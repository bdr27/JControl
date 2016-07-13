/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import com.au.splashinc.JControl.JController.AButtonDownUpExecute;
import com.au.splashinc.JControl.JController.AMouseMoveExecute;
import com.au.splashinc.JControl.JController.ButtonDownUpSimpleKey;
import com.au.splashinc.JControl.JController.MouseMoveSimple;
import com.au.splashinc.JControl.JController.ButtonDownUpSimpleMouseButton;
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
    private Map<String, AButtonDownUpExecute> keyMap;
    private Map<String, AMouseMoveExecute> mouseMoveMap;
    private Map<String, AButtonDownUpExecute> mouseButtonMap;
    
    public JsonLoaderHelper(JSONObject jo){
        this.jo = jo;
        keyMap = new HashMap<>();
        mouseMoveMap = new HashMap<>();
        mouseButtonMap = new HashMap<>();
        populateMaps();
    }
    
    public Map<String, AButtonDownUpExecute> getKeyMap(){
        return keyMap;
    }
    
    public Map<String, AMouseMoveExecute> getMouseMoveMap(){
        return mouseMoveMap;
    }
    
    public Map<String, AButtonDownUpExecute> getMouseButtonMap(){
        return mouseButtonMap;
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
                AButtonDownUpExecute down = new ButtonDownUpSimpleKey(button);
                keyMap.put(key.toString(), down);              
            }
            else if(value.containsKey(ControllerAction.SIMPLE_MOUSE.toString())){
                Object obj = value.get(ControllerAction.SIMPLE_MOUSE.toString());
                try{
                    int mouse = Integer.parseInt(obj.toString());
                    if(mouse != 224){
                        AButtonDownUpExecute down = new ButtonDownUpSimpleMouseButton(mouse);
                        mouseButtonMap.put(key.toString(), down);
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
                        AMouseMoveExecute mme = new MouseMoveSimple(moveDirection);
                        mouseMoveMap.put(key.toString(), mme);
                    }
                }
            }
        }
        System.out.println("Hello World");
    }
}