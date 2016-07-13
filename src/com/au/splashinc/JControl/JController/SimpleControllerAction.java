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
        Iterator it = controllerAxis.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String key = (String) pair.getKey();
            Float value = (Float) pair.getValue();
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
                System.out.println(ex.toString());
                Logger.getLogger(SimpleControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return valid;
    }
    
    private AButtonDownUpExecute checkKeyUpDown(String key, Map<String, AButtonDownUpExecute> buttons){
        AButtonDownUpExecute buttonDownUp = null;  
        if (buttons.containsKey(key)) {
            buttonDownUp = (AButtonDownUpExecute) buttons.get(key);
        }
        return buttonDownUp;
    }
    
    private void runKeyDown(String key){
        AButtonDownUpExecute button = checkKeyUpDown(key, loader.getKeyMap());
        if(button == null){
            button = checkKeyUpDown(key, loader.getMouseButtonMap());
        }
        if(button != null){
            currentButtonsDown.add(key);
            try {
                button.executeKeyDown();
            } catch (AWTException ex) {
                System.out.println(ex.toString());
                Logger.getLogger(SimpleControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void runKeyUp(String key){
        AButtonDownUpExecute button = checkKeyUpDown(key, loader.getKeyMap());
        if(button == null){
            button = checkKeyUpDown(key, loader.getMouseButtonMap());
        }
        if(button != null){
            try {
                button.executeKeyUp();
            } catch (AWTException ex) {                
                System.out.println(ex.toString());
                Logger.getLogger(SimpleControllerAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}
