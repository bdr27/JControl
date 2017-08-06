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
public class SimpleKeyRelease extends AButtonDownUpExecute{
    private int keyCode;
    
    public SimpleKeyRelease(int keyCode){
        this.keyCode = keyCode;
    }
    @Override
    protected void actionExecute() {
        rob.keyRelease(keyCode);
    }
    
}
