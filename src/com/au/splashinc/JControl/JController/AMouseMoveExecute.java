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
    private String name;
    protected Robot rob;
    
    public AMouseMoveExecute(String name){
        this.name = name;
    }
    
    protected abstract void actionExecute(int x, int y);
    
    public void Execute(int x, int y) throws AWTException{
        if(rob == null){
            rob = new Robot();
        }
        actionExecute(x, y);
    }
}
