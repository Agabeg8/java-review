package com.cydeo.oopreview.service.impl.selection;


import com.cydeo.oopreview.model.payment.AuthRequest;
import com.cydeo.oopreview.model.pos.Pos;
import com.cydeo.oopreview.service.PosInitializationService;
import com.cydeo.oopreview.service.PosSelectionService;

import static com.cydeo.oopreview.constant.StaticConstants.POS_LIST;

public class HybridPosSelectionServiceImpl implements PosSelectionService {

    @Override
    //Since there is no cost calculation among hybrid pos,
    // we are trying to find the pos that the merchant wants the payment to be made.
    public Pos decidePaymentPos(AuthRequest authRequest) {
        return POS_LIST.stream().
                filter(pos -> authRequest.getPosName().equals(pos.getName())).findFirst().orElse(POS_LIST.get(0));
    }
}
