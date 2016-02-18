/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

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
        JSONObject jump = new JSONObject();
        jump.put("SimpleButton", KeyEvent.VK_K);        
        json.put("Button1", jump);
        json.put("name", "MOCK JSON");
        System.out.println(json.toJSONString());
        
        //KeyStroke ks = KeyStroke.getKeyStroke('k', 0);
        //System.out.println(ks.getKeyCode());
        //json.put("Button 1", "k");
    }
    
    private JSONObject GetSimpleButton(String buttonName, KeyEvent key){
        JSONObject js = new JSONObject();
        js.put(buttonName, key);
        return js;
    }
    
}
