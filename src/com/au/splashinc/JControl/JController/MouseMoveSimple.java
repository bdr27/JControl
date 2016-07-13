/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.JController;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

/**
 *
 * @author bob_l
 */
public class MouseMoveSimple extends AMouseMoveExecute{
    private int multiplier;
    
    public MouseMoveSimple(String axis){
        super(axis);
        multiplier = 100;
    }
    
    @Override
    protected void actionExecute(double amount) {
        PointerInfo currentMouseLocation = MouseInfo.getPointerInfo();
        Point location = currentMouseLocation.getLocation();
        if(axis.equals("x")){
            rob.mouseMove(location.x + (int)(amount * multiplier), location.y);
        }else if(axis.equals("y")){
            rob.mouseMove(location.x, location.y + ((int) (amount * multiplier)));
        }
    }    
}
