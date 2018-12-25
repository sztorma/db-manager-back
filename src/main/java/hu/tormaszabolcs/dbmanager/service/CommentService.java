package hu.tormaszabolcs.dbmanager.service;

import hu.tormaszabolcs.dbmanager.dao.CommentRepository;
import hu.tormaszabolcs.dbmanager.entity.Comment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Collection<Comment> findAllComment() {
        List<Comment> tempList = new ArrayList<Comment>();
        for (Comment comment : commentRepository.findAll()) {
            tempList.add(comment);
        }
        return tempList;
    }

    public Comment findById(long id) {
        return commentRepository.findById(id).get();
    }

    public long nameFinder(String nameToSearch) {
        ArrayList<Comment> tempCommentList = (ArrayList) findAllComment();
        int i = 0;
        while (i < tempCommentList.size() && !nameToSearch.toLowerCase().equals(tempCommentList.get(i).getCommentedName().toLowerCase())) {
            i++;
        }
        return (i < tempCommentList.size() ? (i + 1) : 3);
    }

}
