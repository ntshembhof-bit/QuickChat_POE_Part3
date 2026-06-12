package quickchart;
 
// Message validation ,storage, hashung and tracking functionality
public class Message {

    private String[] sentMessages;
    private String[] disregardedMessages;
    private String[] storedMessages;
    private String[] messageHash;
    private String[] messageID;
    private String[] recipients;

    private int trackingCounter = 0;
    private int totalSentCount = 0;

    public void initializeArrays(int capacity) {
        sentMessages = new String[capacity];
        disregardedMessages = new String[capacity];
        storedMessages = new String[capacity];
        messageHash = new String[capacity];
        messageID = new String[capacity];
        recipients = new String[capacity];
    }
    //validates that the message does exceed 250 characters
    public String checkMessageLength(String message) {
        if (message.length() > 250) {
            int excess = message.length() - 250;
            return "Message exceeds 250 characters by " + excess;
        }
        return "Message ready to send.";
    }

    public String checkRecipientCell(String cellNumber) {
        if (cellNumber.matches("^\\+27\\d{9}$")) {
            return "Cell phone number successfully captured.";
        }
        return "Invalid cell phone number.";
    }

    public String createMessageHash(String msgId, int msgIndex, String messageText) {
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (msgId.substring(0, 2) + ":" + msgIndex + ":" +
                firstWord + lastWord).toUpperCase();
    }

    public void addMessage(String recipient, String text, String flag) {

        String msgId = String.valueOf(
                1000000000L + (long)(Math.random() * 9000000000L));

        String hash = createMessageHash(msgId, trackingCounter, text);

        messageID[trackingCounter] = msgId;
        messageHash[trackingCounter] = hash;
        recipients[trackingCounter] = recipient;
                

        if (flag.equalsIgnoreCase("Sent")) {
            sentMessages[trackingCounter] = text;
            totalSentCount++;
        } else if (flag.equalsIgnoreCase("Disregard")) {
            disregardedMessages[trackingCounter] = text;
        } else if (flag.equalsIgnoreCase("Stored")) {
            storedMessages[trackingCounter] = text;
        }

        trackingCounter++;
    }

    public void displaySenderAndRecipientOfStored() {
        System.out.println("Stored Messages");
         
        for(int i = 0; i < trackingCounter; i++) {
           if(storedMessages[i] != null){
             
               System.out.println("Recipient: " + recipients[i]);
               System.out.println("Message: " + storedMessages[i]);
               System.out.println( "-------------------");      
           }
        }
    }

    public String findLongestMessage() {

        String longest = "";

        for (int i = 0; i < trackingCounter; i++) {

            if (storedMessages[i] != null &&
                storedMessages[i].length() > longest.length()) {

                longest = storedMessages[i];
            }
        }

        return longest;
    }

    public String searchByMessageId(String targetId) {

        for (int i = 0; i < trackingCounter; i++) {

            if (messageID[i] != null &&
                messageID[i].equals(targetId)) {

                String messageText = "";
                
                if(sentMessages[i] != null){
                    messageText = sentMessages[i];
                    
                } else if (storedMessages[i] != null) {
                    messageText = storedMessages[i];
                }
                return "Recipent: " + recipients[i]  + "\nMessage: " + messageText;
            }
        }

        return "Message ID not found.";
    }

    public void searchAllByRecipient(String cell) {
        boolean found = false;
        
        for (int i = 0; i < trackingCounter; i++) {
            if (recipients[i] != null &&
                recipients[i].equals(cell)){  
             
            System.out.println("Recipient: " + recipients[i]);
            if (sentMessages[i] != null) {
                System.out.println("Message: " + sentMessages[i]);
             } else if (storedMessages[i] != null) { 
                System.out.println("Message: " + storedMessages[i]); 
            }
            System.out.println("-----------------------"); 
            found = true;
        }     
        }
        if(!found){
            System.out.println("No messages found for this recipient.");
        }
    }

    public String deleteMessageByHash(String targetHash) {

        for (int i = 0; i < trackingCounter; i++) {

            if (messageHash[i] != null &&
                messageHash[i].equalsIgnoreCase(targetHash)) {

              sentMessages[i] = null; 
              storedMessages[i] = null;
              disregardedMessages[i] = null; 
              recipients[i] = null; 
              messageHash[i] = null; 
              messageID[i] = null;  
              
           return "Message successfully delected ";
            }
        }

        return "Hash not found.";
    }

    public void displayFullReport() {

        System.out.println("================================");
        System.out.println("      FULL REPORT");
        System.out.println("================================");
        
        for (int i = 0; i < trackingCounter; i++) {
            
            String messageText = "";
            
            if (sentMessages[i] != null) {
                messageText = sentMessages[i];
             } else if (storedMessages[i] != null) {
                 messageText = storedMessages[i];
            }
            
            System.out.println("Message ID: " + messageID[i]);
            System.out.println("Recipient: " + recipients[i]);
            System.out.println("Hash: " + messageHash[i]);
            System.out.println("Message: " + messageText);
            System.out.println("------------------");
        }
    }

    public int returnTotalMessages() {
        return totalSentCount;
    }

    public String[] getSentMessages() {
        return sentMessages;
    }

    public String[] getMessageHash() {
        return messageHash;
    }

    public String[] getMessageID() {
        return messageID;
    }
}