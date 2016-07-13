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
public class ButtonDownUpSimpleMouseButton extends AButtonDownUpExecute{
    private int keycode;
    
    public ButtonDownUpSimpleMouseButton(int keycode){
        this.keycode = keycode;
    }

    @Override
    protected void actionKeyDown() {
        rob.mousePress(keycode);
    }

    @Override
    protected void actionKeyUp() {
        rob.mouseRelease(keycode);
    }
    
}
