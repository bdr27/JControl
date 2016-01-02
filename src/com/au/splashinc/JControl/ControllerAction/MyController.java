/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.ControllerAction;

import java.util.Dictionary;
import net.java.games.input.Component;
import net.java.games.input.Controller;

/**
 *
 * @author bob_l
 */
public class MyController {
    private final Controller controller;
    
    public MyController(Controller controller){
        this.controller = controller;
    }
    
    public void Poll()
    {
        controller.poll();
        Component[] components = controller.getComponents();
            StringBuffer buffer = new StringBuffer();
            for(int i=0;i<components.length;i++) {
                if(i>0) {
                buffer.append(", ");
                }
                buffer.append(components[i].getName());
                buffer.append(": ");
                if(components[i].isAnalog()) {
                    buffer.append(components[i].getPollData());
                } else {
                    if(components[i].getPollData()==1.0f) {
                        buffer.append(components[i].getPollData());
                    } else {
                        buffer.append(components[i].getPollData());
                    }
                }
            }
            System.out.println(buffer);
    }
}
