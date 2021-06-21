package com.example.demo.dto;

import lombok.Data;

@Data
public class PublicationWithIdDTO {
    long id;
    String text;
    long id_user;
}
