package com.cydeo.oopreview.model.pos;


import com.cydeo.oopreview.model.AbstractPosClientResponse;

import java.math.BigDecimal;

public class PosClientResponse extends AbstractPosClientResponse {
    public PosClientResponse(int result, String errorCde, BigDecimal amount) {
        super(result, errorCde, amount);
    }
}
