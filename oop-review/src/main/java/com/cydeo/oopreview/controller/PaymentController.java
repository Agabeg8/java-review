package com.cydeo.oopreview.controller;

import com.cydeo.oopreview.enums.CardType;
import com.cydeo.oopreview.model.payment.PaymentResponse;
import com.cydeo.oopreview.model.payment.AuthRequest;
import com.cydeo.oopreview.service.PaymentService;
import com.cydeo.oopreview.service.impl.payment.HybridPaymentServiceImpl;
import com.cydeo.oopreview.service.impl.payment.TenantPaymentServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ResourceBundle;

@RequestMapping("/payment")
public class PaymentController {

    private final BigDecimal THREEDS_LIMIT = new BigDecimal(500);

    private final ResourceBundle resourceBundle;

    public PaymentController(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }


    // accept payment requests from any clients
    @PostMapping
    public PaymentResponse makePayment(@RequestBody AuthRequest authRequest) {
        // payment response success result 1 failure result 0
        // If the payment is unsuccessful, the error message and error code field will also be filled.
        PaymentService paymentService = decidePaymentTypeThatWillBeProcessed(authRequest);
        if (force3Ds(authRequest)) {
            return paymentService.auth3D(authRequest);
        } else {
            return paymentService.auth(authRequest);
        }
    }

    //Determines whether payments are forwarded as 3d secure or non secure
    private boolean force3Ds(AuthRequest authRequest) {
        if (CardType.DEBIT.equals(authRequest.getCardType())) {
            return true;
        } else {
            return authRequest.getAmount().compareTo(THREEDS_LIMIT) > 0;
        }
    }

    //determines the method by which payments will be advanced (hybrid or tenant)
    private PaymentService decidePaymentTypeThatWillBeProcessed(AuthRequest authRequest) {
        if (authRequest.isHybridPayment()) {
            return new HybridPaymentServiceImpl();
        } else {
            return new TenantPaymentServiceImpl(resourceBundle);
        }
    }
}
