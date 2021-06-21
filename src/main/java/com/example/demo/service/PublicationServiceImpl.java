package com.example.demo.service;

import com.example.demo.dto.PublicationDTO;
import com.example.demo.dto.PublicationWithIdDTO;
import com.example.demo.entity.PublicationEntity;
import com.example.demo.repository.PublicationRepository;
import com.example.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService{

    private final PublicationRepository publicationRepository;
    private final UserRepository userRepository;

    public PublicationServiceImpl(PublicationRepository publicationRepository, UserRepository userRepository) {
        this.publicationRepository = publicationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PublicationEntity addPublication(PublicationDTO publicationDTO) {
        var publicationEntity = new PublicationEntity();

        publicationEntity.setText(publicationDTO.getText());
        publicationEntity.setUserEntity(userRepository.getById(publicationDTO.getId_user()));

        return publicationRepository.save(publicationEntity);
    }

    @Override
    public void deleteAnPublication(long publicationId) {
        publicationRepository.deleteById(publicationId);
    }

    @Override
    public PublicationEntity editPublication(PublicationWithIdDTO publication) {
        var originalPublication = publicationRepository.getById(publication.getId());

        originalPublication.setText(publication.getText());
        originalPublication.setUserEntity(userRepository.getById(publication.getId_user()));

        return publicationRepository.save(originalPublication);
    }

    public List<PublicationEntity> getAllPublications() {
        return publicationRepository.findAll();
    }
}
