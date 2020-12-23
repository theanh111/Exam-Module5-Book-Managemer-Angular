public class Customer {
    private long ID;
    private String name;
    private String address;

    public Customer() {
    }

    public Customer(long ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer {" +
                " ID = " + ID +
                ", name = '" + name + '\'' +
                ", address = '" + address + '\'' +
                '}';
    }
}
