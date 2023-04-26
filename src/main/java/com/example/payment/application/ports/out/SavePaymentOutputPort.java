package com.example.payment.application.ports.out;

import com.example.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {
    void save(Payment payment);
}
