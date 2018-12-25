
package hu.tormaszabolcs.dbmanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    @Column(name = "commented_visitorname")
    private String commentedName;
    @Column(name = "comment_text")
    private String commentText;
    @JsonBackReference
    @OneToMany(mappedBy = "comment")
    private List<Visitor> visitors;
    
    public Comment(){}

    public Comment(String commentText) {
        this.commentText = commentText;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public List<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    public String getCommentedName() {
        return commentedName;
    }

    public void setCommentedName(String commentedName) {
        this.commentedName = commentedName;
    }
}
