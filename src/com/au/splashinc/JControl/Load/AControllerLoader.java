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
    protected Map<String, AButtonDownUpExecute> keyMap;
    protected Map<String, AMouseMoveExecute> mouseMoveMap;
    protected Map<String, AButtonDownUpExecute> mouseButtonMap;
    
    public AControllerLoader(String location){
        this.location = location;
        keyMap = new HashMap<>();
        mouseMoveMap = new HashMap<>();
        mouseButtonMap = new HashMap<>();
    }
    
    public Map<String, AButtonDownUpExecute> getKeyMap(){
        return keyMap;
    }
    
    public Map<String, AButtonDownUpExecute> getMouseButtonMap(){
        return mouseButtonMap;
    }
    
    public Map<String, AMouseMoveExecute> getMouseMoveMap(){
        return mouseMoveMap;
    }
    
    public abstract void LoadConfig();    
}
