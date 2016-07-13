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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.au.splashinc.JControl.Util.MyVariables.ControllerAction;
import java.util.Iterator;
import org.json.simple.JSONArray;

/**
 *
 * @author bob_l
 */
//Maybe needs to be an abstract class
public abstract class JsonLoader extends AControllerLoader {

    String json;

    public JsonLoader(String location) {
        super(location);
    }

    protected void populateMaps(JSONObject json) {
        JSONArray mouseArray = (JSONArray) json.get(ControllerAction.SIMPLE_MOUSE.toString());
        for (int i = 0; i < mouseArray.size(); i++) {
            JSONObject jo = (JSONObject) mouseArray.get(i);
            Set controllerKeys = jo.keySet();
            Iterator a = controllerKeys.iterator();
            while (a.hasNext()) {
                Object key = a.next();
                JSONObject values = (JSONObject) jo.get(key);
                Object obj = values.get("action");
                try {
                    int mouse = Integer.parseInt(obj.toString());
                    if (mouse != 224) {
                        AButtonDownUpExecute button = new ButtonDownUpSimpleMouseButton(mouse);
                        mouseButtonMap.put(key.toString(), button);                        
                    }
                } catch (NumberFormatException ex) {
                    String mouse = obj.toString();
                    String moveDirection = "";
                    switch (mouse) {
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
                    if (moveDirection.equals("unknown")) {
                    } else {
                        AMouseMoveExecute mme = new MouseMoveSimple(moveDirection);
                        mouseMoveMap.put(key.toString(), mme);
                    }
                }
            }
        }
        JSONArray buttonArray = (JSONArray) json.get(ControllerAction.SIMPLE_BUTTON.toString());
        for (int i = 0; i < buttonArray.size(); i++) {
            JSONObject jo = (JSONObject) buttonArray.get(i);
            Set controllerKeys = jo.keySet();
            Iterator a = controllerKeys.iterator();
            while (a.hasNext()) {
                Object key = a.next();
                JSONObject values = (JSONObject) jo.get(key);
                Object obj = values.get("action");
                try {
                    int button = Integer.parseInt(obj.toString());
                    AButtonDownUpExecute down = new ButtonDownUpSimpleKey(button);
                    keyMap.put(key.toString(), down);
                } catch (NumberFormatException ex) {
                    System.err.println(ex.toString());
                }
            }
        }
    }
    
        //Probably only be in dark forces
    protected JSONObject getButtonJSON(Object button, Object action) {
        /*JSONObject jo = new JSONObject();
        jo.put(button, keyMouse);
        return jo;*/
        JSONObject jo = getJsonObject(button, getJsonObject("action", action));
        return jo;
    }

    protected JSONObject getJsonObject(Object key, Object value) {
        JSONObject jo = new JSONObject();
        jo.put(key, value);
        return jo;
    }
}
