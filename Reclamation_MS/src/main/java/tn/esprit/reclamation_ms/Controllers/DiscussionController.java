package tn.esprit.reclamation_ms.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.reclamation_ms.Entities.Discussion;
import tn.esprit.reclamation_ms.Interfaces.IDiscussion;

import java.util.List;

@RestController
@RequestMapping("/Discussion")
public class DiscussionController {
    @Autowired
    IDiscussion iDiscussion;
    @PostMapping("/add/{id}")
    public ResponseEntity<Discussion> createDiscussion(@RequestBody Discussion discussion, @PathVariable Long id) {
        return iDiscussion.createDiscussion(discussion,id);
    }

    @GetMapping("/getAllByReclamation/{id}")
    public ResponseEntity<List<Discussion>> getAllByReclamation(@PathVariable("id") Long id) {
        return iDiscussion.getAllByReclamation(id);
    }
}
