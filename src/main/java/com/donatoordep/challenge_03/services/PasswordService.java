package com.donatoordep.challenge_03.services;

import com.donatoordep.challenge_03.dto.PasswordRegisterRequestDTO;
import com.donatoordep.challenge_03.dto.PasswordRegisterResponseDTO;
import com.donatoordep.challenge_03.exceptions.ONBPasswordNotContainsMinimumCharactersException;
import com.donatoordep.challenge_03.mappers.PasswordMapper;
import com.donatoordep.challenge_03.repositories.PasswordRepository;
import com.donatoordep.challenge_03.services.validations.password.annotations.RegisterPasswordValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PasswordService {

    private final PasswordRepository repository;

    @Autowired
    public PasswordService(PasswordRepository repository) {
        this.repository = repository;
    }

    @RegisterPasswordValidate
    public PasswordRegisterResponseDTO insert(PasswordRegisterRequestDTO dto) {
        return PasswordMapper.toDtoResponse(repository.save(PasswordMapper.toEntity(dto)));
    }
}