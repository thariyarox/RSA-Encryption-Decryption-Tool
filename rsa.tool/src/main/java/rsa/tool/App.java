package rsa.tool;

import java.security.KeyStore;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("RSA Encryption/Decryption Tool");
            System.out.println("Enter 1 for Encryption and 2 for Decryption");
            System.out.print("Enter your choice : ");
            String input = sc.nextLine();

            if("1".equals(input)){
                //encryption
                System.out.print("Enter Keystore Path: ");
                String keyStorePath = sc.nextLine();
                System.out.print("Enter Keystore password: ");
                String keyStorePassword = sc.nextLine();
                System.out.print("Enter Key Alias: ");
                String keyAlias = sc.nextLine();
                System.out.print("Enter plain text: ");
                String plainText = sc.nextLine();

                KeyStore keyStore = CryptoUtil.getKeyStore(keyStorePath, keyStorePassword);

                String output = CryptoUtil.encrypt(plainText, keyStore, keyAlias);

                System.out.println("Encrypted value: " + output);

            } else if("2".equals(input)){
                //decryption
                System.out.print("Enter Keystore Path: ");
                String keyStorePath = sc.nextLine();
                System.out.print("Enter Keystore password: ");
                String keyStorePassword = sc.nextLine();
                System.out.print("Enter Key Alias: ");
                String keyAlias = sc.nextLine();
                System.out.print("Enter Private Key Password: ");
                String privateKeyPassword = sc.nextLine();
                System.out.print("Enter Encrypted text: ");
                String encryptedText = sc.nextLine();

                KeyStore keyStore = CryptoUtil.getKeyStore(keyStorePath, keyStorePassword);

                String output = CryptoUtil.decrypt(encryptedText, keyStore, keyAlias, privateKeyPassword);

                System.out.println("Plain text value: " + output);

            } else {
                System.out.println("Invalid input. Exiting program");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
