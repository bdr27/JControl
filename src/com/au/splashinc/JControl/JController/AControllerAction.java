/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.JController;

import com.au.splashinc.JControl.Load.AControllerLoader;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author bob_l
 */
public abstract class AControllerAction {
    protected double deadzone = 0.3;
    protected MyController controller;
    protected Map<String, Float> controllerAxis;
    protected ArrayList<String> controllerButtonsDown;
    protected ArrayList<Float> controllerHatSwitches;
    protected ArrayList<String> previousButtonsDown;
    protected ArrayList<String> currentButtonsDown;
    protected AControllerLoader loader;
    
    public AControllerAction(final MyController controller, final AControllerLoader loader) {
        this.controller = controller;
        this.loader = loader;
        previousButtonsDown = new ArrayList<>();
        currentButtonsDown = new ArrayList<>();
    }

    // Need another common method that will get what to do with each button
    // Exis Axis will get a list of buttons that will then go through the loader
    // values
    // and see what we need to do whether it's a button down on whatnot;

    // Need another common method that will get what to do with each button
    // Exis Axis will get a list of buttons that will then go through the loader
    // values
    // and see what we need to do whether it's a button down on whatnot
    private void ExecuteButtonAction() {
        try {
            previousButtonsDown = (ArrayList<String>) currentButtonsDown.clone();
        } catch (final Exception ex) {
            System.out.println("Error converting current buttons to previous buttons");
            System.err.println(ex.toString());
        }
        currentButtonsDown.clear();
        ExecuteAxis();
        ExecuteButtonsDown();
        ExecuteHatSwitches();
        ExecuteButtonsUp();
    }
    
    protected abstract void ExecuteAxis();
    protected abstract void ExecuteButtonsDown();
    protected abstract void ExecuteButtonsUp();
    protected abstract void ExecuteHatSwitches();
    
    public void Execute(){
        if (controller.poll()){
            controllerAxis = controller.getAxis();
            controllerButtonsDown = controller.getButtonsDown();
            controllerHatSwitches = controller.getHatSwitches();
            ExecuteButtonAction();
        }        
    }
}
