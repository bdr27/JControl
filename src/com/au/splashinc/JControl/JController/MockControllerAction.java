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
import java.util.Iterator;
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

    //Method needs to be cleaned up but this is the basics of what I need to dorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
    @Override
    protected void ExecuteAxis() {
        Iterator it = controllerAxis.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String key = (String) pair.getKey();
            Float value = (Float) pair.getValue();
            System.out.println("Key: " + key + ", Value: " + value + ", Deadzone: " + deadzone);
            //Check for valid deadzone
            if (value > deadzone || value < 0 - deadzone) {
                if(checkMouseMove(key, (double) value)){
                } else if (value > deadzone) {
                    runKeyDown(key + " +");
                } else if (value < 0 - deadzone) {
                    runKeyDown(key + " -");
                }
            }
            it.remove();
        }
    }
    
    private void runKeyDown(String key){
        if(checkKeyPress(key)){
            //currentButtonsDown.add(key);
        }else if(checkMousePress(key)){
            //currentButtonsDown.add(key);
        }
    }

    private boolean checkKeyPress(String key) {
        boolean valid = false;
        Map<String, AButtonDownUpExecute> keyDownMap = loader.getKeyDownMap();
        if (keyDownMap.containsKey(key)) {
            valid = true;
            AButtonDownUpExecute keyDown = (AButtonDownUpExecute) keyDownMap.get(key);
            try {
                keyDown.execute();
            } catch (AWTException ex) {
                Logger.getLogger(MockControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valid;
    }

    private boolean checkMousePress(String key) {
        boolean valid = false;
        Map<String, AButtonDownUpExecute> mouseButtonDownMap = loader.getMouseButtonDownMap();

        if (mouseButtonDownMap.containsKey(key)) {
            AButtonDownUpExecute mouseButton = (AButtonDownUpExecute) mouseButtonDownMap.get(key);
            valid = true;
            try {
                mouseButton.execute();
            } catch (AWTException ex) {
                Logger.getLogger(MockControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valid;
    }

    private boolean checkMouseMove(String key, double value) {
        boolean valid = false;
        Map<String, AMouseMoveExecute> mouseMoveMap = loader.getMouseMoveMap();
        if (mouseMoveMap.containsKey(key)) {
            AMouseMoveExecute mouseMove = (AMouseMoveExecute) mouseMoveMap.get(key);
            try {
                mouseMove.Execute(value);
            } catch (AWTException ex) {
                Logger.getLogger(MockControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valid;
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
