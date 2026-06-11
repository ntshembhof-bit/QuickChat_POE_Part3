package quickchart;

import java.util.Scanner;

public class Quickchat {
    
    public static void main(String[] args){
          
        Scanner input = new Scanner(System.in);
        Message msgWorker = new Message();
        
        System.out.println("--- QUICKCHAT LOGIN ---");

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();
        
        if (username.equals("kyl_1")
        && password.equals("Ch&&sec@ke99!")) {

    System.out.println("Welcome Kyle, Smith it is great to see you again.");

    System.out.println();
    System.out.println("Welcome to QuickChat.");
    System.out.println("---");
    
  
     
    System.out.print("Enter the number of messages you wish to enter: ");
            int limit = input.nextInt();
            input.nextLine();
        
             System.out.print("Limit entered =" + limit);
            msgWorker.initializeArrays(limit);

            int choice = 0;

            while (choice != 3) {
                System.out.println();
                System.out.println("===============================");
                System.out.println("          MAIN MENU            ");
                System.out.println("===============================");
                System.out.println("1) Send Messages");
                System.out.println("2) Show recently sent messages");
                System.out.println("4) Stored Messages Menu");
                System.out.println("3) Quit");
                System.out.println("===============================");
                System.out.print("Select an option: ");

                choice = input.nextInt();
                input.nextLine();
                
                if (choice == 1) {

                    System.out.println();
                    System.out.println("--- Message 1 ---");

                    System.out.print("Enter Recipient Cell Number: ");
                    String recipient = input.nextLine();

                    System.out.println(msgWorker.checkRecipientCell(recipient));

                    System.out.print("Enter Message text: ");
                    String text = input.nextLine();

                    System.out.println(msgWorker.checkMessageLength(text));

                    System.out.println("Choose message action");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message to send later");
                    System.out.println( "Your choice" ) ;
                    
                    int action = input.nextInt(); 
                    input.nextLine();
                    
                    if (action == 1) {                        
                       msgWorker.addMessage(recipient, text, "Sent"); 
                       System.out.println("Message successfully sent");
                       
                    } else if (action == 2) {
                        msgWorker.addMessage(recipient, text, "Disregard");
                        System.out.println("Message disregarded");
                          
                    } else if (action == 3) {
                         msgWorker.addMessage(recipient, text, "Stored"); 
                         System.out.println("Message stored for later");
                          
                    
                    System.out.println("Total Messages Sent: " + msgWorker.returnTotalMessages());
                    }
                    
                } else if (choice == 2) {

                 String[] messages = msgWorker.getSentMessages();
                 System.out.println("Recently Sent Messages:"); 
                 
                 for (int i = 0; i < messages.length; i++){
                 if (messages[i] != null) {
                  System.out.println(messages[i]);
                  
                   }
                  }
                }   

                else if (choice == 4) {

    int subChoice = 0;

    while (subChoice != 7) {

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("         STORED MESSAGES MENU          ");
        System.out.println("---------------------------------------");
        System.out.println("1) Display Sender & Recipient");
        System.out.println("2) Display Longest Message");
        System.out.println("3) Search Message ID");
        System.out.println("4) Search Messages by Recipient");
        System.out.println("5) Delete Message by Hash");
        System.out.println("6) Display Full Report");
        System.out.println("7) Return to Main Menu");
        System.out.println("---------------------------------------");
        System.out.print("Select option: ");

        subChoice = input.nextInt();
        input.nextLine();

        if (subChoice == 1) {

            msgWorker.displaySenderAndRecipientOfStored();

        } else if (subChoice == 2) {

            System.out.println("Option 2 selected");
            System.out.println(msgWorker.findLongestMessage());

        } else if (subChoice == 3) {

            System.out.print("Enter Message ID: ");
            String id = input.nextLine();

            System.out.println(msgWorker.searchByMessageId(id));

        } else if (subChoice == 4) {

            System.out.print("Enter Recipient Number: ");
            String recipient = input.nextLine();

            msgWorker.searchAllByRecipient(recipient);

        } else if (subChoice == 5) {

            System.out.print("Enter Hash: ");
            String hash = input.nextLine();

            System.out.println(msgWorker.deleteMessageByHash(hash));

        } else if (subChoice == 6) {

            msgWorker.displayFullReport();

        }
    }

             } else if (choice == 3) {

                  System.out.println("Thank you for using QuickChat. Goodbye!");

                }
   
            }

        } else {

            System.out.println( "Username or password incorrect, please try again.");
     }
        
   } 
}
