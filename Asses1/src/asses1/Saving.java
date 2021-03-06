/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asses1;

import javax.swing.JOptionPane;

/**
 *
 * @author yours
 */
public class Saving extends Account implements IntrestAccount{

    Saving(){           //balance initialised
        balance = 5000;
        withdrawLimit = 5;  //customised withdraw limit
        withrawsMade = 1;
    }

    @Override
    boolean deposit(double b) {     //deposit function
       String DAmount;
       DAmount = JOptionPane.showInputDialog("How much would you like to Deposit today? "); //ask input from user
       double DepositingAmount = Integer.parseInt(DAmount);      //change Strring to double
       balance +=  DepositingAmount;            //new balance
       
       JOptionPane.showMessageDialog(null, "Your new saving account balance after deposit is: "+balance);
       return true;
    }

    @Override
    boolean withdrawMoney(double b) {       //withdraw money function
        
        String wAmount;
        wAmount = JOptionPane.showInputDialog("How much would you like to withdraw? ");
        double withdrawingAmount = Integer.parseInt(wAmount);
        
        if(withdrawingAmount > balance )        //withdrawing money can't be more than balance
        {
            JOptionPane.showMessageDialog(null, "Sorry, overdraft is not available to you at the moment\n. You cant withdraw more than your account balance");

        }
       else if((withdrawingAmount%10!=0 ) || (withdrawingAmount == 10) || (withdrawingAmount == 30)){       //can't withdraw 10, 30 and anything that is not in multiple of 10
            JOptionPane.showMessageDialog(null, "ATM machine can only give 20, 50 and 100 notes.");
        }
        else if(withrawsMade > withdrawLimit){      //withdrwal limits can't exceed more than 5
            JOptionPane.showMessageDialog(null, "You have exceeded you withrawal limits");
        }         
        else {
            balance -=  withdrawingAmount;  //set the new balance after withdrawal
             JOptionPane.showMessageDialog(null, "You have "+(withdrawLimit-withrawsMade)+" withdrawals remaining\n"
                     + "Your new saving account balance after withdrawal is: "+balance);  
        }
        
        withrawsMade++;
         return true;
    
    }

   
    @Override
    public boolean intrestCal(double b) {  //calculates intrest
        JOptionPane.showMessageDialog(null, "Your intrest rate for saving Account is 2.6%\n");
        double intrestRate = 2.6;   //intrest rate initialised
        double intrestCharged = (2.6/100*balance)/30;  //divided by 30 so that its calculated mothly
        intrestCharged = Math.round(intrestCharged*100);  //rounds to two decimal 
        intrestCharged = intrestCharged/100;
        JOptionPane.showMessageDialog(null, "You have earned a total intrest of $"+intrestCharged+", calculated daily.\n");
        
        balance += intrestCharged;  //new balance with intrest earned
        JOptionPane.showMessageDialog(null, "Your new saving account balance is "+balance);
        return true;
    }
   
 
     @Override
    boolean showStats() {       //main function of this account
         boolean  userChoice = false;
         
        while (!userChoice){        //loop to show the menu
            String userInput;
            int UInput;

            userInput = JOptionPane.showInputDialog(frame, "This is your Saving Account. \n"   //show user options
                    + "\nPlease choose from below options\n"
                    + "1). Withdraw\n"
                    + "2). Deposit\n"
                    + "3). Balance Inquiry\n"
                    + "4). Intrest\n"
                    + "5). Return to the main menu\n", "Saving Account",  JOptionPane.PLAIN_MESSAGE);

                UInput = Integer.parseInt(userInput);   //convert user entered String to int

                if(UInput == 1){     //If choice is 1, will withdraw
                   withdrawMoney(balance);
                }
                else if (UInput == 2){      //choice 2 will deposit
                    deposit(balance);
                }
                else if (UInput == 3){      //choice 3 will show balance
                    JOptionPane.showMessageDialog(null, "Your saving account balance is: "+balance);
                }
                else if (UInput == 4){      //choice 4 to calculate intrest
                    intrestCal(balance);
                }
                else if (UInput == 5){      //choice 5 will return to main menu
                    return false;
                }
                else{        //else repeat the menu again to user
                    JOptionPane.showMessageDialog(null, "Wrong choice.\n Please select again");
                }
            }
        return false;
    } 
}
