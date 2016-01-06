/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Load;

/**
 *
 * @author bob_l
 */
public abstract class AControllerLoader {
    protected String location;
    protected String controllerDetail;
    
    public AControllerLoader(String location){
        this.location = location;
    }
    
    public abstract void LoadConfig();
}
