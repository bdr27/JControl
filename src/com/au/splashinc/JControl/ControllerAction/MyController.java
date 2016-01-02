/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.ControllerAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.java.games.input.Component;
import net.java.games.input.Controller;
import static com.au.splashinc.JControl.Util.MyVariables.MY_DEBUG;
import net.java.games.input.Component.Identifier;

/**
 *
 * @author bob_l
 */
public class MyController {

    private final Controller controller;
    private Map<String, Float> axis;
    private ArrayList<String> buttonsDown;
    private ArrayList<String> buttonsUp;
    private ArrayList<Float> hatSwitches;
    private ArrayList<String> previousButtonsDown;

    public MyController(Controller controller) {
        this.controller = controller;
    }

    public boolean poll() {
        boolean validPoll = false;
        if (controller.poll()) {
            validPoll = true;
            if (MY_DEBUG) {
                System.out.println("Polling controller: " + controller.getName());
            }
            //Clear up previous buttons
            axis = setMaps(axis);
            buttonsDown = setStringArrayList(buttonsDown);
            buttonsUp = setStringArrayList(buttonsUp);
            hatSwitches = setFloatArrayList(hatSwitches);

            Component[] components = controller.getComponents();
            for (Component component : components) {
                Identifier componentIdentifier = component.getIdentifier();
                if (componentIdentifier == Component.Identifier.Axis.POV) {
                    hatSwitches.add(component.getPollData());
                }
                if (component.isAnalog()) {
                    axis.put(component.getName(), component.getPollData());
                } else if (componentIdentifier.getName().matches("^[0-9]*$")) {
                    if (component.getPollData() == 1) {
                        buttonsDown.add(component.getName());
                    }
                }
                if (MY_DEBUG) {
                    System.out.println("component: " + component.getName() + " value: " + component.getPollData());
                }
            }
            if (MY_DEBUG) {
                System.out.print("Buttons up: ");
            }
            if (previousButtonsDown != null) {
                for (String button : previousButtonsDown) {
                    if (!buttonsDown.contains(button)) {
                        buttonsUp.add(button);
                        if (MY_DEBUG) {
                            System.out.print(button + " ");
                        }
                    }
                }
                if (MY_DEBUG) {
                    System.out.println("");
                }
            }

            previousButtonsDown = setStringArrayList(previousButtonsDown);
            previousButtonsDown = new ArrayList(buttonsDown);
        }
        return validPoll;
    }

    public Map<String, Float> getAxis() {
        if (axis == null) {
            axis = new HashMap();
        }
        return axis;
    }

    public ArrayList<String> getButtonsDown() {
        if (buttonsDown == null) {
            buttonsDown = new ArrayList();
        }
        return buttonsDown;
    }

    public ArrayList<String> getButtonsUp() {
        if (buttonsUp == null) {
            buttonsUp = new ArrayList();
        }
        return buttonsUp;
    }

    public ArrayList<Float> getHatSwitches() {
        if (hatSwitches == null) {
            hatSwitches = new ArrayList();
        }
        return hatSwitches;
    }

    private Map<String, Float> setMaps(Map<String, Float> map) {
        if (map != null) {
            map.clear();
        } else {
            map = new HashMap();
        }
        return map;
    }

    private ArrayList<String> setStringArrayList(ArrayList<String> arrayList) {
        if (arrayList != null) {
            arrayList.clear();
        } else {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    private ArrayList<Float> setFloatArrayList(ArrayList<Float> arrayList) {
        if (arrayList != null) {
            arrayList.clear();
        } else {
            arrayList = new ArrayList();
        }
        return arrayList;
    }
}
