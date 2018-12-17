
package hu.tormaszabolcs.dbmanager.dao;

import hu.tormaszabolcs.dbmanager.entity.Visitor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends CrudRepository<Visitor, Long>{
    
    
}
