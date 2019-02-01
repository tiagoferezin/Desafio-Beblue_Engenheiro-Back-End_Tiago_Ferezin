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
import appWS.factory.CashBackFactory;
import appWS.model.entity.Venda;
import appWS.model.entity.factory.VendaFactory;
import appWS.model.repoositories.VendaRepositorio;
import appWS.utils.ManipulacaoDatas;

import com.google.gson.Gson;
import com.wrapper.spotify.model_objects.specification.Album;

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

}
