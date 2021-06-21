package com.example.demo.service;


import com.example.demo.dto.PublicationDTO;
import com.example.demo.dto.PublicationWithIdDTO;
import com.example.demo.entity.PublicationEntity;

import java.util.List;

public interface PublicationService {
    List<PublicationEntity> getAllPublications();
    PublicationEntity addPublication(PublicationDTO publicationDTO);
    void deleteAnPublication(long publicationId);
    PublicationEntity editPublication(PublicationWithIdDTO publication);
}
