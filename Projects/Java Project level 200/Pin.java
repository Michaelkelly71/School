import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Pin {
    public void Pins() throws IOException{

        try {
                String password;

        //Dispaying to and receiving input from the user and storing input in variable.
        password = JOptionPane.showInputDialog("Enter Mobile Money Password: ");

        PrintWriter outtoFile_2 = new PrintWriter("password.bin");//opening the file.
        outtoFile_2.println(password);//writing to the file.
        outtoFile_2.close(); //closding the file.
       
        File readFile_2 = new File("password.bin"); //opening the file.
        Scanner passFile = new Scanner(readFile_2); //Creating a Scanner object for reading files.
        String pass = passFile.nextLine(); //storing read content in variable.
        passFile.close(); //closding the file.

        System.out.println(); //skips line

        if (pass.equals(password)){}
        } catch (Exception e) {
        System.out.println(e);
        }
    }
}