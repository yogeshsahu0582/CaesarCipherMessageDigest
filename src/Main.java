//----Java Project (Message Digest)----Created By (Yogesh Sahu & Shreyas Tiwari)---
import java.util.Scanner;
import java.security.*;
import java.lang.String;
import java.security.NoSuchAlgorithmException;
import java.lang.Thread;

abstract class Encryption{
    abstract void display();
}
interface Decrption
{
    public void print();
}
class CaesarCipher implements Decrption{
    public void print(){
        System.out.println("-------------Start-------------");
    }
    void display(){
        System.out.println("-------------END---------------");
    }
}

public class Main extends CaesarCipher{
    public void run(){
        Main m=new Main();
        m.display();
    }
    // Encryption function used in CaesarCipher
    public static String encrypt(String plainText, int shift)
    {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++)
        {
            char ch = (char) (((int) plainText.charAt(i) + shift - 65) % 26 + 65);
            encryptedText.append(ch);
        }
        return encryptedText.toString();
    }

    // Decryption function used in CaesarCipher
    public static String decrypt(String encryptedText, int shift)
    {
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++)
        {
            char ch = (char) (((int) encryptedText.charAt(i) - shift - 65) % 26 + 65);
            decryptedText.append(ch);
        }
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main s=new Main();
        s.print();

        System.out.println("Enter your Message : ");
        String message = sc.next();

        int shift = 1;
        System.out.println("Original Message: " + message);
        System.out.println(" ");

        String encryptedText = encrypt(message, shift);
        System.out.println("Encrypted Message: " + encryptedText);


        //hexadecimal formate

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(message.getBytes());

            byte[] digest = md.digest();
            System.out.println(digest);

            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < digest.length; i++)
            {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }

            System.out.println("Hex format : " + hexString.toString());

        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        System.out.println("");
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted Message: " + decryptedText);

        Thread thread=new Thread();
        thread.start();
        System.out.println("-------------END---------------");

    }
}
