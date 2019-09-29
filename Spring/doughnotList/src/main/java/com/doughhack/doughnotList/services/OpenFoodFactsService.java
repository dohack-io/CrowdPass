package com.doughhack.doughnotList.services;

import com.doughhack.doughnotList.model.Preference;

import java.util.LinkedList;
import java.util.List;

public class OpenFoodFactsService {

    public boolean isAcceptable(String barcode, Preference preference){
        // TODO: implement later
        return true;
    }

    public List<Preference> isAcceptable(String barcode, List<Preference> blacklist){
        // TODO: implement later
        List<Preference> notAcceptet = new LinkedList<>();
        for(Preference preference:blacklist){
        if(!isAcceptable(barcode, preference)){
                notAcceptet.add(preference);
            };
        }
        return notAcceptet;
    }

}
