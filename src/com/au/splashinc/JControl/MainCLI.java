/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl;

import com.au.splashinc.JControl.JController.AControllerAction;
import com.au.splashinc.JControl.JController.SimpleControllerAction;
import com.au.splashinc.JControl.JController.MyController;
import com.au.splashinc.JControl.Load.AControllerLoader;
import com.au.splashinc.JControl.Load.DarkForcesJsonLoader;
import com.au.splashinc.JControl.Util.MyControllers;
import java.awt.AWTException;
import java.util.ArrayList;
import net.java.games.input.Controller;

/**
 *
 * @author bob_l
 */
public class MainCLI {

    public static void main(String[] args) throws AWTException, InterruptedException {
        //JunkMain junk = new JunkMain();
        //junk.execute();
        controllerMain();
    }

    private static void controllerMain() throws InterruptedException {
        MyControllers myControllers = new MyControllers();
        ArrayList<Controller> controllers = myControllers.GetControllers();
        myControllers = new MyControllers(true);
        ArrayList<Controller> controllers2 = myControllers.GetControllers();

        System.out.println("Let's do this");
        System.out.println("Length without all USB: " + controllers.size());
        System.out.println("Length with all USB: " + controllers2.size());
        AControllerLoader mjs = new DarkForcesJsonLoader("This is a test");
        mjs.LoadConfig();
//JSONObject obj = new JSONObject();
        //obj.put("Hello", "World");
        //System.out.println("JSON String: " + obj.toJSONString());
        if (controllers.size() > 0) {
            try {
                MyController controller = new MyController(controllers.get(0));
                AControllerAction buttonAction = new SimpleControllerAction(controller, mjs);
                while (true) {
                    buttonAction.Execute();
                    Thread.sleep(20);
                }
            } catch (AWTException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
