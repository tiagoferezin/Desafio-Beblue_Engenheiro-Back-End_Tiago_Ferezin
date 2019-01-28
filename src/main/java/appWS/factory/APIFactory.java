/**
 * 
 */
package appWS.factory;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.Category;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.browse.GetListOfCategoriesRequest;

/**
 * @author Tiago Ferezin Data: 26/01/2019
 */
public class APIFactory {

	private static final String CLIENTID = "173dc9c6e90f4a2e987a196c9f1adaf8";
	private static final String CLIENTSECRET = "a658dd16e4a6463a9d5c856aee9155c0";
	private static final String code = "";
	private static final URI redirectURI = SpotifyHttpManager
			.makeUri("http://localhost:8080/Desafio-Beblue_Engenheiro-Back-End_Tiago_Ferezin/home/callback/");

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setClientId(CLIENTID).setClientSecret(CLIENTSECRET).setRedirectUri(redirectURI).build();

	private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi
			.clientCredentials().build();
	private static final AuthorizationCodeRequest authorizationCodeRequest = spotifyApi
			.authorizationCode(code).build();

	private static final GetListOfCategoriesRequest getListOfCategoriesRequest = spotifyApi
			.getListOfCategories().country(CountryCode.BR).limit(50).offset(0)
			.locale("pt_BR").build();

	public static void clientCredentials_Sync() {
		try {
			final ClientCredentials clientCredentials = clientCredentialsRequest
					.execute();

			spotifyApi.setAccessToken(clientCredentials.getAccessToken());

			System.out.println("Expires in: "
					+ clientCredentials.getExpiresIn());
		} catch (IOException | SpotifyWebApiException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void clientCredentials_Async() {
		try {
			final Future<ClientCredentials> clientCredentialsFuture = clientCredentialsRequest
					.executeAsync();

			final ClientCredentials clientCredentials = clientCredentialsFuture
					.get();

			spotifyApi.setAccessToken(clientCredentials.getAccessToken());

			System.out.println("Expires in: "
					+ clientCredentials.getExpiresIn());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
	}

	public static void getListOfCategories_Async() {
		try {

			final Future<AuthorizationCodeCredentials> authorizationCodeCredentialsFuture = authorizationCodeRequest
					.executeAsync();

			// ...

			final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeCredentialsFuture
					.get();
			final Future<Paging<Category>> pagingFuture = getListOfCategoriesRequest
					.executeAsync();

			// ...

			final Paging<Category> categoryPaging = pagingFuture.get();

			System.out.println("Total: " + categoryPaging.getTotal());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
	}

}
