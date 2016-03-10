/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

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
    
    public AControllerLoader(String location){
        this.location = location;
    }
    
    public abstract void LoadConfig();
    
    protected JSONObject GetButtonJson(String buttonName, String buttonAction, int keyCode)
    {
        JSONObject jsonButton = new JSONObject();
        JSONObject jsonButtonAction = GetSimpleButton(buttonAction, keyCode);
        jsonButton.put(buttonName, jsonButtonAction);
        return jsonButton;
    }
    
    protected JSONObject GetSimpleAxis(String axisName, int keyCode, Boolean negative){
        //Checks if it needs to be a positive or negative direction
        int direction = 1;
        if(negative){
            direction = -1;
        }
        JSONObject js = new JSONObject();
        JSONObject axisDirection = new JSONObject();
        axisDirection.put(direction, keyCode);
        js.put(axisName, axisDirection);
        return js;
    }
    
    protected JSONObject GetSimpleButton(String buttonName, int keyCode){
        JSONObject js = new JSONObject();
        js.put(buttonName, keyCode);
        return js;
    }
}
