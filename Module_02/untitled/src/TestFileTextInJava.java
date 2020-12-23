import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Bạn ơi nhập tên vào đi bạn: ");
            String filename = input.next();
            File myObj = new File(filename + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myObjWriter = new FileWriter(myObj.getName());
                System.out.println("Nhập nội dung vào file text đi bạn ơi!");
                input.nextLine();
                String info = input.nextLine();
                myObjWriter.write(info);
                myObjWriter.close();

                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println("- Nội dung bạn vừa nhập: " + data);
                }

                if (myObj.exists()) {
                    System.out.println("- File name: " + myObj.getName());
                    System.out.println("- Absolute path: " + myObj.getAbsolutePath());
                    System.out.println("- Writeable: " + myObj.canWrite());
                    System.out.println("- Readable: " + myObj.canRead());
                    System.out.println("- File size in bytes: " + myObj.length());
                } else {
                    System.out.println("The file does not exist!");
                }
                myReader.close();

                System.out.println("Delete file:");
//                input.nextLine();
//                String filenametodelete = input.nextLine();
                if (myObj.delete()) {
                    System.out.println("Deleted the file: " + myObj.getName());
                } else {
                    System.out.println("Failed to delete the file.");
                }

            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
