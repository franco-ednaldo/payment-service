package com.example.payment.application.ports.out;

import com.example.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {
    Optional<User> find(Integer userId);
}
