/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl;

import com.au.splashinc.JControl.Util.MyControllers;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.EventQueue;


/**
 *
 * @author bob_l
 */
public class MainCLI {
    public static void main(String[] args) throws AWTException, InterruptedException {
        MyControllers myControllers = new MyControllers();
        ArrayList<Controller> controllers = myControllers.GetControllers();
        myControllers = new MyControllers(true);
        ArrayList<Controller> controllers2 = myControllers.GetControllers();
        
        System.out.println("Length without all USB: " + controllers.size());
        System.out.println("Length with all USB: " + controllers2.size());
        
       // Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();
     /*controller.getType() == Controller.Type.STICK || 
                    controller.getType() == Controller.Type.GAMEPAD || 
                    controller.getType() == Controller.Type.WHEEL ||
                    controller.getType() == Controller.Type.FINGERSTICK
       
        System.out.println("Getting USB devices");
        for(Controller controller : ca){
            if(validController(controller))
            {
                System.out.println(controller.getName());
            }
        }

        /*while(true)
        {
            for(Controller controller : ca){
                System.out.println(controller.getName());
                controller.poll();
                EventQueue queue = controller.getEventQueue();
            }
        }*/
    }    
    /*
    public static boolean validController(Controller controller)
    {
        Type type = controller.getType();
        boolean validControlType = true;
        if(type == Controller.Type.KEYBOARD || type == Controller.Type.MOUSE || 
                type == Controller.Type.TRACKBALL || 
                type == Controller.Type.TRACKPAD ||
                type == Controller.Type.UNKNOWN)
        {
            validControlType = false;
        }
        return validControlType;
    }*/
}
