/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Util;

/**
 *
 * @author bob_l
 */
public class MyVariables {
    public static boolean MY_DEBUG = true;
    
    public enum ButtonAction{

        /**
         *simple joy to key command
         */
        SIMPLE_BUTTON ("SimpleButton");
        private final String value;
        private ButtonAction(String value){
            this.value = value;
        }
        
        /*public boolean equals(String otherName){
            return (otherName == null) ? false : value.equals(otherName);
        }*/
        
        @Override
        public String toString(){
            return this.value;
        }
    }
    
    public static boolean getDebug()
    {
        return MY_DEBUG;
    }
    
    public static void setDebug(boolean DEBUG)
    {
        MY_DEBUG = DEBUG;
    }
}
