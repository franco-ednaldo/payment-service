package com.example.payment.application.ports.out;

import com.example.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);

}
