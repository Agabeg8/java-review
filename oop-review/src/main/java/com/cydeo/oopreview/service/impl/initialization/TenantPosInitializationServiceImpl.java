package com.cydeo.oopreview.service.impl.initialization;

import com.cydeo.oopreview.enums.ServiceProvider;
import com.cydeo.oopreview.helper.CollectionHelper;
import com.cydeo.oopreview.model.pos.Pos;
import com.cydeo.oopreview.service.PosInitializationService;

import java.util.*;

import static com.cydeo.oopreview.constant.StaticConstants.*;


public class TenantPosInitializationServiceImpl implements PosInitializationService {

    @Override
    public List<Pos> initializePosList() {
        if (CollectionHelper.isNullOrEmpty(POS_LIST)) {
            checkPosListAndInitializeIfNotExists();
        }
        return POS_LIST;
    }

    //fill tenant pos list with pos commission and service providers if not initialized
    private void checkPosListAndInitializeIfNotExists() {
        double incrementValueForPos = 0.53d , initialValue = 1.32;

        for (Character bankCode : BANK_CODE){
            String posName = "BANK" + bankCode;
            Pos pos = new Pos(posName,
                    initializePosCommissionRateMap(initialValue),
                    decideSupportedServiceProviderList(posName));
            initialValue += incrementValueForPos;
            POS_LIST.add(pos);
        }
    }

    //Each pos may have different costs depending on the installment service offered.
    // In order to simulate these, we increase the commission values at a certain frequency.
    private Map<Integer, Double> initializePosCommissionRateMap(double initialValue) {

        double incrementValue = 0.3d;
        Map<Integer, Double> commissionMap = new HashMap<>();

        for (Integer installment : AVAILABLE_INSTALLMENT) {
            commissionMap.put(installment, initialValue);
            initialValue += incrementValue;
        }

        return commissionMap;
    }

    //all cards have a specific service provider.
    // However, POS only serves certain service providers.
    // Here we identify the service providers supported on a bank basis.
    private List<ServiceProvider> decideSupportedServiceProviderList(String posName) {
        List<ServiceProvider> serviceProviderList = new ArrayList<>();
        switch (posName) {
            case "BANKA":
                return new ArrayList<>(Arrays.asList(ServiceProvider.values()));
            case "BANKB":
                serviceProviderList.add(ServiceProvider.MASTER_CARD);
                serviceProviderList.add(ServiceProvider.VISA);
                return serviceProviderList;
            case "BANKC":
                serviceProviderList.add(ServiceProvider.AMEX);
                return serviceProviderList;
            default:
                return serviceProviderList;
        }
    }
}
