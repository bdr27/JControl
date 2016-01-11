/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

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
        json.put("name", "MOCK JSON");
        KeyStroke ks = KeyStroke.getKeyStroke('k', 0);
        System.out.println(ks.getKeyCode());
        json.put("Button 1", "k");
    }
    
}
