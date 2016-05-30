/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import com.au.splashinc.JControl.JController.AButtonDownUpExecute;
import com.au.splashinc.JControl.JController.AMouseMoveExecute;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;

/**
 *
 * @author bob_l
 */
public abstract class AControllerLoader {
    protected String location;
    protected String controllerDetail;
    protected Map<String, AButtonDownUpExecute> keyDownMap;
    protected Map<String, AButtonDownUpExecute> keyUpMap;
    protected Map<String, AMouseMoveExecute> mouseMoveMap;
    protected Map<String, AButtonDownUpExecute> mouseButtonDownMap;
    protected Map<String, AButtonDownUpExecute> mouseButtonUpMap;
    
    public AControllerLoader(String location){
        this.location = location;
        keyDownMap = new HashMap<>();
        keyUpMap = new HashMap<>();
        mouseMoveMap = new HashMap<>();
        mouseButtonDownMap = new HashMap<>();
        mouseButtonUpMap = new HashMap<>();
    }
    
    public Map<String, AButtonDownUpExecute> getKeyDownMap(){
        return keyDownMap;
    }
    
    public Map<String, AButtonDownUpExecute> getKeyUpMap(){
        return keyUpMap;
    }
    
    public Map<String, AButtonDownUpExecute> getMouseButtonDownMap(){
        return mouseButtonDownMap;
    }
    
    public Map<String, AButtonDownUpExecute> getMouseButtonUp(){
        return mouseButtonUpMap;
    }
    
    public Map<String, AMouseMoveExecute> getMouseMoveMap(){
        return mouseMoveMap;
    }
    
    public abstract void LoadConfig();    
}
