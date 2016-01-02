/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Util;

import java.util.ArrayList;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import static com.au.splashinc.JControl.Util.MyVariables.MY_DEBUG;

/**
 *
 * @author bob_l
 */
public class MyControllers {

    private boolean allUSB = false;

    public MyControllers() {
    }

    public MyControllers(boolean allUSB) {
        this.allUSB = allUSB;
    }

    public ArrayList<Controller> GetControllers() {
        if (MY_DEBUG) {
            System.out.println("Getting list of currently plugged in controllers");
        }
        ArrayList<Controller> controllers = new ArrayList<>();
        Controller[] ca = ControllerEnvironment.getDefaultEnvironment().getControllers();
        if (MY_DEBUG) {
            System.out.println("value of allUSB: " + allUSB);
        }
        for (Controller controller : ca) {
            //Checks if allUSB devices are being returned if not checks if valid controllers
            if (allUSB || validController(controller)) {
                controllers.add(controller);
                if (MY_DEBUG) {
                    System.out.println("Controller: " + controller.getName() + " of type: " + controller.getType() + " is valid");
                }
            }
        }
        return controllers;
    }

    private boolean validController(Controller controller) {
        Controller.Type type = controller.getType();
        boolean validControlType = true;
        if (type == Controller.Type.KEYBOARD || type == Controller.Type.MOUSE
                || type == Controller.Type.TRACKBALL
                || type == Controller.Type.TRACKPAD
                || type == Controller.Type.UNKNOWN) {
            if (MY_DEBUG) {
                System.out.println("Controller: " + controller.getName() + " of type: " + controller.getType() + " is invalid");
            }
            validControlType = false;
        }
        return validControlType;
    }
}
