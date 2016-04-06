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
public class SimpleMouseMove extends AMouseMoveExecute{
    private int multiplier;
    
    public SimpleMouseMove(String axis){
        super(axis);
        multiplier = 200;
    }
    
    @Override
    protected void actionExecute(double amount) {
        if(axis.equals("x")){
            rob.mouseMove((int)(amount * multiplier), 0);
        }else if(axis.equals("y")){
            rob.mouseMove(0, ((int) (amount * multiplier)));
        }
    }
    
}
