package com.donatoordep.challenge_03.controllers;

import com.donatoordep.challenge_03.dto.PasswordRegisterRequestDTO;
import com.donatoordep.challenge_03.dto.PasswordRegisterResponseDTO;
import com.donatoordep.challenge_03.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/password")
public class PasswordController {

    private final PasswordService service;

    @Autowired
    public PasswordController(PasswordService service) {
        this.service = service;
    }

    @PostMapping(path = "/validate-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PasswordRegisterResponseDTO> insert(@RequestBody PasswordRegisterRequestDTO request) {
        PasswordRegisterResponseDTO response = this.service.insert(request);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(response.id()).toUri()).body(response);
    }
}