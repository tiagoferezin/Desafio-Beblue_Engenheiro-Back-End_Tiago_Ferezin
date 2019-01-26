/**
 * 
 */
package appWS.model.repoositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import appWS.model.entity.Venda;

/**
 * @author Tiago Ferezin Data: 26/01/2019
 */
@Repository
public interface VendaRepositorio extends CrudRepository<Venda, Long> {

}
