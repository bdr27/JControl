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
public class ButtonDownUpSimpleKey extends AButtonDownUpExecute{
    public int keyCode;
    
    public ButtonDownUpSimpleKey(int keyCode){
        this.keyCode = keyCode;
    }

    @Override
    protected void actionKeyDown() {
        rob.keyPress(keyCode);   }

    @Override
    protected void actionKeyUp() {
        rob.keyRelease(keyCode);}
}
