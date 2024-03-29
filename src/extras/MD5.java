package extras;

//source = http://tech.chitgoks.com/2008/04/09/java-encrypt-string-using-md5/
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	protected static String hex(byte[] array) {
	  StringBuffer sb = new StringBuffer();
	  for (int i = 0; i < array.length; ++i) {
	    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1,3));
	  }
	  return sb.toString();
	}

	public static String encrypt(String message) { 
	  try { 
	    MessageDigest md = MessageDigest.getInstance("MD5"); 
	    return hex (md.digest(message.getBytes("CP1252"))); 
	  } catch (NoSuchAlgorithmException e) { } catch (UnsupportedEncodingException e) { } 
	  return null;
	}

	public void close() throws Throwable {
		this.finalize();
	}

}