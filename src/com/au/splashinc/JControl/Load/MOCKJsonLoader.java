/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

import com.au.splashinc.JControl.Util.MyVariables;
import com.au.splashinc.JControl.Util.MyVariables.ButtonAction;
import java.awt.event.KeyEvent;
import javafx.scene.input.KeyCode;
import javax.swing.KeyStroke;
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
        json.put("Button1", GetSimpleButton(ButtonAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_SPACE));
        json.put("Button2", GetSimpleButton(ButtonAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_E));
        json.put("Button3", GetSimpleButton(ButtonAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_F1));
        json.put("Button5", GetSimpleButton(ButtonAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_CAPS_LOCK));
        json.put("Button9", GetSimpleButton(ButtonAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_SHIFT));
        json.put("Button10", GetSimpleButton(ButtonAction.SIMPLE_BUTTON.toString(), KeyEvent.VK_C));
        //GetSimpleButton("SIMPLE_BUTTON", KeyEvent.VK_SPACE);
        //jump.put("SIMPLE_BUTTON", KeyEvent.VK_SPACE);        
        //json.put("Button1", jump);
        //json.put("name", "MOCK JSON");
        System.out.println(json.toJSONString());
        
        //KeyStroke ks = KeyStroke.getKeyStroke('k', 0);
        //System.out.println(ks.getKeyCode());
        //json.put("Button 1", "k");
    }
    
    private JSONObject GetButtonJson(String buttonName, String buttonAction, int keyCode)
    {
        JSONObject jsonButton = new JSONObject();
        JSONObject jsonButtonAction = GetSimpleButton(buttonAction, keyCode);
        jsonButton.put(buttonName, jsonButtonAction);
        return jsonButton;
    }
    
    private JSONObject GetSimpleButton(String buttonName, int keyCode){
        JSONObject js = new JSONObject();
        js.put(buttonName, keyCode);
        return js;
    }
    
}
