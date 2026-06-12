package quickchart;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//unit test for Message class validation and functionality 
public class MessageTest {

    @Test
    public void testValidRecipientCell() {
        Message msg = new Message();
        assertEquals("Cell phone number successfully captured.",msg.checkRecipientCell("+27718693000"));
    }

    @Test
    public void testInvalidRecipientCell() {
        Message msg = new Message();
        assertEquals( "Invalid cell phone number.",msg.checkRecipientCell("071869300"));
    }

    @Test
    public void testValidMessageLength() {
        Message msg = new Message();
        assertEquals("Message ready to send.",msg.checkMessageLength("Did you get the cake "));
    }

    @Test
    public void testLongMessage() {
        Message msg = new Message();

        String longText = "a".repeat(300);

        assertTrue(msg.checkMessageLength(longText).contains("Message exceeds"));
    }
     
    @Test 
    public void testCreateMessageHash() {
        Message msg = new Message();
        
        String hash = msg.createMessageHash( "1234567890", 0, "Did you get the cake");
        assertNotNull(hash);
    }
    
    @Test 
    public void testReturnTotalMessages() { 
        Message msg = new Message();
        msg.initializeArrays(5); 
        msg.addMessage( "+27718693000", "Hello", "Sent");
        assertEquals( 1, msg.returnTotalMessages());
    }
}