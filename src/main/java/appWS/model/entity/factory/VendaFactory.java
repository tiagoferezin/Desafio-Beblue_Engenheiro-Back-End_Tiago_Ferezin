/**
 * 
 */
package appWS.model.entity.factory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import appWS.model.entity.Venda;
import appWS.model.repositories.VendaRepositorio;
import appWS.utils.ManipulacaoDatas;

/**
 * @author Tiago Ferezin Data: 26/01/2019
 */
public class VendaFactory {

	public List<Venda> getListaVendasPorDataOrdenada(Calendar dataInicial,
			Calendar dataFinal, VendaRepositorio vendaRepositorio) {
		List<Venda> retorno = new ArrayList<Venda>();

		List<Venda> vendas = new ArrayList<Venda>();
		vendas = vendaRepositorio.getVendasPorDataOrdenadaCrescente();

		if ((dataInicial != null) && (dataFinal != null)) {

			for (int i = 0; i < vendas.size(); i++) {
				Calendar dataVenda = Calendar.getInstance();
				Venda venda = new Venda();
				venda = vendas.get(i);
				dataVenda = venda.getDataVenda();
				if (ManipulacaoDatas.isDataInseridaMenorQueDataAtual(dataVenda,
						dataFinal)) {

					if (ManipulacaoDatas.isDataInseridaMaiorQueDataAtual(
							dataVenda, dataInicial)) {

						retorno.add(venda);

					}

				}

			}
		} else {
			retorno = vendas;
		}

		return retorno;
	}

	public Double valorTotalVenda(List<Double> listaValores) {
		Double retorno = 0D;

		for (Double valor : listaValores) {
			retorno = retorno + valor;
		}

		return retorno;
	}

}
