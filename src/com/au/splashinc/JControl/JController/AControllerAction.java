/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.JController;

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
    
    public AControllerAction(MyController controller)
    {
        this.controller = controller;
    }
    
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
