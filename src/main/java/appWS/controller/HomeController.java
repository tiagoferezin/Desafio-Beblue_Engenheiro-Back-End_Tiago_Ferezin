/**
 * 
 */
package appWS.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import appWS.factory.APICategorias;
import appWS.factory.APIFactory;
import appWS.utils.ManipulacaoDatas;

import com.google.gson.Gson;

/**
 * @author Tiago Ferezin Data: 27/01/2019
 */
@RestController
@RequestMapping("/home")
public class HomeController {

	public HomeController() {
		System.out.println("Iniciou Home!!!");
	}

	@RequestMapping(value = "/buscar/", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String buscar() {

		String retorno = "";
		String e = ManipulacaoDatas.getDiaDaSemana(Calendar.getInstance());
		APIFactory.clientCredentials_Async();

		retorno = APICategorias.getListOfCategories_Async();
		return retorno;

	}

}
