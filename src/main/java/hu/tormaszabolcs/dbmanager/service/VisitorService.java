package hu.tormaszabolcs.dbmanager.service;

import hu.tormaszabolcs.dbmanager.dao.VisitorRepository;
import hu.tormaszabolcs.dbmanager.entity.Comment;
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

    public void deleteVisitorById(long id) {
        visitorRepository.deleteById(id);
    }

    public void updateVisitor(long id, Visitor visitor) {
        Visitor visitorToUpdate = visitorRepository.findById(id).get();
        visitorToUpdate.setName(visitor.getName());
        visitorRepository.save(visitorToUpdate);
    }

    public Long createVisitor(Visitor visitorFromFront, Comment comment) {
        Visitor visitorToCreate = new Visitor();
        Visitor createdVisitor = new Visitor();
        visitorToCreate.setName(visitorFromFront.getName());
        visitorToCreate.setBirthDate(visitorFromFront.getBirthDate());
        visitorToCreate.setComment(comment);
        createdVisitor = visitorRepository.save(visitorToCreate);
        return createdVisitor.getId();
    }
    
    

}
