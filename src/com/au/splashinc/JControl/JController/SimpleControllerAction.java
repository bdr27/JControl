/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.JController;

import com.au.splashinc.JControl.Load.AControllerLoader;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bob_l
 */
public class SimpleControllerAction extends AControllerAction {

    Robot rob;

    public SimpleControllerAction(MyController controller, AControllerLoader loader) throws AWTException {
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

    @Override
    protected void ExecuteButtonsDown() {
    }

    @Override
    protected void ExecuteButtonsUp() {
        for(String buttonDown: previousButtonsDown){
            if(!currentButtonsDown.contains(buttonDown)){
                runKeyUp(buttonDown);
            }
        }
    }

    @Override
    protected void ExecuteHatSwitches() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean checkMouseMove(String key, double value) {
        boolean valid = false;
        Map<String, AMouseMoveExecute> mouseMoveMap = loader.getMouseMoveMap();
        if (mouseMoveMap.containsKey(key)) {
            AMouseMoveExecute mouseMove = (AMouseMoveExecute) mouseMoveMap.get(key);
            try {
                mouseMove.Execute(value);
            } catch (AWTException ex) {
                Logger.getLogger(SimpleControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valid;
    }
    
    private boolean checkKeyUpDown(String key, Map<String, AButtonDownUpExecute> buttons){
        boolean valid = false;
       
        if (buttons.containsKey(key)) {
            valid = true;
            AButtonDownUpExecute keyDown = (AButtonDownUpExecute) buttons.get(key);
            try {
                keyDown.execute();
            } catch (AWTException ex) {
                Logger.getLogger(SimpleControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valid;
    }
    
    private void runKeyDown(String key){
        boolean validKeyDown = false;
        if(checkKeyUpDown(key, loader.getKeyDownMap())){
            validKeyDown = true;
        }else if(checkKeyUpDown(key, loader.getMouseButtonDownMap())){
            validKeyDown = true;
        }
        if(validKeyDown){
            currentButtonsDown.add(key);
        }
    }
    
    private void runKeyUp(String key){
        if(checkKeyUpDown(key, loader.getKeyUpMap())){
        }else if(checkKeyUpDown(key, loader.getMouseButtonUp())){
        }
    }   
}
