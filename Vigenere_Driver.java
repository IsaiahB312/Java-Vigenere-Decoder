import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


public class Vigenere_Driver {
    public static void main(String[] args) throws Exception {
        
        /* Program will only work if Cipher text has no spaces and is in all caps and is  */
        Vigenere_Decryption VD = new Vigenere_Decryption();
        String data = "";
        String key_length;
        String key;
        String original_text;

        try {
            File file = new File("D:/Vig_Ciphertext.txt"); // Make sure the directory is correct. Use the directory where the file is downloaded to.
            Scanner FileReader = new Scanner(file);
            while (FileReader.hasNextLine()) {
              data += FileReader.nextLine();
             }
              FileReader.close();
              key_length = "Key length is: " + VD.FindKeyLength(data);
              key = VD.findKey(data, VD.FindKeyLength(data));
              original_text = "Original message is: " + VD.Decrypt(data, key);

              File solved = new File("D:/Vig_Cipher_Solution.txt"); // Make sure a proper directory is chosen for when the file is created
              solved.createNewFile();
              FileWriter writer = new FileWriter(solved);
              writer.write(key_length + "\n" + "Key is: " + key + "\n" + original_text);
              writer.close();
            }
        
          catch (FileNotFoundException e) {
              System.out.println("Error. File was not found.");
            }
    }
}
