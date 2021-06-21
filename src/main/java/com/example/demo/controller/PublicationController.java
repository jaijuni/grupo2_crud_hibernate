package com.example.demo.controller;

import com.example.demo.dto.PublicationDTO;
import com.example.demo.dto.PublicationWithIdDTO;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.PublicationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    private final PublicationServiceImpl publicationService;

    public PublicationController(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping
    public ResponseEntity<PublicationEntity> addPublication(@RequestBody PublicationDTO publication) {
        PublicationEntity newPublication = publicationService.addPublication(publication);
        return new ResponseEntity<>(newPublication, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PublicationEntity>> getAllPublications() {
        try {
            return new ResponseEntity<List<PublicationEntity>>(publicationService.getAllPublications(), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAPublication(@PathVariable long id) {
        try {
            publicationService.deleteAnPublication(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity editAPublication(@RequestBody PublicationWithIdDTO publication) {
        try {
            return new ResponseEntity(publicationService.editPublication(publication), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
