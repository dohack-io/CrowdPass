package com.doughhack.doughnotList.dto;

public class EntryDto implements DoughNotDto {
    public long id;
    public String name;
    public String barcodeNr;
    public int amount;

    public EntryDto(long id, String name, String barcodeNr, int amount) {
        this.id = id;
        this.name = name;
        this.barcodeNr = barcodeNr;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "EntryDto{"
                + " name='" + name + '\''
                + ", barcodeNr='" + barcodeNr + '\''
                + ", amount=" + amount
                + '}';
    }
}
