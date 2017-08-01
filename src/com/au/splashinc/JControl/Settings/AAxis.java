/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Settings;

/**
 *
 * @author Brendan
 */
public abstract class AAxis {
    public String axis;
    public ActionType actionType;
    
    public abstract void execute(double value);
}
