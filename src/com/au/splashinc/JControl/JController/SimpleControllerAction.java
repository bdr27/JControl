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
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.au.splashinc.JControl.Util.MyVariables.MY_DEBUG;

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
        Iterator<Entry<String,Float>> it = controllerAxis.entrySet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            String key = "";
            Float value = 0.0f;
            if(next instanceof Map.Entry<?,?>){
                var nextMap = (Map.Entry<?,?>) next;
                var keyGeneric = nextMap.getKey();
                var valueGeneric = nextMap.getValue();
                if(keyGeneric instanceof String){
                    key = (String) keyGeneric;
                }
                if(valueGeneric instanceof Float){
                    value = (Float) valueGeneric;
                }
            }
            if(MY_DEBUG){
                System.out.println("Key: " + key + ", Value: " + value + ", Deadzone: " + deadzone);
            }
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
        for(String button: controllerButtonsDown){
            runKeyDown(button);               
        }
    }

    @Override
    protected void ExecuteButtonsUp() {
        for(String button: previousButtonsDown){
            if(!currentButtonsDown.contains(button)){
                runKeyUp(button);
            }
        }
    }

    @Override
    protected void ExecuteHatSwitches() {
        //Needs to be for i = 0 or counter as you can have controllers with more then 1 hat switch
        int counter = 0;
        for(Float hatSwitch: controllerHatSwitches){
            String key = String.format("Hat Switch %s %s", counter++, hatSwitch);
            runKeyDown(key);
        }
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
