package com.axeuno.moneycounter.services;


import com.axeuno.moneycounter.dao.OperationRepository;
import com.axeuno.moneycounter.dto.OperationCreateFormDto;
import com.axeuno.moneycounter.dto.OperationDto;

import java.time.LocalDateTime;

public class OperationService {

    OperationRepository operationRepository = new OperationRepository();


    public OperationDto createOperation(OperationCreateFormDto operationCreateFormDto) {

        String description = operationCreateFormDto.getDescription();
        Double money = operationCreateFormDto.getMoney();
        LocalDateTime now = LocalDateTime.now();
        int id = operationRepository.iterateAndGetId();


        OperationDto newOperation = new OperationDto();
        newOperation.setDescription(description);
        newOperation.setMoney(money);
        newOperation.setTime(now);
        newOperation.setId(id);
        System.out.println("OperationDto: " + newOperation);
        operationRepository.saveOperation(newOperation);
        return newOperation;
    }
}
