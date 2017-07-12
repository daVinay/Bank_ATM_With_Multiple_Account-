
package asses1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Vinay
 */
public class Asses1 {

    /**
     * @param args the command line arguments
     */

    
    
    public static void main(String[] args) {  //main section

   
        boolean  userChoice = false; //this bool will work as the main menu leding to the choice of account
        Account s1 = new Saving(); 
        Account f1 = new Fixed();
        Account c1 = new Cheque();
        Account n1 = new NetSaver();
        
        JFrame frame = new JFrame("inputBox");  //shows frame name
        
        
        while (!userChoice){  //while this loop is false
            String userInput;
            int UInput;

            userInput = JOptionPane.showInputDialog(frame, "Welcome to the AIT Bank.\n"   //show account names
                                                  + "-------------------------------------\n"
                    + "Please select from the accounts below: \n"
                    + "\t1). Saving Account\n"
                    + "\t2). Fixed Account\n"
                    + "\t3). Netsaver Account\n"
                    + "\t4). Cheque Account\n"
                    + "\t5). Exit\n", "AIT BANK ATM", JOptionPane.PLAIN_MESSAGE );

          
                UInput = Integer.parseInt(userInput);

                if(UInput == 1){             //if selected saving account
                   s1.showStats();                   
                }
                else if (UInput == 2){      //if selected fixed account
                    f1.showStats();
                }
                else if (UInput == 3){       //if selected net-saver account                    
                    n1.showStats();
                }
                else if (UInput == 4){        //if selected cheque account                    
                    c1.showStats();   
                }
                else if(UInput == 5){       //if decided to exit
                    System.exit(0);
                }
                else{                       //when pressed wrong choice
                    JOptionPane.showMessageDialog(null, "Wrong choice.\n Please select again");               
                }
         }
        
     
        
   
    }
  
    
}