package br.com.fiap.sismultas.util;

import com.thoughtworks.xstream.XStream;

/**
 * Classe para manipulacao de XMLs
 * 
 * @author caio-pereira
 *
 */
public class XMLUtil {

	private static XStream xstream;
	
	static {
		xstream = new XStream();
	}
	
	/**
	 * serializa objeto em XML
	 * 
	 * @param obj
	 * @return
	 */
	public static String marshall(Object obj) {
		return xstream.toXML(obj);
	}
	
	/**
	 * serializa objeto em XML de acordo com os aliases
	 * passados como parâmetro
	 * 
	 * @param obj
	 * @param aliases
	 * @return
	 */
	public static String marshall(Object obj, String[][] aliases) {
		
		for (int i = 0; i < aliases.length; i++) {
			
			try {
				xstream.alias(aliases[i][0], Class.forName(aliases[i][1]));
			} catch (ClassNotFoundException e) {
			}
			
		}
		
		return xstream.toXML(obj);
	}

}
