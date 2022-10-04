package com.cydeo.oopreview.service;

import com.cydeo.oopreview.model.payment.AuthRequest;
import com.cydeo.oopreview.model.pos.Pos;

public interface PosSelectionService {
    Pos decidePaymentPos(AuthRequest authRequest);
}
