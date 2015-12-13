/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;


/**
 *
 * @author bob_l
 */
public class MainCLI {
    public static void main(String[] args) {
        System.out.println("Hello World");
        
        Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();
        System.out.println("Getting USB devices");
        for(Controller controller : ca){
            System.out.println(controller.getName());
        }
    }
    
}
