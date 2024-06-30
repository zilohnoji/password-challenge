package com.donatoordep.challenge_03.services;

import com.donatoordep.challenge_03.dto.PasswordRegisterRequestDTO;
import com.donatoordep.challenge_03.dto.PasswordRegisterResponseDTO;
import com.donatoordep.challenge_03.entities.Password;
import com.donatoordep.challenge_03.factory.PasswordFactory;
import com.donatoordep.challenge_03.repositories.PasswordRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.concurrent.TimeUnit;

@ExtendWith(SpringExtension.class)
@DisplayName("PasswordService - Domain Behavior Test")
public class PasswordServiceTest {

    @Mock
    private PasswordRepository repository;

    @InjectMocks
    private PasswordService service;

    private Password entity;
    private PasswordRegisterRequestDTO request;

    @BeforeEach
    void setup() {
        entity = PasswordFactory.createPassword();
        request = new PasswordRegisterRequestDTO(entity.getPassword());

        Mockito.when(repository.save(ArgumentMatchers.any(Password.class))).thenReturn(entity);
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("Test insert Password return PasswordRegisterResponseDTO")
    void insert_When_PasswordIsValid_ShouldReturn_PasswordRegisterResponseDTO() {

        // Act - Executar ação necessária
        PasswordRegisterResponseDTO responseDto = service.insert(request);

        // Assert - Declarar o que deveria acontecer
        Mockito.verify(repository, Mockito.times(1)).save(ArgumentMatchers.any(Password.class));

        Assertions.assertNotNull(responseDto.password(), "The insert() produces nullable result");

        Assertions.assertEquals(entity.getId(), responseDto.id(),
                () -> String.format("The id %s is not equals %s", entity.getId(), responseDto.id())
        );
    }
}