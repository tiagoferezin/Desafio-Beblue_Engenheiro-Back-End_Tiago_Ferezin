/**
 * 
 */
package appWS.utils;

import java.util.Calendar;

import org.joda.time.DateTime;

/**
 * @author Tiago Ferezin
 * Data: 28/01/2019
 */
public class ManipulacaoDatas {

	public static String getDiaDaSemana(Calendar data){
		String retorno = "";
		DateTime dateTime = new DateTime(data);
		
		retorno = dateTime.dayOfWeek().getAsText();
		
		return retorno;
	}
	
}
