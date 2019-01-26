/**
 * 
 */
package appWS.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 26/01/2019
 */
@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlbum;

	private String idAlbumSpotfy;
	private String genero;

	@Column(nullable = false)
	private String nome;

	public Album() {

	}

	/**
	 * @return the idAlbum
	 */
	public Long getIdAlbum() {
		return idAlbum;
	}

	/**
	 * @param idAlbum
	 *            the idAlbum to set
	 */
	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}

	/**
	 * @return the idAlbumSpotfy
	 */
	public String getIdAlbumSpotfy() {
		return idAlbumSpotfy;
	}

	/**
	 * @param idAlbumSpotfy
	 *            the idAlbumSpotfy to set
	 */
	public void setIdAlbumSpotfy(String idAlbumSpotfy) {
		this.idAlbumSpotfy = idAlbumSpotfy;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
