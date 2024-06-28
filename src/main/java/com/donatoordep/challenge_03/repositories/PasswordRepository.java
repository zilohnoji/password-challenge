package com.donatoordep.challenge_03.repositories;

import com.donatoordep.challenge_03.entities.Password;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PasswordRepository extends JpaRepository<Password, UUID> {
}