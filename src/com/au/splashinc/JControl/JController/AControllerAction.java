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
    protected final MyController controller;
    protected Map<String, Float> axis;
    protected ArrayList<String> buttonsDown;
    protected ArrayList<String> buttonsUp;
    protected ArrayList<Float> hatSwitches;
    protected AControllerLoader loader;
    
    public AControllerAction(MyController controller, AControllerLoader loader)
    {
        this.controller = controller;
        this.loader = loader;
    }
    
    //Need another common method that will get what to do with each button
    //Exis Axis will get a list of buttons that will then go through the loader values
    //and see what we need to do whether it's a button down on whatnot
    private void ExecuteButtonAction(){
        ExecuteAxis();
        ExecuteButtonsDown();
        ExecuteButtonsUp();
        ExecuteHatSwitches();
    }
    
    protected abstract void ExecuteAxis();
    protected abstract void ExecuteButtonsDown();
    protected abstract void ExecuteButtonsUp();
    protected abstract void ExecuteHatSwitches();
    
    public void Execute(){
        if (controller.poll()){
            axis = controller.getAxis();
            buttonsDown = controller.getButtonsDown();
            buttonsUp = controller.getButtonsUp();
            hatSwitches = controller.getHatSwitches();
            ExecuteButtonAction();
        }        
    }
}
