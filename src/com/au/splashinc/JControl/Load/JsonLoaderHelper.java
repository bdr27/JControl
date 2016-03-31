/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import com.au.splashinc.JControl.JController.AButtonDownUpExecute;
import com.au.splashinc.JControl.JController.AMouseMoveExecute;
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
    
    private void populateMaps(){
        Set keys = jo.keySet();
        Collection co = jo.values();
        Object[] objKey = keys.toArray();
        for(Object key : objKey){
            System.out.println("Key: " + key.toString());
            if(jo.containsKey(key)){
                JSONObject value = (JSONObject) jo.get(key);
                System.out.println("Value: " + value.toString());
            }
        }
    }
}
