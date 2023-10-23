package tn.esprit.reclamation_ms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.reclamation_ms.Entities.Discussion;
import tn.esprit.reclamation_ms.Entities.Reclamation;
import tn.esprit.reclamation_ms.Entities.Status;
import tn.esprit.reclamation_ms.Interfaces.IDiscussion;
import tn.esprit.reclamation_ms.Repositories.DiscussionRepository;
import tn.esprit.reclamation_ms.Repositories.ReclamationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DiscussionService implements IDiscussion {
    @Autowired
    DiscussionRepository discussionRepo;
    @Autowired
    ReclamationRepository reclamationRepository;

    @Override
    public ResponseEntity<Discussion> createDiscussion(Discussion discussion, Long id) {
        try {
            Reclamation reclamation = reclamationRepository.findById(id).orElse(null);
            if (reclamation.getStatus().toString().equals("Traite")){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            //User user= userService.getLoggedUser();
            //discussion.setUser(user);
            discussion.setReclamation(reclamation);
            discussion.setDate(LocalDateTime.now());
            reclamation.setStatus(Status.En_Cours_De_Traitement);
            reclamationRepository.save(reclamation);
            discussionRepo.save(discussion);

            return  new ResponseEntity<>(discussion, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Discussion>> getAllByReclamation(Long id) {
        try {
            Reclamation reclamation = reclamationRepository.findById(id).orElse(null);
            List<Discussion> discussions = discussionRepo.findAllByReclamationOrderByDate(reclamation);
            return new ResponseEntity<>(discussions,HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
