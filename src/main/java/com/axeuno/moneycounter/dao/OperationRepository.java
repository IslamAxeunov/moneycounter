package com.axeuno.moneycounter.dao;


import com.axeuno.moneycounter.dto.OperationDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class OperationRepository {

    List<OperationDto> savedRequestsWithDate = new ArrayList<>();

    int lastId = 0;

    public int iterateAndGetId() {

        lastId = lastId + 1;
        return lastId;
    }

    public void saveOperation(OperationDto operationToSave) {

        savedRequestsWithDate.add(operationToSave);

    }

    public List<OperationDto> getAllSavedOperations() {
        return savedRequestsWithDate;
    }

    public OperationDto getOneSavedOperation(Integer operationId) {
        for (int i = 0; i < savedRequestsWithDate.size(); i++) {
            if (operationId.equals(savedRequestsWithDate.get(i).getId()))
                return savedRequestsWithDate.get(i);
        }
        throw new RuntimeException();
    }
}
