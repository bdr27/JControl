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

    @Override
    protected void ExecuteAxis() {    
        Iterator it = controllerAxis.entrySet().iterator();
        Map<String, AMouseMoveExecute> mouseMoveMap = loader.getMouseMoveMap();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            String key = (String)pair.getKey();
            Float value = (Float)pair.getValue();
            if(mouseMoveMap.containsKey(key)){
                AMouseMoveExecute mouseMove = (AMouseMoveExecute)mouseMoveMap.get(key);
                try {
                    mouseMove.Execute((double)value);
                } catch (AWTException ex) {
                    Logger.getLogger(MockControllerAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            it.remove();
        }
        /*for(int i = 0; i < controllerAxis.size(); i++){
            
        }*/
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
