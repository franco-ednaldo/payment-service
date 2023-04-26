package com.example.payment.application.ports.out;

import com.example.payment.application.core.domain.Sale;
import com.example.payment.application.core.domain.enums.SaleEvent;

public interface SendValidatedPaymentOutputPort {

    void send(Sale sale, SaleEvent event);

}
