/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.JController;

import java.awt.AWTException;
import java.awt.Robot;

/**
 *
 * @author bob_l
 */
public abstract class AButtonDownUpExecute {
    protected static Robot rob;
    public AButtonDownUpExecute(){
    }
    
    protected abstract void actionKeyDown();
    protected abstract void actionKeyUp();
    
    public void executeKeyDown() throws AWTException{
        prepareRob();
        actionKeyDown();
    }
    
    private void prepareRob() throws AWTException{
        if(rob == null){
            rob = new Robot();
        }
    }
    
    public void executeKeyUp() throws AWTException{
        prepareRob();
        actionKeyUp();
    }
}
