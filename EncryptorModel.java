package Ch8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * An encryptor encrypts files using the Caesar cipher.
 * For decryption, use an encryptor whose key is the
 * negative of the encryption key.
 */
public class EncryptorModel {
   private final boolean verbose = true;
   private int key;
   private String possKey;
   private String e = "271828182845904523536028747135266249775724709369995";

   /**
    * Constructs an encryptor.
    * 
    * @param aKey the encryption key
    */
   public EncryptorModel() {
   }

   /**
    * Encrypts the contents of a file.
    * 
    * @param inFile  the input file
    * @param outFile the output file
    */
   public void encryptFile(File inFile, File outFile, String possKey)
         throws IOException {
      InputStream in = null;
      OutputStream out = null;

      try {
         in = new FileInputStream(inFile);
         out = new FileOutputStream(outFile);
         encryptStream(in, out);
      } finally {
         if (in != null)
            in.close();
         if (out != null)
            out.close();
      }
   }

   /**
    * Encrypts the contents of a stream.
    * 
    * @param in      the input stream
    * @param out     the output stream
    * @param possKey the integer as String to be used as key to encrypt
    */
   public void encryptStream(InputStream in, OutputStream out)
         throws IOException {
      boolean done = false;
      int i = 0;
      while (!done) {
         int next = in.read();
         if (next == -1)
            done = true;
         else {

            byte b = (byte) next;
            possKey = e.substring(i, i + 1);
            byte c = encrypt(b, possKey);
            out.write(c);
            i++;
            if (i == e.length()) {
               i = 0;
               System.out.println("The key is " + key + " END ");
            }
            if (verbose && key != 5)
               System.out.println("The Key is " + key);

         }
      }
      // display in console

   }

   /**
    * Encrypts a byte.
    * 
    * @param b       the byte to encrypt
    * @param possKey the integer as String to be used as key to encrypt
    * @return the encrypted byte
    */
   public byte encrypt(byte b, String possKey) {
      key = Integer.parseInt(possKey);
      return (byte) (b + key);
   }

}
