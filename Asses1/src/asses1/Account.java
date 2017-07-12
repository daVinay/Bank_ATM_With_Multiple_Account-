/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asses1;

import javax.swing.JFrame;


/**
 *
 * @author yours
 */


public abstract class Account{  //made abstract class for all account
    public int withdrawLimit;  //withdrawal limit variable
    public int withrawsMade;
    public double balance;      //balance 
    JFrame frame = new JFrame("inputBox"); //to show frame name such as account name 
    
    abstract boolean deposit(double b);  //deposit function 
    abstract boolean withdrawMoney(double b);    //withdraw function
    abstract boolean showStats();  //this is where user selects option and returns to main menu
   
}
