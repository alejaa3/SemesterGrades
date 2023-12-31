package co.edu.unbosque.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static org.apache.commons.codec.binary.Base64.encodeBase64;
import static org.apache.commons.codec.binary.Base64.decodeBase64;

public class AESUtil { //algoritmo simétrico

	private static final String ALGORITHM="AES";
	private static final String CIPHETR_TYPE="AES/CBC/PKCS5Padding";
	/*
	public static void main(String[] args) {
		System.out.println(encrypt("tiburoncin uh ha ha"));
		System.out.println(decrypt(encrypt("tiburoncin uh ha ha")));
	}
	*/
	public static String encrypt(String text) {
		String iv="qwertyuiopasdfgh"; //obligatoriamente con 16 bytes(caracteres)
		String key="llavede16caracte";
		
		return encrypt(key, iv, text);
	}
	public static String decrypt(String text) {
		String iv="qwertyuiopasdfgh"; //obligatoriamente con 16 bytes(caracteres)
		String key="llavede16caracte";
		
		return decrypt(key, iv, text);
	}
	
	public static String encrypt(String key, String iv, String text) {
		Cipher cipher =null;
			try {
				cipher=Cipher.getInstance(CIPHETR_TYPE);
			} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		SecretKeySpec secretKeySpec=new SecretKeySpec (key.getBytes(), ALGORITHM);
		IvParameterSpec ivParameterSpec=new IvParameterSpec(iv.getBytes());
		
			try {
				cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		byte[]encripted=null;
		try {
			encripted=cipher.doFinal(text.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(encodeBase64(encripted));
	}
	
	public static String decrypt(String key, String iv, String text){
		Cipher cipher =null;
		try {
			cipher=Cipher.getInstance(CIPHETR_TYPE);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	SecretKeySpec secretKeySpec=new SecretKeySpec (key.getBytes(), ALGORITHM);
	IvParameterSpec ivParameterSpec=new IvParameterSpec(iv.getBytes());
	
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	byte[]encripted=decodeBase64(text);
	byte[]decrypted=null;
	try {
		decrypted=cipher.doFinal(encripted);
	} catch (IllegalBlockSizeException | BadPaddingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new String(decrypted);
	}
	
	
}
