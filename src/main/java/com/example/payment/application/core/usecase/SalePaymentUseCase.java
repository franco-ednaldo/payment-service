package com.example.payment.application.core.usecase;

import com.example.payment.application.core.domain.Payment;
import com.example.payment.application.core.domain.Sale;
import com.example.payment.application.core.domain.enums.SaleEvent;
import com.example.payment.application.ports.in.FindUserByIdInputPort;
import com.example.payment.application.ports.out.SavePaymentOutputPort;
import com.example.payment.application.ports.out.SendValidatedPaymentOutputPort;
import com.example.payment.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase {

    private final FindUserByIdInputPort findUserByIdInputPort;

    private final UpdateUserOutputPort updateUserOutputPort;

    private final SavePaymentOutputPort savePaymentOutputPort;

    private final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdInputPort,
                              UpdateUserOutputPort updateUserOutputPort,
                              SavePaymentOutputPort savePaymentOutputPort,
                              SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendValidatedPaymentOutputPort = sendValidatedPaymentOutputPort;
    }

    public void payment(final Sale sale) {
        final var user = this.findUserByIdInputPort.find(sale.getUserId());
        if (user.getBalance().compareTo(sale.getValue()) < 0) {
            throw new RuntimeException("Saldo insuficiente!");
        }
        user.debitBalance(sale.getValue());
        this.updateUserOutputPort.update(user);

        var payment = this.buildPayment(sale);
        this.savePaymentOutputPort.save(payment);
        this.sendValidatedPaymentOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }

    private Payment buildPayment(final Sale sale) {
        return new Payment(sale.getUserId(), sale.getId(), sale.getValue());
    }
}
