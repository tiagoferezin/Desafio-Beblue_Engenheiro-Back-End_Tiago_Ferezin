/**
 * 
 */
package appWS.controller;

import java.util.Calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import appWS.factory.APIAlbum;
import appWS.factory.APICategorias;
import appWS.factory.APIFactory;
import appWS.utils.ManipulacaoDatas;

/**
 * @author Tiago Ferezin Data: 27/01/2019
 */
@RestController
@RequestMapping("/home")
public class HomeController {

	public HomeController() {
		System.out
				.println("Iniciou Home!!!"
						+ "URL: http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/home/buscar/");
	}

	@RequestMapping(value = "/buscar/", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String buscar() {

		String retorno = "";
		String e = ManipulacaoDatas.getDiaDaSemana(Calendar.getInstance());
		APIFactory.clientCredentials_Async();

		String retornoCat = APICategorias.getListOfCategories_Async();
		retorno = APIAlbum.getSeveralAlbums_Async();
		return retorno;

	}

}
