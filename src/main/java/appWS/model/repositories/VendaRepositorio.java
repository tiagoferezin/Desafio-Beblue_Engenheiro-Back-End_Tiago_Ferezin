/**
 * 
 */
package appWS.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import appWS.model.entity.Venda;

/**
 * @author Tiago Ferezin Data: 26/01/2019
 */
@Repository
public interface VendaRepositorio extends CrudRepository<Venda, Long> {
	
	@Query("SELECT t FROM Venda t ORDER BY t.dataVenda ASC")
	public List<Venda> getVendasPorDataOrdenadaCrescente();
	
}
