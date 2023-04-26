package com.example.payment.application.ports.in;

import com.example.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(Integer userId);

}
