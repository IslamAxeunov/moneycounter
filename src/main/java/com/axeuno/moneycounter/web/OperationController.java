package com.axeuno.moneycounter.web;

import com.axeuno.moneycounter.web.dto.OperationCreateDto;
import com.axeuno.moneycounter.web.dto.OperationDto;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OperationController {

    List<OperationCreateDto> savedRequests = new ArrayList<>();
    List<OperationDto> savedRequestsWithDate = new ArrayList<>();
    int lastId = 0;


    @PostMapping("/operation")
    public OperationDto saveOperation(@RequestBody OperationCreateDto operationCreateDto) {
        System.out.println("Receieve request body: " + operationCreateDto);

        OperationDto operationDto = new OperationDto();
        lastId = lastId + 1;
        operationDto.setId(lastId);
        operationDto.setDescription(operationCreateDto.getDescription());
        operationDto.setMoney(operationCreateDto.getMoney());
        operationDto.setTime(LocalDateTime.now());


        savedRequestsWithDate.add(operationDto);
        return operationDto;
    }

    @GetMapping("/operation")
    public List<OperationDto> getAllOperation() {
        return savedRequestsWithDate;
    }

    @GetMapping("/operation/{operationId}")
    public OperationDto getAllOperation(@PathVariable Integer operationId) {
        System.out.println("getting operation with id: " + operationId);


        for (OperationDto operationDto : savedRequestsWithDate) {
            if (operationDto.getId().equals(operationId)) {
                return operationDto;
            }
        }

        throw new RuntimeException("not found"); //todo
    }


    @DeleteMapping("/operation")
    public List<OperationDto> deleteOperation() {
        return null; //todo
    }

}


