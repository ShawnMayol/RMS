package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordEncryption {
    // Method to hash the password with SHA-256 and a salt
    public static String hashPassword(String password) {
        try {
            // Generate a random salt
            SecureRandom secureRandom = new SecureRandom();
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            
            // Combine password and salt
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(salt);  // Adding salt to the digest
            byte[] hashedBytes = digest.digest(password.getBytes());

            // Convert bytes to hex format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Convert the salt to hex and append it to the hashed password
            String saltHex = bytesToHex(salt);
            return saltHex + ":" + hexString.toString();  // Store salt and hash together

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Convert byte array to Hex string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Method to verify the password by comparing stored hash and input password
    public static boolean verifyPassword(String password, String storedHash) {
        String[] parts = storedHash.split(":");
        String storedSalt = parts[0];
        String storedHashValue = parts[1];

        try {
            // Recreate the hash with the stored salt
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] saltBytes = hexToBytes(storedSalt);
            digest.update(saltBytes);  // Use the stored salt
            byte[] hashedBytes = digest.digest(password.getBytes());

            // Convert the byte array to hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Compare the stored hash with the newly computed hash
            return storedHashValue.equals(hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Convert Hex string to byte array
    public static byte[] hexToBytes(String hex) {
        int length = hex.length();
        byte[] bytes = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bytes[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return bytes;
    }

    public static void main(String[] args) {
        String plainPassword = "nimda";  // The plain password you want to encrypt
        String hashedPassword = hashPassword(plainPassword);  // Hash the password

        System.out.println("Encrypted Password: " + hashedPassword);  // Print the hashed password

        // Verify the password
        boolean isVerified = verifyPassword("nimda", hashedPassword);
        System.out.println("Password verification result: " + isVerified);
    }
}
