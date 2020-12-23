
package javaapplication2;

import java.io.Serializable;


public class User implements Serializable{
    String name;
    String passWorld;

    public User() {
    }

    public User(String name, String passWorld) {
        this.name = name;
        this.passWorld = passWorld;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }    
    
}
