/**
 * 
 */
package appWS.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import appWS.factory.APIFactory;

import com.google.gson.Gson;

/**
 * @author Tiago Ferezin
 * Data: 27/01/2019
 */
@RestController
@RequestMapping("/home")
public class HomeController {
	
	public HomeController(){
		System.out.println("Iniciou Home!!!");
	}
	
	@RequestMapping(value = "/buscar/", method = RequestMethod.GET, headers = "Accept=appliation/json")
	@ResponseBody
	public String buscar(){
		
		String retorno = "";
		Gson gson = new Gson();
		APIFactory.clientCredentials_Async();
		APIFactory.getListOfCategories_Async();
		return null;
		
	}

}
