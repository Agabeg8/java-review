package com.cydeo.oopreview.service;


import com.cydeo.oopreview.exception.InvalidPaymentStrategyException;
import com.cydeo.oopreview.model.payment.PaymentResponse;
import com.cydeo.oopreview.model.payment.AuthRequest;

public interface PaymentService {
    PaymentResponse auth(AuthRequest authRequest);

    PaymentResponse auth3D(AuthRequest auth3DRequest);
}
