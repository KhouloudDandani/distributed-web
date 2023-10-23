package tn.esprit.reclamation_ms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esprit.reclamation_ms.Entities.Discussion;
import tn.esprit.reclamation_ms.Entities.Reclamation;
import tn.esprit.reclamation_ms.Entities.Status;
import tn.esprit.reclamation_ms.Interfaces.IReclamation;
import tn.esprit.reclamation_ms.Repositories.DiscussionRepository;
import tn.esprit.reclamation_ms.Repositories.ReclamationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService implements IReclamation {
    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    DiscussionRepository discussionRepository;

    @Override
    public ResponseEntity<Reclamation> createReclamation(Reclamation reclamation) {
        try {
            reclamation.setStatus(Status.Non_Traite);
            reclamation.setDate(LocalDateTime.now());
            Reclamation rec=reclamationRepository.save(reclamation);

            Discussion discussion = new Discussion();
            discussion.setReclamation(rec);
            discussion.setMsg(rec.getMessage());
            //discussion.setUser(user);
            discussion.setDate(LocalDateTime.now());
            discussionRepository.save(discussion);
            return new ResponseEntity<>(reclamation, HttpStatus.CREATED);

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteReclamation(Long id) {
        try {
            reclamationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Reclamation> updateReclamation(Long id, Reclamation reclamation) {
        Optional<Reclamation> reclamationOptional = reclamationRepository.findById(id);
        if (reclamationOptional.isPresent()) {
            Reclamation _reclamation = reclamationOptional.get();
            _reclamation.setObject(reclamation.getObject());
            _reclamation.setMessage(reclamation.getMessage());
            reclamationRepository.save(_reclamation);
            return new ResponseEntity<>(_reclamation,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        try {
            List<Reclamation>reclamations=reclamationRepository.findAll();
            if (reclamations.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else {
                return new ResponseEntity<>(reclamations,HttpStatus.OK);
            }
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Reclamation>> getAllReclamationsByStatus(Status status) {
        try {
            List<Reclamation> reclamation = reclamationRepository.findAllByStatus(status);
            return new ResponseEntity<>(reclamation,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Integer> countAllByStatus(Status status) {
        try {
            int i= reclamationRepository.countAllByStatus(status);
            return new ResponseEntity<>(i,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
