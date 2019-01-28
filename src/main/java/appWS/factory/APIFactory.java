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
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.browse.GetListOfCategoriesRequest;

/**
 * @author Tiago Ferezin Data: 26/01/2019
 */
public class APIFactory {

	private static final String CLIENTID = "173dc9c6e90f4a2e987a196c9f1adaf8";
	private static final String CLIENTSECRET = "a658dd16e4a6463a9d5c856aee9155c0";
	// private static final String code = "";
	private static final URI redirectURI = SpotifyHttpManager
			.makeUri("https://example.com/spotify-redirect");

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setClientId(CLIENTID).setClientSecret(CLIENTSECRET)
			.setRedirectUri(redirectURI).build();

	private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi
			.clientCredentials().build();
	// private static final AuthorizationCodeRequest authorizationCodeRequest =
	// spotifyApi
	// .authorizationCode(code).build();

	private static final GetListOfCategoriesRequest getListOfCategoriesRequest = spotifyApi
			.getListOfCategories().country(CountryCode.BR).limit(50).offset(0)
			.locale("pt_BR").build();

	public static String getAccessToken() {
		String retorno = "";
		try {
			final ClientCredentials clientCredentials = clientCredentialsRequest
					.execute();
			retorno = clientCredentials.getAccessToken();
		} catch (IOException | SpotifyWebApiException e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
		return retorno;
	}

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
			// spotifyApi.builder();

			System.out.println("Expires in: "
					+ clientCredentials.getExpiresIn());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
	}

}
