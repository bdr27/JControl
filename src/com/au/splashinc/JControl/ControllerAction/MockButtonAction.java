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
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;

/**
 *
 * @author bob_l
 */
public class MockButtonAction extends AButtonAction {

    Robot rob;

    public MockButtonAction(MyController controller) throws AWTException {
        super(controller);
        rob = new Robot();
    }

    @Override
    protected void ExecuteAxis() {
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
        rob.mouseMove(location.x, location.y);
    }

    @Override
    protected void ExecuteButtonsDown() {
        if (buttonsDown.contains(("Button 0"))) {
            rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        }else if(buttonsDown.contains("Button 1"))
        {
            rob.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        }
    }

    @Override
    protected void ExecuteButtonsUp() {
        if (buttonsDown.contains(("Button 0"))) {
            rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }else if(buttonsDown.contains("Button 1"))
        {
            rob.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        }
    }

    @Override
    protected void ExecuteHatSwitches() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
