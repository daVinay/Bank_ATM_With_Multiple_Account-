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
public class Fixed extends Account implements IntrestAccount {  //fixed account 
    
    Fixed(){   //balance initialised
        balance = 1500;
        withrawsMade = 0;  //to make sure user doesn't get intrest if withrawals made
    }

    @Override
    boolean deposit(double b) {   //deposit function
       String DAmount;
       DAmount = JOptionPane.showInputDialog("How much would you like to Deposit today? ");  //ask input from user
       double DepositingAmount = Integer.parseInt(DAmount);  //change Strring to double 
       balance +=  DepositingAmount;        //new balance
       
       JOptionPane.showMessageDialog(null, "Your new fixed account balance after deposit is: "+balance);
       return true;  
    }

    @Override
    boolean withdrawMoney(double b) {  //withdraw money function
        
        String intrestChoice;
        intrestChoice = JOptionPane.showInputDialog("If you make withdraw you'll loose intrest.\n"  //giving user choice to cancel withdraw
                                                   +"Do you want to continue (yes/no)?\n ");
            
       if(("yes".equals(intrestChoice)) || ("Y".equals(intrestChoice)) || ("YES".equals(intrestChoice)) || ("y".equals(intrestChoice))){  //if user chooses to continue
        
            String wAmount;       
            wAmount = JOptionPane.showInputDialog("How much would you like to withdraw? ");  //ask user withrawal amount
            double withdrawingAmount = Integer.parseInt(wAmount);

            if(withdrawingAmount > balance )  //withdrawing money can't be more than balance
            {
                JOptionPane.showMessageDialog(null, "Sorry, overdraft is not available to you at the moment\n. You cant withdraw more than your account balance");

            }
            else if((withdrawingAmount%10!=0 ) || (withdrawingAmount == 10) || (withdrawingAmount == 30)){  //can't withdraw 10, 30 and anything that is not in multiple of 10
                JOptionPane.showMessageDialog(null, "ATM machine can only give 20, 50 and 100 notes."); 
            }

            else {
                 balance -=  withdrawingAmount;  //set the new balance after withdrawal
                 JOptionPane.showMessageDialog(null, "Your new fixed account balance after withdrawal is: "+balance); 
                 withrawsMade++;  //this makes sure user doesnt get intrest if withrawals are made
              }
            
        return true;  //return true
       }
         return true;
    
    }
    
    @Override
    public boolean intrestCal(double b) {     //calculates intrest
        
            if(withrawsMade ==0){  //to make sure there are no withdrawals made on this account 
                JOptionPane.showMessageDialog(null, "Your intrest rate for Net-Saver Account is 3.5%/year, calculated monthly\n");
                double intrestRate = 3.3;  //initialised intrest rate
                double intrestCharged = (3.3/100*balance)/12;
                intrestCharged = Math.round(intrestCharged*100);
                intrestCharged = intrestCharged/100;
                JOptionPane.showMessageDialog(null, "You have earned a total intrest of $"+intrestCharged+", calculated monthly.");

                balance += intrestCharged;  //balance + intrest earned 
                JOptionPane.showMessageDialog(null, "Your new Fixed account balance is "+balance);
            }
            else //if withdrawals were made then show the message
                JOptionPane.showMessageDialog(null, "You haven't earned any intrest because you made withdraw before due date.");
                
        return true;
    }
    
 
     @Override
    boolean showStats() {  //main function of this account
         boolean  userChoice = false;
         
        while (!userChoice){  //loop to show the menu
            String userInput;
            int UInput;

            userInput = JOptionPane.showInputDialog(frame, "This is your fixed Account. \n"  //show user options
                    + "\nPlease choose from below options\n"
                    + "1). Withdraw\n"
                    + "2). Deposit\n"
                    + "3). Balance Inquiry\n"
                    + "4). Intrest\n"
                    + "5). Return to the main menu\n", "Fixed Account",  JOptionPane.PLAIN_MESSAGE);

                UInput = Integer.parseInt(userInput);  //convert user entered String to int

                if(UInput == 1){  //If choice is 1, will withdraw
                   withdrawMoney(balance);  
                }
                else if (UInput == 2){      //choice 2 will deposit
                    deposit(balance);
                }
                else if (UInput == 3){  //choice 3 will show balance
                    JOptionPane.showMessageDialog(null, "Your fixed account balance is: "+balance);
                }
                else if (UInput == 4){      //choice 2 will deposit
                    intrestCal(balance);
                }
                else if (UInput == 5){  //choice 4 will return to main menu
                    return false;  
                }
                else{   //else repeat the menu again to user
                   JOptionPane.showMessageDialog(null, "Wrong choice.\n Please select again");
                }
               
        }
        return false;
    }

    
}
