package pl.kazmierczak.services;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class PasswordHelper {
    private SecureRandom generator;
    private String encryptionAlgorithm = "PBEWithMD5AndDES";

    public PasswordHelper() throws NoSuchAlgorithmException {
        generator = new SecureRandom();
    }

    public String getNextPasswordSeed(){
        return String.valueOf(generator.nextInt());
    }

    public String encrypt(String password){
        SecretKey secretKey = new SecretKeySpec(password.getBytes(), encryptionAlgorithm);
        return secretKey.getEncoded().toString();
    }
}
