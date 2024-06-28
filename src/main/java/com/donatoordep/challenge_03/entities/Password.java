package com.donatoordep.challenge_03.entities;

import com.donatoordep.challenge_03.builders.entities.PasswordAbstractBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Password {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String password;

    private Password() {
    }

    public static class PasswordBuilder implements PasswordAbstractBuilder {

        private Password entity;

        private PasswordBuilder() {
            this.reset();
        }

        public static PasswordBuilder builder() {
            return new PasswordBuilder();
        }

        @Override
        public Password build() {
            return this.entity;
        }

        @Override
        public PasswordAbstractBuilder id(UUID id) {
            this.entity.setId(id);
            return this;
        }

        @Override
        public PasswordAbstractBuilder password(String password) {
            this.entity.setPassword(password);
            return this;
        }

        @Override
        public void reset() {
            this.entity = new Password();
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return Objects.equals(id, password.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}