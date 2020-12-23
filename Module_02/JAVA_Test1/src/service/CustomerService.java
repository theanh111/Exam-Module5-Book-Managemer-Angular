import java.util.ArrayList;
import java.util.List;

public class CustomerService extends Customer {
    List listCustomer = new ArrayList();

    public CustomerService() {
    }

    public CustomerService(long ID, String name, String address) {
        super(ID, name, address);
    }

    public void save(long id, String name, String address) {
        super.setID(id);
        super.setName(name);
        super.setAddress(address);
    }

    public String findByID(long id) {
        for (int i = 0; i < listCustomer.size(); i++) {
            if (id == super.getID()) {

            }

        }
        return "Can't find";
    }

    public String findByName(String name) {
        if (name == super.getName()) {
            return toString();
        }
        return "Can't find!";
    }

    public void findAll(List listCustomer) {
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println(listCustomer.get(i));
        }
    }

//    public void delete(List listCustomer) {
//        listCustomer.remove()
//    }
}

