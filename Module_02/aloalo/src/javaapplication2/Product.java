
package javaapplication2;

import java.io.Serializable;


public class Product implements Serializable{

    String nameString;
    String codeString;
    int Amount;

    public Product() {
    }

    public Product(String nameString, String codeString, int Amount) {
        this.nameString = nameString;
        this.codeString = codeString;
        this.Amount = Amount;
    }

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }             
          

}
