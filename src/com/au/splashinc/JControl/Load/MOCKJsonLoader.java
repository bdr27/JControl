/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import com.au.splashinc.JControl.Util.MyVariables.ControllerAction;
import com.sun.glass.events.MouseEvent;
import java.awt.event.KeyEvent;
import org.json.simple.JSONObject;
/**
 *
 * @author bob_l
 */
public class MOCKJsonLoader extends AControllerLoader{
    private JSONObject json;
    
    
    public MOCKJsonLoader(String location) {
        super(location);
        json = new JSONObject();
    }

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
        json.put("Button1", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_SPACE));
        json.put("Button2", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_E));
        json.put("Button3", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F1));
        json.put("Button5", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_CAPS_LOCK));
        json.put("Button9", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_SHIFT));
        json.put("Button10", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_C));
        json.put("X Axis -", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_A));
        json.put("X Axis +", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_D));
        json.put("X Axis -", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_W));
        json.put("X Axis +", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_S));
        json.put("Hat Switch .25", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F5));
        json.put("Hat Switch .5", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F4));
        json.put("Hat Switch .75", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F2));
        json.put("Hat Switch 1", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F3));
        json.put("Z Axis -", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_R));
        json.put("Z Axis +", GetSimpleButton(ControllerAction.SIMPLE_MOUSE.toString(), MouseEvent.BUTTON_LEFT));
        json.put("X Rotation", GetSimpleButton(ControllerAction.SIMPLE_MOUSE.toString(), "LeftRight"));
        json.put("Y Rotation -", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_PAGE_UP));
        json.put("Y Rotation +", GetSimpleButton(ControllerAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_PAGE_DOWN));

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
