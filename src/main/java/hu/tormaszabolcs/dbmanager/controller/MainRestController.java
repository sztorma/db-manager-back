package hu.tormaszabolcs.dbmanager.controller;

import hu.tormaszabolcs.dbmanager.entity.Visitor;
import hu.tormaszabolcs.dbmanager.service.CommentService;
import hu.tormaszabolcs.dbmanager.service.VisitorService;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/visitor")
public class MainRestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    VisitorService visitorService;
    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody
    Collection<Visitor> getVisitors() {
        return visitorService.findAllVisitor();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteVisitor(@PathVariable long id) {
        visitorService.deleteVisitorById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = {"application/json"}, consumes = {"application/json"})
    @ResponseStatus(value = HttpStatus.OK)
    public void updateVisitor(@PathVariable long id, @RequestBody Visitor visitor) {
        long commentIdForName = commentService.nameFinder(visitor.getName());
        visitorService.updateVisitor(id, visitor, commentService.findById(commentIdForName));
    }

    @RequestMapping(method = RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
    @ResponseStatus(value = HttpStatus.CREATED)
    public String createVisitor(@RequestBody Visitor visitor) {
        log.info("kreálás metódus elkezdődött");
        long commentIdForName = commentService.nameFinder(visitor.getName());
        return visitorService.createVisitor(visitor, commentService.findById(commentIdForName)).toString();
    }

}
