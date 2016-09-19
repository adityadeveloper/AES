import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class EncDesc {

	    public String encrypt(String input, String key) {
	       byte[] crypted = null;
	       try {
	            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, skey);
	            crypted = cipher.doFinal(input.getBytes());
	            } 
	       catch (Exception e) 
	       		  {
	    	   		System.out.println("Exception in Encrypt");
	              }
	              return new String(org.apache.commons.codec.binary.Base64.encodeBase64(crypted));
	       }

	       public String decrypt(String input, String key) throws IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException  {
	              byte[] output = null;
	              SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	              Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	              cipher.init(Cipher.DECRYPT_MODE, skey);
	              output = cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(input));
	              return new String(output);
	       }

	       public static void main(String args[]){
	    		EncDesc a = new EncDesc();
	    		String key = "fedcba9876543210";
	    		String myname = "Aditya";
	    		String enc = a.encrypt(myname,key);
	    		System.out.println("Encrypted value = "+enc);
	    		try{
	    		System.out.println("Decrypted value = "+a.decrypt(enc,key));
	    		}
	    		catch (Exception e){
	    			System.out.println("Exception occured");
	    		}
	    	}       
	

}
