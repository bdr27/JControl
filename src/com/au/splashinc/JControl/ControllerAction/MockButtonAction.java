/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.ControllerAction;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bob_l
 */
public class MockButtonAction extends AButtonAction {

    public MockButtonAction(MyController controller) {
        super(controller);
    }

    @Override
    protected void ExecuteButtonAction() {
        ExecuteAxis();
        //Go through axises
        //Go through pov
        //Go through buttons down
        //Go through buttons up
    }

    private void ExecuteAxis() {
        try {
            String xKey = "X Axis";
            String yKey = "Y Axis";
            float x = 0;
            float y = 0;
            if (axis.containsKey(xKey)) {
                x = axis.get(xKey);
            }
            if (axis.containsKey(yKey)) {
                y = axis.get(yKey);
            }
            Point location = MouseInfo.getPointerInfo().getLocation();
            location.x += (int) (x * 100);
            location.y += (int) (y * 100);
            Robot rob = new Robot();
            rob.mouseMove(location.x, location.y);
        } catch (AWTException ex) {
            Logger.getLogger(MockButtonAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
