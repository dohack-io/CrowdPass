package com.doughhack.doughnotList.model;

import com.doughhack.doughnotList.dto.EntryDto;

public class Entry extends Entity {
    private String name;
    private String barcodeNr;
    private int amount;

    public Entry(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Entry(String name) {
        this.name = name;
        this.amount = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcodeNr() {
        return barcodeNr;
    }

    public void setBarcodeNr(String barcodeNr) {
        this.barcodeNr = barcodeNr;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public EntryDto toDto() {
        return new EntryDto(name, barcodeNr, amount);
    }
}
