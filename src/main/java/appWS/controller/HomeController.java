/**
 * 
 */
package appWS.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import appWS.factory.APIAlbum;
import appWS.factory.APICategorias;
import appWS.factory.APIFactory;
import appWS.model.entity.Venda;
import appWS.model.entity.factory.VendaFactory;
import appWS.model.repoositories.VendaRepositorio;
import appWS.utils.ManipulacaoDatas;

import com.google.gson.Gson;

/**
 * @author Tiago Ferezin Data: 27/01/2019
 */
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	VendaRepositorio vendaRepositorio;

	public HomeController() {
		System.out
				.println("Iniciou Home!!!"
						+ "URL: http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/home/buscar/");
	}

	@RequestMapping(value = "/buscar/", method = RequestMethod.GET)
	@ResponseBody
	public String buscar() {

		String retorno = "";
		String e = ManipulacaoDatas.getDiaDaSemana(Calendar.getInstance());
		APIFactory.clientCredentials_Async();

		String retornoCat = APICategorias.getListOfCategories_Async();
		retorno = APIAlbum.getSeveralAlbums_Async();
		return retorno;

	}

	@RequestMapping(value = "/venda/{idVenda}", method = RequestMethod.GET)
	@ResponseBody
	public String vendaPeloId(Long idVenda) {
		String retorno = "";

		Venda venda = new Venda();
		venda = vendaRepositorio.findOne(idVenda);

		Gson gson = new Gson();
		retorno = gson.toJson(venda);
		return retorno;
	}

	@RequestMapping(value = "/vendasEntreDatas/{dataInicial}-{dataFinal}", method = RequestMethod.GET)
	@ResponseBody
	public String listarVendas(String dataInicial, String dataFinal) {
		String retorno = "";

		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		Calendar calInicial = Calendar.getInstance();
		Calendar calFinal = Calendar.getInstance();
		List<Venda> listaVendasPorOrdemData = new ArrayList<Venda>();
		VendaFactory vf = new VendaFactory();
		try {
			if (dataInicial != "") {
				calInicial.setTime(sdf.parse(dataInicial));
			}
			if (dataFinal != "") {
				calFinal.setTime(sdf.parse(dataFinal));
			}
			listaVendasPorOrdemData = vf.getListaVendasPorDataOrdenada(
					calInicial, calFinal, vendaRepositorio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		retorno = gson.toJson(listaVendasPorOrdemData);
		return retorno;
	}

	@RequestMapping(value = "/adicionarVenda/", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarVenda(@RequestBody Venda venda) {

		Venda vendaPesquisa = new Venda();
		Long idVenda = venda.getIdVenda();
		vendaPesquisa = vendaRepositorio.findOne(idVenda);
		
		if((vendaPesquisa!=null)&&(vendaPesquisa.getIdVenda()>0L)){
			vendaRepositorio.save(vendaPesquisa); //UPDATE
		}else{
			vendaRepositorio.save(venda); //INSERT
		}

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
