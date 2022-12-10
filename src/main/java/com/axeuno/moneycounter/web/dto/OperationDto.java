package com.axeuno.moneycounter.web.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperationDto {
    private Integer id;
    private String description;
    private Double money;
    private LocalDateTime time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public void setAllNull(){
        this.id = null;
        this.money = null;
        this.description = null;
        this.time = null;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "OperationDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", money=" + money +
                ", time=" + time.format(formatter) +
                '}';
    }

    public OperationDto(Integer id, String description, Double money, LocalDateTime time) {
        this.id = id;
        this.description = description;
        this.money = money;
        this.time = time;
    }

    public OperationDto() {
    }



}
