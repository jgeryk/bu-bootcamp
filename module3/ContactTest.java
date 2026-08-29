import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void constructor_setsNameCorrectly() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void constructor_setsPhoneCorrectly() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }

    @Test
    void getName_returnsExactString_notTransformed() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void toString_containsName() {
        assertTrue(contact.toString().contains("Ada Lovelace"));
    }

    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains("+1 617 555 0101"));
    }

    @Test
    void contactsWithSameName_remainIndependentInstances() {
        Contact sameNameContact = new Contact("Ada Lovelace", "+1 617 555 0102");
        sameNameContact.setName("Grace Hopper");

        assertNotSame(contact, sameNameContact);
        assertEquals("Ada Lovelace", contact.getName());
        assertEquals("Grace Hopper", sameNameContact.getName());
        assertEquals("+1 617 555 0101", contact.getPhone());
        assertEquals("+1 617 555 0102", sameNameContact.getPhone());
    }
}
