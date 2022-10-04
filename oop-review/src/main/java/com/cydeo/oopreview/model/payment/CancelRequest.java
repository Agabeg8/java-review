package com.cydeo.oopreview.model.payment;

import com.cydeo.oopreview.enums.Localization;

import java.math.BigDecimal;

public class CancelRequest extends AbstractPaymentRequest {
    public CancelRequest(BigDecimal amount, Localization locale, String conversationId) {
        super(amount, locale, conversationId);
    }
}
