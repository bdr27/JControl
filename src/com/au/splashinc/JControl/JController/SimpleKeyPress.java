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
public class SimpleKeyPress extends AButtonDownUpExecute{
    public int keyCode;
    
    public SimpleKeyPress(String name, int keyCode){
        super(name);
        this.keyCode = keyCode;
    }

    @Override
    public void actionExecute() {
        rob.keyPress(keyCode);
    }
}
