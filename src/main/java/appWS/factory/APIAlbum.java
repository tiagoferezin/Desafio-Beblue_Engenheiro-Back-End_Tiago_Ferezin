/**
 * 
 */
package appWS.factory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.google.gson.Gson;
import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;
import com.wrapper.spotify.requests.data.albums.GetSeveralAlbumsRequest;

/**
 * @author Tiago Ferezin Data: 28/01/2019
 */
public class APIAlbum {

	private static final String[] ids = new String[] {
			"382ObEPsp2rxGrnsizN5TX", "1A2GTWGtFfWp7KSQTwWOyo",
			"2noRn2Aes5aoNVsU6iWThc" };

	private static final String accessToken = APIFactory.getAccessToken();

	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setAccessToken(accessToken).build();

	private static final GetSeveralAlbumsRequest getSeveralAlbumsRequest = spotifyApi
			.getSeveralAlbums(ids).market(CountryCode.BR).build();

	public static String getAlbumPorId(String idAlbum) {
		String retorno = "";

		try {
			final GetAlbumRequest getAlbumRequest = spotifyApi
					.getAlbum(idAlbum).market(CountryCode.BR).build();

			final Future<Album> albumFuture = getAlbumRequest.executeAsync();

			final Album album = albumFuture.get();

			Gson gson = new Gson();
			retorno = gson.toJson(album);

			System.out.println("Nome disco: " + album.getName());

		} catch (InterruptedException | ExecutionException e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getCause().getMessage());
		}

		return retorno;
	}

	public static String getSeveralAlbums_Async() {
		String retorno = "";
		try {
			final Future<Album[]> albumsFuture = getSeveralAlbumsRequest
					.executeAsync();

			// ...

			final Album[] albums = albumsFuture.get();

			Gson gson = new Gson();
			retorno = gson.toJson(albums);

			System.out.println("Length: " + albums.length);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Error: " + e.getCause().getMessage());
		}
		return retorno;
	}

}
