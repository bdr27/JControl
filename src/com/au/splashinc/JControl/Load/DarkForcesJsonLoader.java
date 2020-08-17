/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import com.au.splashinc.JControl.Util.MyVariables.ControllerAction;
import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author bob_l
 */
public class DarkForcesJsonLoader extends JsonLoader{
    private JSONObject json;   
    
    public DarkForcesJsonLoader(String location) {
        super(location);
        json = new JSONObject();
    }

    //@Override
    @Override
    public void LoadConfig() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //JSON organised in [Button/Axis/POV],{[TypeofAction],[Value]}
        /*W- up - LeftStick Up
A - Left - Right Stick Left - X Rot -
S - back - LeftStick Down - Y Axis up
d - right - Right Stick Right - x Rot +
Space - jump - A - 1
c - Crouch - Right Stick In - 10
Mouse 1 - primary fire - Right Trigger - z axis -
Shift - Run - Left Stick in - 9
Capslock - Walk - LB - 5
e - Open/interact - B - 2
R - Secondary Fire - Left Trigger - z axis +
Pageup - Look Up - Right Stick Up - Y Rot -
PageDown - Loop Down - Right Stick Down - y Rot +
f1 - pda - Back - 3
f2 - night vision - dpad down
f3- fleats - dpad left
f4 - gasmask - dpad right
f5 - headlamp - dpad up*/
        JSONArray simpleKey = new JSONArray();
        simpleKey.add(GetJSONObject("Button 0", KeyEvent.VK_SPACE));
        simpleKey.add(GetJSONObject("Button 2", KeyEvent.VK_E));
        simpleKey.add(GetJSONObject("Button 8", KeyEvent.VK_F1));
        simpleKey.add(GetJSONObject("Button 7", KeyEvent.VK_CAPS_LOCK));
        simpleKey.add(GetJSONObject("Button 3", KeyEvent.VK_SHIFT));
        simpleKey.add(GetJSONObject("Button 1", KeyEvent.VK_C));
        simpleKey.add(GetJSONObject("X Axis -", KeyEvent.VK_A));
        simpleKey.add(GetJSONObject("X Axis +", KeyEvent.VK_D));
        simpleKey.add(GetJSONObject("Y Axis -", KeyEvent.VK_W));
        simpleKey.add(GetJSONObject("Y Axis +", KeyEvent.VK_S));
        simpleKey.add(GetJSONObject("Hat Switch 0 0.25", KeyEvent.VK_F5));
        simpleKey.add(GetJSONObject("Hat Switch 0 0.5", KeyEvent.VK_F4));
        simpleKey.add(GetJSONObject("Hat Switch 0 0.75", KeyEvent.VK_F2));
        simpleKey.add(GetJSONObject("Hat Switch 0 1.0", KeyEvent.VK_F3));
        simpleKey.add(GetJSONObject("Z Axis +", KeyEvent.VK_R));
        simpleKey.add(GetJSONObject("Y Rotation +", KeyEvent.VK_PAGE_UP));
        simpleKey.add(GetJSONObject("Y Rotation -", KeyEvent.VK_PAGE_DOWN));
        JSONArray simpleMouse = new JSONArray();
        simpleMouse.add(GetJSONObject("X Rotation", "LeftRight"));
        simpleMouse.add(GetJSONObject("Z Axis -", InputEvent.BUTTON1_MASK));
//JSONObject jo = new JSONObject();
        //jo.put("Button 0", KeyEvent.VK_SPACE);
        //jo.put("Button 2", KeyEvent.VK_E);
        //jo.pu
        //simpleKey.add(jo);
        /*JSONObject j1 = new JSONObject();
        j1.put("Button 2", KeyEvent.VK_E);
        simpleKey.add(j1);*/
        json.put(ControllerAction.SIMPLE_BUTTON.toString(), simpleKey);
        json.put(ControllerAction.SIMPLE_MOUSE.toString(), simpleMouse);
        /*json.put("Button 0", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_SPACE));
        json.put("Button 2", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_E));
        json.put("Button 8", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F1));
        json.put("Button 7", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_CAPS_LOCK));
        json.put("Button 3", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_SHIFT));
        json.put("Button 1", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_C));
        json.put("X Axis -", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_A));
        json.put("X Axis +", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_D));
        json.put("Y Axis -", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_W));
        json.put("Y Axis +", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_S));
        json.put("Hat Switch 0 0.25", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F5));
        json.put("Hat Switch 0 0.5", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F4));
        json.put("Hat Switch 0 0.75", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F2));
        json.put("Hat Switch 0 1.0", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F3));
        json.put("Z Axis +", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_R));
        json.put("Z Axis -", GetSimpleButton(ControllerAction.SIMPLE_MOUSE.toString(), InputEvent.BUTTON1_MASK));
        json.put("X Rotation", GetSimpleButton(ControllerAction.SIMPLE_MOUSE.toString(), "LeftRight"));
        json.put("Y Rotation +", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_PAGE_UP));
        json.put("Y Rotation -", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_PAGE_DOWN));*/
        //json.put("Button 4,5", this)

        controllerDetail = json.toJSONString();
        System.out.println(json.toJSONString());
        JsonLoaderHelper jsh = new JsonLoaderHelper(json);
        
        keyDownMap = jsh.getKeyDownMap();
        keyUpMap = jsh.getKeyUpMap();
        mouseMoveMap = jsh.getMouseMoveMap();
        mouseButtonDownMap = jsh.getMouseButtonDownMap();
        mouseButtonUpMap = jsh.getMouseButtonUpMap();
    }  
}
