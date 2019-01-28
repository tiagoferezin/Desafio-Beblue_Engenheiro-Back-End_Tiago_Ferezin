/**
 * 
 */
package appWS.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.gson.Gson;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Category;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.browse.GetListOfCategoriesRequest;

/**
 * @author Tiago Ferezin Data: 28/01/2019
 */
public class APICategorias {

	private static final String accessToken = APIFactory.getAccessToken();

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setAccessToken(accessToken).build();

	private static final GetListOfCategoriesRequest getListOfCategoriesRequest = spotifyApi
			.getListOfCategories().country(CountryCode.BR).limit(50).offset(0)
			.locale("pt_BR").build();

	public static String getListOfCategories_Async() {
		String retorno = "";
		try {

			final Future<Paging<Category>> pagingFuture = getListOfCategoriesRequest
					.executeAsync();

			final Paging<Category> categoryPaging = pagingFuture.get();
			Category[] lista = categoryPaging.getItems();
			for (Category categoria : lista) {
				
			}
			
			Gson gson = new Gson();
			retorno = gson.toJson(categoryPaging);

			System.out.println("Total: " + categoryPaging.getTotal());

			System.out.println("Json: " + retorno);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
		return retorno;
	}

}
