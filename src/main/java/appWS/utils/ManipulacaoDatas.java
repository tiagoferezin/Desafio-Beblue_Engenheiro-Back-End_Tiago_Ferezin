/**
 * 
 */
package appWS.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Minutes;
import org.joda.time.Months;

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
	
	public static Boolean isDataInseridaMaiorQueDataAtual(
			Calendar dataInserida, Calendar dataAtual) {
		Boolean retorno = false;

		try {
			DateTime data1 = new DateTime(dataInserida);
			DateTime data2 = new DateTime(dataAtual);

			Integer qtdDias = Days.daysBetween(data1, data2).getDays();
			if (qtdDias < 0) {
				retorno = true;
			} else {
				retorno = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}
	
	public static Boolean isDataInseridaMenorQueDataAtual(
			Calendar dataInserida, Calendar dataAtual) {
		Boolean retorno = false;

		try {
			DateTime data1 = new DateTime(dataInserida);
			DateTime data2 = new DateTime(dataAtual);

			Integer qtdDias = Days.daysBetween(data1, data2).getDays();
			if (qtdDias > 0) {
				retorno = true;
			} else {
				retorno = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

	public static Integer qtdDiasEntreDatas(Calendar dataInicial,
			Calendar dataFinal) {
		Integer retorno = 0;

		try {
			DateTime data1 = new DateTime(dataInicial);
			DateTime data2 = new DateTime(dataFinal);
			retorno = Days.daysBetween(data1, data2).getDays();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return retorno;
	}

	public static Boolean isMesmoMes(Calendar dataPesquisa,
			Calendar dataInserida) {
		Boolean result = false;

		try {
			DateTime data1 = new DateTime(dataPesquisa);
			DateTime data2 = new DateTime(dataInserida);
			Integer meses = 0;

			meses = Months.monthsBetween(data1, data2).getMonths();

			if (meses == 0) {
				result = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;

	}

	public static Map<String, String> pegarStringDaData(Calendar data) {
		Map<String, String> result = new HashMap<String, String>();

		return result;

	}

	public static Integer minutosEntreCalendar(Calendar dataInicial,
			Calendar dataFinal) {
		Integer retorno = 0;

		try {
			DateTime data1 = new DateTime(dataInicial);
			DateTime data2 = new DateTime(dataFinal);
			retorno = Minutes.minutesBetween(data1, data2).getMinutes();

		} catch (Exception e) {
			// TODO: handle exception
		}

		return retorno;
	}

	public static Calendar convertStringDataToCalendar(String data) {

		Calendar retorno = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			retorno.setTime(sdf.parse(data));
		} catch (Exception e) {
			// TODO: handle exception
		}

		return retorno;
	}
	
}
