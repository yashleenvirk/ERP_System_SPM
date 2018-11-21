package com.spm.project.service;

import com.spm.project.domain.ClientEvent;
import com.spm.project.repository.PotentialClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class PotentialClientService {

    @Autowired
    private PotentialClientRepository potentialClientRepository;

    public int leastSoldProduct(String clientName) {

        ClientEvent c = potentialClientRepository.findByClientName(clientName);
        return c.getClientID();
    }

    public String leastActiveClient(Date ClientSince){
        List<ClientEvent> client_list = potentialClientRepository.findByClientSinceGreaterThan(ClientSince);
        int min = 999999999;
        String leastActiveClient = "";
        for (ClientEvent c:client_list) {
            if(c.getProductsEnrolled()<min) {
                min = c.getProductsEnrolled();
                leastActiveClient = c.getClientName();
            }

        }
    return leastActiveClient;
    }
}
