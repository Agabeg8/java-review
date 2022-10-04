package com.cydeo.oopreview.service.impl.initialization;


import com.cydeo.oopreview.enums.ServiceProvider;
import com.cydeo.oopreview.helper.CollectionHelper;
import com.cydeo.oopreview.model.pos.Pos;
import com.cydeo.oopreview.service.PosInitializationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.cydeo.oopreview.constant.StaticConstants.*;

public class HybridPosInitializationServiceImpl implements PosInitializationService {

    @Override
    public List<Pos> initializePosList() {
        if(CollectionHelper.isNullOrEmpty(POS_LIST)){
            checkPosListAndInitializeIfNotExists();
        }
        return POS_LIST;
    }

    //fill tenant pos list without pos commission and service providers if not initialized
    private void checkPosListAndInitializeIfNotExists() {
        AtomicReference<Double> initialValue = new AtomicReference<>(1.32);
        double incrementValueForPos = 0.53d;

        EXTERNAL_BANK_CODE.forEach(bankCode -> {
            String posName = "BANK" + bankCode;

            Pos pos = new Pos(posName,
                    null,
                    decideSupportedServiceProviderList(posName));

            initialValue.updateAndGet(v -> (v + incrementValueForPos));
            POS_LIST.add(pos);
        });
    }

    //all cards have a specific service provider.
    // However, POS only serves certain service providers.
    // Here we identify the service providers supported on a bank basis.
    private List<ServiceProvider> decideSupportedServiceProviderList(String posName) {
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        switch (posName) {
            case "BANKD":
                return new ArrayList<>(Arrays.asList(ServiceProvider.values()));
            case "BANKE":
                serviceProviderList.add(ServiceProvider.MASTER_CARD);
                serviceProviderList.add(ServiceProvider.VISA);
                return serviceProviderList;
            case "BANKF":
                serviceProviderList.add(ServiceProvider.AMEX);
                return serviceProviderList;
            default:
                return serviceProviderList;
        }
    }
}
