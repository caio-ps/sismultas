package br.com.fiap.sismultas.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * Classe utilitária para trabalhar com criptografia
 * 
 * @author caio-pereira
 *
 */
public class CryptUtil {

	public static String hashMD5(String texto) throws Exception {
		
		//Digester e Charset
		MessageDigest md = MessageDigest.getInstance("MD5");
		Charset charset = Charset.forName("UTF-8");
		
		//Gera HASH em Hexadecimal
		byte[] textoBytes = md.digest(texto.getBytes(charset));
		StringBuilder textoHex = new StringBuilder();
		for (byte b : textoBytes) {
			textoHex.append(String.format("%02X", 0xFF & b));
		}
		
		//Retorna valor String
		return textoHex.toString();
		
	}
	
}
