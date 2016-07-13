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
        System.out.println("mouse down: " + keycode);
        rob.mousePress(keycode);
    }

    @Override
    protected void actionKeyUp() {
        System.out.println("mouse up: " + keycode);
        rob.mouseRelease(keycode);
    }
    
}
