package com.axeuno.moneycounter.web;

import com.axeuno.moneycounter.services.OperationService;
import com.axeuno.moneycounter.dto.OperationCreateFormDto;
import com.axeuno.moneycounter.dto.OperationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OperationController {

    OperationService operationService = new OperationService();
    List<OperationDto>savedRequestsWithDate = new ArrayList<>();
    int lastId = 0;


//    @PostMapping("/operation")
    public OperationDto oldSaveOperation(@RequestBody byte[] body) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();
        OperationCreateFormDto operationCreateFormDto = objectMapper.readValue(body, OperationCreateFormDto.class);

        System.out.println("Receieve request body: " + operationCreateFormDto);

        OperationDto operationDto = new OperationDto();
        lastId = lastId + 1;
        operationDto.setId(lastId);
        operationDto.setDescription(operationCreateFormDto.getDescription());
        operationDto.setMoney(operationCreateFormDto.getMoney());
        operationDto.setTime(LocalDateTime.now());
        System.out.println("OperationDto: " + operationDto);


        savedRequestsWithDate.add(operationDto);
        return operationDto;
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    @PostMapping("/operation")
    public OperationDto saveOperation(@RequestBody byte[] body) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        OperationCreateFormDto operationCreateFormDto = objectMapper.readValue(body, OperationCreateFormDto.class);
        System.out.println("Receieve request body: " + operationCreateFormDto);

        OperationDto createdOperation = operationService.createOperation(operationCreateFormDto);
        return createdOperation;
    }

    @GetMapping("/operations")
    public List<OperationDto> getAllOperation() {
        return operationService.getAllOperations();
    }

    @GetMapping("/operation/{operationId}")
    public OperationDto getOperationById(@PathVariable Integer operationId) {
        System.out.println("getting operation with id: " + operationId);
        return operationService.getOperationById(operationId);



    }


    @DeleteMapping("/operation/{operationId}")
    public void deleteOperation(@PathVariable Integer operationId) {

        System.out.println("getting operation with id: " + operationId);

        boolean deleted = savedRequestsWithDate.removeIf(operationDto -> operationDto.getId().equals(operationId));
        if (!deleted) {
            throw new RuntimeException();
        }


    }

}


