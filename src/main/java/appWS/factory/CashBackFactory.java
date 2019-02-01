/**
 * 
 */
package appWS.factory;

import java.util.List;

/**
 * @author Tiago Ferezin Data: 01/02/2019
 */
public class CashBackFactory {

	public Double getPorcentagem(String diaDaSemana, String genero) {
		Double retorno = 0D;
		genero = genero.toUpperCase();
		diaDaSemana = diaDaSemana.toUpperCase();
		if (genero.equals("POP")) {
			if (diaDaSemana.equals("SEGUNDA-FEIRA")) {
				retorno = 0.07;
			} else if (diaDaSemana.equals("TERÇA-FEIRA")) {
				retorno = 0.06;
			} else if (diaDaSemana.equals("QUARTA-FEIRA")) {
				retorno = 0.02;
			} else if (diaDaSemana.equals("QUINTA-FEIRA")) {
				retorno = 0.1;
			} else if (diaDaSemana.equals("SEXTA-FEIRA")) {
				retorno = 0.15;
			} else if (diaDaSemana.equals("SÁBADO")) {
				retorno = 0.2;
			} else if (diaDaSemana.equals("DOMINGO")) {
				retorno = 0.25;
			}
		} else if (genero.equals("MPB")) {
			if (diaDaSemana.equals("SEGUNDA-FEIRA")) {
				retorno = 0.05;
			} else if (diaDaSemana.equals("TERÇA-FEIRA")) {
				retorno = 0.1;
			} else if (diaDaSemana.equals("QUARTA-FEIRA")) {
				retorno = 0.15;
			} else if (diaDaSemana.equals("QUINTA-FEIRA")) {
				retorno = 0.2;
			} else if (diaDaSemana.equals("SEXTA-FEIRA")) {
				retorno = 0.25;
			} else if (diaDaSemana.equals("SÁBADO")) {
				retorno = 0.3;
			} else if (diaDaSemana.equals("DOMINGO")) {
				retorno = 0.3;
			}
		} else if (genero.equals("CLASSIC")) {
			if (diaDaSemana.equals("SEGUNDA-FEIRA")) {
				retorno = 0.03;
			} else if (diaDaSemana.equals("TERÇA-FEIRA")) {
				retorno = 0.05;
			} else if (diaDaSemana.equals("QUARTA-FEIRA")) {
				retorno = 0.08;
			} else if (diaDaSemana.equals("QUINTA-FEIRA")) {
				retorno = 0.13;
			} else if (diaDaSemana.equals("SEXTA-FEIRA")) {
				retorno = 0.18;
			} else if (diaDaSemana.equals("SÁBADO")) {
				retorno = 0.25;
			} else if (diaDaSemana.equals("DOMINGO")) {
				retorno = 0.35;
			}
		} else if (genero.equals("ROCK")) {
			if (diaDaSemana.equals("SEGUNDA-FEIRA")) {
				retorno = 0.1;
			} else if (diaDaSemana.equals("TERÇA-FEIRA")) {
				retorno = 0.15;
			} else if (diaDaSemana.equals("QUARTA-FEIRA")) {
				retorno = 0.15;
			} else if (diaDaSemana.equals("QUINTA-FEIRA")) {
				retorno = 0.15;
			} else if (diaDaSemana.equals("SEXTA-FEIRA")) {
				retorno = 0.2;
			} else if (diaDaSemana.equals("SÁBADO")) {
				retorno = 0.4;
			} else if (diaDaSemana.equals("DOMINGO")) {
				retorno = 0.4;
			}
		}

		return retorno;
	}

	public Double getValorCashBack(Double valorDaVendaDoAlbum,
			Double porcentagem) {
		Double retorno = 0D;
		retorno = valorDaVendaDoAlbum * porcentagem;
		return retorno;
	}

	public Double getTotalCashBack(List<Double> listaValoresCashNack) {
		Double retorno = 0D;

		for (Double valor : listaValoresCashNack) {
			retorno = retorno + valor;
		}

		return retorno;
	}

}
