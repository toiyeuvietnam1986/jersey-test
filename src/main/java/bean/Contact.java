package bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by a13168 on 2014/04/04.
 */
@XmlRootElement
public class Contact {
    private String id;
    private String name;
    private List<Address> addressList;

    public Contact() {}

    public Contact(String id, String name, List<Address> addressList) {
        this.id = id;
        this.name = name;
        this.addressList = addressList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="address")
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
