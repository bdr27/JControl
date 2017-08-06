/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Settings;

import com.au.splashinc.JControl.JController.AButtonDownUpExecute;

/**
 *
 * @author Brendan
 */
public abstract class AButton {
    public int button;
    public ActionType actionType;
    protected Boolean down;
    
    public abstract AButtonDownUpExecute getButtonPress();
    public abstract AButtonDownUpExecute getButtonRelease();
    public abstract AButtonDownUpExecute getMouseMove();
}
