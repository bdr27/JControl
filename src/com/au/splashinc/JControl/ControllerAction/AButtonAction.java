/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.ControllerAction;

import java.util.ArrayList;
import java.util.Map;
import net.java.games.input.Controller;

/**
 *
 * @author bob_l
 */
public abstract class AButtonAction {
    protected final MyController controller;
    protected Map<String, Float> axis;
    protected ArrayList<String> buttonsDown;
    protected ArrayList<String> buttonsUp;
    protected ArrayList<Float> hatSwitches;
    
    public AButtonAction(MyController controller)
    {
        this.controller = controller;
    }
    
    protected abstract void ExecuteButtonAction();
    
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
