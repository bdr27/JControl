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
public abstract class AMouseMoveExecute {
    protected Robot rob;
    
    public AMouseMoveExecute(){
    }
    
    protected abstract void actionExecute(double x, double y);
    
    public void Execute(double x, double y) throws AWTException{
        if(rob == null){
            rob = new Robot();
        }
        actionExecute(x, y);
    }
}
