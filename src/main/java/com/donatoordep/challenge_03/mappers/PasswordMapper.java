package com.donatoordep.challenge_03.mappers;

import com.donatoordep.challenge_03.dto.PasswordRegisterRequestDTO;
import com.donatoordep.challenge_03.dto.PasswordRegisterResponseDTO;
import com.donatoordep.challenge_03.entities.Password;

import java.util.UUID;

public class PasswordMapper {

    public static Password toEntity(PasswordRegisterRequestDTO dto) {
        return Password.PasswordBuilder.builder()
                .id(UUID.randomUUID())
                .password(dto.password())
                .build();
    }

    public static PasswordRegisterResponseDTO toDtoResponse(Password entity) {
        return new PasswordRegisterResponseDTO(entity.getId(), entity.getPassword());
    }
}