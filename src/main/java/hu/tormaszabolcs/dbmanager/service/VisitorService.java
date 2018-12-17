package hu.tormaszabolcs.dbmanager.service;

import hu.tormaszabolcs.dbmanager.dao.VisitorRepository;
import hu.tormaszabolcs.dbmanager.entity.Visitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorService {

    @Autowired
    VisitorRepository visitorRepository;

    public Collection<Visitor> findAllVisitor() {
        List<Visitor> bridgeList = new ArrayList<Visitor>();
        for (Visitor visitor : visitorRepository.findAll()) {
            bridgeList.add(visitor);
        }
        return bridgeList;
    }

}
