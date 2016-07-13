/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author bob_l
 */
//Maybe needs to be an abstract class
public abstract class JsonLoader extends AControllerLoader{
    String json;
    
    public JsonLoader(String location) {
        super(location);
    }

    @Override
    public void LoadConfig() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(location));
            JSONObject jsonObject = (JSONObject) obj;
            //Do stuff probably in another class
        } catch (IOException | ParseException ex) {
            Logger.getLogger(JsonLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //public abstract JSONObject GetJSON();
    
    protected JSONObject GetJSONObject(Object key, Object value){
        JSONObject jo = new JSONObject();
        jo.put(key, value);
        return jo;
    }
    /*protected JSONObject GetButtonJson(String buttonName, String buttonAction, int keyCode)
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
    
    protected JSONObject GetSimpleButton(String buttonName, String action){
        JSONObject js = new JSONObject();
        js.put(buttonName, action);
        return js;
    }
    
    protected JSONObject GetSimpleButton(String buttonName, int keyCode){
        JSONObject js = new JSONObject();
        js.put(buttonName, keyCode);
        return js;
    }*/
    
}
