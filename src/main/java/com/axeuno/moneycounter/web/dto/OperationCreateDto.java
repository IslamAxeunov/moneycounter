package com.axeuno.moneycounter.web.dto;

public class OperationCreateDto {

    private String description;
    private Double money;

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

    public String toString(){
        return "desc:" + description + money;
    }
}
