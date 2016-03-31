/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.JController;

/**
 *
 * @author bob_l
 */
public class SimpleMouseRelease extends AButtonDownUpExecute{
    private int keycode;
    
    public SimpleMouseRelease(int keycode){
        this.keycode = keycode;
    }
    
    @Override
    protected void actionExecute() {
        rob.mouseRelease(keycode);
    }
    
}
