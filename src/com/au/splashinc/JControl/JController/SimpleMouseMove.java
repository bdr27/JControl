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
    
    public SimpleMouseMove(){
        multiplier = 200;
    }
    
    @Override
    protected void actionExecute(double x, double y) {
        rob.mouseMove((int)(x * multiplier) , (int)(y * multiplier));
    }
    
}
