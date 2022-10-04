package com.cydeo.oopreview.model.payment;

import com.cydeo.oopreview.enums.Localization;

import java.math.BigDecimal;

public class RefundRequest extends AbstractPaymentRequest {
    public RefundRequest(BigDecimal amount, Localization locale, String conversationId) {
        super(amount, locale, conversationId);
    }
}
