/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.JController;

import com.au.splashinc.JControl.Load.AControllerLoader;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;

/**
 *
 * @author bob_l
 */
public class MockControllerAction extends AControllerAction {

    Robot rob;

    public MockControllerAction(MyController controller, AControllerLoader loader) throws AWTException {
        super(controller, loader);
        rob = new Robot();
    }

    @Override
    protected void ExecuteAxis() {        
    }

    @Override
    protected void ExecuteButtonsDown() {
    }

    @Override
    protected void ExecuteButtonsUp() {
    }

    @Override
    protected void ExecuteHatSwitches() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
