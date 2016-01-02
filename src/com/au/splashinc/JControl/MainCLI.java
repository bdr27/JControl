/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl;

import com.au.splashinc.JControl.ControllerAction.MyController;
import com.au.splashinc.JControl.Util.MyControllers;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Map;
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
        if (controllers.size() > 0) {
            MyController controller = new MyController(controllers.get(0));
            while (true) {
                controller.poll();
                ArrayList<String> buttonsUp = controller.getButtonsDown();
                ArrayList<String> buttonsDown = controller.getButtonsUp();
                ArrayList<Float> hatSwitches = controller.getHatSwitches();
                Map<String, Float> axises = controller.getAxis();
                
                Thread.sleep(100);
            }
        }
    }
}
