import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, 11};

        try {
            FileOutputStream fout = new FileOutputStream("Test.txt");
            DataOutputStream dout = new DataOutputStream(fout);

            for (int i = 0; i < arr.length; i++) {
                dout.writeInt(arr[i]);
            }
            dout.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

