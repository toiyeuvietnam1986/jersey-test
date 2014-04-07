package storage;

import bean.Address;
import bean.Contact;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a13168 on 2014/04/06.
 */
public class ContactStore {
    private static Map<String, Contact> store;
    private static ContactStore instance = null;

    private ContactStore() {
        store = new HashMap<>();
        initOneContact();
    }

    public static Map<String, Contact> getStore() {
        if(instance == null) {
            instance = new ContactStore();
        }
        return store;
    }

    private static void initOneContact() {
        Address[] addrs = {
                new Address("Tokyo", "Shibuya"),
                new Address("Tokyo", "Shinjuku")
        };
        Contact linsay = new Contact("linsay", "Linsay Lohan", Arrays.asList(addrs));
        store.put(linsay.getId(), linsay);
    }
}
