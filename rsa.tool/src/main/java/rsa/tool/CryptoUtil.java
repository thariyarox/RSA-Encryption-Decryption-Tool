package rsa.tool;

import org.apache.axiom.om.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;


public class CryptoUtil {

    public static String encrypt(String plaintext, KeyStore keyStore, String keyAlias) throws Exception {

        Security.insertProviderAt(new BouncyCastleProvider(), 1);

        Certificate[] certs = keyStore.getCertificateChain(keyAlias);
        Cipher cipher = Cipher.getInstance("RSA", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, certs[0].getPublicKey());
        return Base64.encode(cipher.doFinal(plaintext.getBytes()));
    }

    public static String decrypt(String encryptedText, KeyStore keyStore, String keyAlias, String keyPassword) throws Exception {

        Security.insertProviderAt(new BouncyCastleProvider(), 1);

        byte[] cipherText = Base64.decode(encryptedText);
        PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias,
                keyPassword.toCharArray());

        Cipher cipher = Cipher.getInstance("RSA", "BC");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] cipherbyte = cipher.doFinal(cipherText);
        return new String(cipherbyte);
    }


    public static KeyStore getKeyStore(String filePath, String keyStorePassword) throws Exception {

        String file = filePath;
        KeyStore keyStore = KeyStore.getInstance("JKS");
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            keyStore.load(in, keyStorePassword.toCharArray());
        } finally {
            if (in != null) {
                in.close();
            }
        }

        return keyStore;
    }
}
