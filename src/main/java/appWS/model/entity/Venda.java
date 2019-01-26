/**
 * 
 */
package appWS.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tiago Ferezin Data: 25/01/2019
 */
@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenda;

	@Column(nullable = false)
	private Calendar dataVenda;
	@Column(nullable = false)
	private Double valorTotal;

	@Column(nullable = false)
	private Double cashbackTotal;

	public Venda() {

	}

	/**
	 * @return the idVenda
	 */
	public Long getIdVenda() {
		return idVenda;
	}

	/**
	 * @param idVenda
	 *            the idVenda to set
	 */
	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	/**
	 * @return the dataVenda
	 */
	public Calendar getDataVenda() {
		return dataVenda;
	}

	/**
	 * @param dataVenda
	 *            the dataVenda to set
	 */
	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}

	/**
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 *            the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the cashbackTotal
	 */
	public Double getCashbackTotal() {
		return cashbackTotal;
	}

	/**
	 * @param cashbackTotal
	 *            the cashbackTotal to set
	 */
	public void setCashbackTotal(Double cashbackTotal) {
		this.cashbackTotal = cashbackTotal;
	}

}
