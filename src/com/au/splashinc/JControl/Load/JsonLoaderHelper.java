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
import org.json.simple.JSONArray;
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

    public JsonLoaderHelper(JSONObject jo) {
        this.jo = jo;
        keyDownMap = new HashMap<>();
        keyUpMap = new HashMap<>();
        mouseMoveMap = new HashMap<>();
        mouseButtonDownMap = new HashMap<>();
        mouseButtonUpMap = new HashMap<>();
        populateMaps();
    }

    public Map<String, AButtonDownUpExecute> getKeyDownMap() {
        return keyDownMap;
    }

    public Map<String, AButtonDownUpExecute> getKeyUpMap() {
        return keyUpMap;
    }

    public Map<String, AMouseMoveExecute> getMouseMoveMap() {
        return mouseMoveMap;
    }

    public Map<String, AButtonDownUpExecute> getMouseButtonDownMap() {
        return mouseButtonDownMap;
    }

    public Map<String, AButtonDownUpExecute> getMouseButtonUpMap() {
        return mouseButtonUpMap;
    }

    private void populateMaps() {
        Set keys = jo.keySet();
        //Collection co = jo.values();
        Object[] objKey = keys.toArray();
        for (Object actionType : objKey) {
            System.out.println("Key: " + actionType.toString());
            JSONArray values = (JSONArray) jo.get(actionType);
            if (actionType.equals(ControllerAction.SIMPLE_BUTTON.toString())) {
                for (Object arrayValue : values) {
                    JSONObject jsonObject = (JSONObject) arrayValue;
                    for (Object buttonName : jsonObject.keySet()) {
                        int buttonValue = (int) jsonObject.get(buttonName);
                        System.out.println(buttonName + ": " + buttonValue);
                        AButtonDownUpExecute down = new SimpleKeyPress(buttonValue);
                        keyDownMap.put(buttonName.toString(), down);
                        AButtonDownUpExecute up = new SimpleKeyRelease(buttonValue);
                        keyUpMap.put(buttonName.toString(), up);
                    }
                }
            } else if (actionType.equals(ControllerAction.SIMPLE_MOUSE.toString())) {
                for (Object arrayValue : values) {
                    JSONObject jsonObject = (JSONObject) arrayValue;
                    for (Object buttonName : jsonObject.keySet()) {
                        String mouseKey = jsonObject.get(buttonName).toString();
                        try {
                            int buttonValue = Integer.parseInt(mouseKey);
                            if (buttonValue != 224) {
                                AButtonDownUpExecute down = new SimpleMousePress(buttonValue);
                                mouseButtonDownMap.put(buttonName.toString(), down);
                                AButtonDownUpExecute up = new SimpleMouseRelease(buttonValue);
                                mouseButtonUpMap.put(buttonName.toString(), up);
                            }
                        } catch (NumberFormatException ex) {
                            String moveDirection = "";
                            switch (mouseKey) {
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
                                AMouseMoveExecute mme = new SimpleMouseMove(moveDirection);
                                mouseMoveMap.put(buttonName.toString(), mme);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Hello World");
    }
}