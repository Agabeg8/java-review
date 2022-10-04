package com.cydeo.oopreview.posclient.client;


import com.cydeo.oopreview.model.pos.PosClientRequest;
import com.cydeo.oopreview.model.pos.PosClientResponse;
import com.cydeo.oopreview.posclient.AbstractPosClient;

public class BankCPosClient extends AbstractPosClient {

    // return dummy response
    @Override
    public PosClientResponse auth(PosClientRequest posClientRequest) {
        return new PosClientResponse(0, "1345", posClientRequest.getRequestedAmount());
    }

    // return dummy response
    @Override
    public PosClientResponse auth3D(PosClientRequest posClientRequest) {
        return new PosClientResponse(0, "23", posClientRequest.getRequestedAmount());
    }

}
