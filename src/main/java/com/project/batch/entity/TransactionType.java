package com.project.batch.entity;


public enum TransactionType {
    // Stock - undenfined
    STOCK(0), UNDEFINED(-1), PENDING(1);

    private int value;

    private TransactionType(int value) {
        this.value = value;
    }

    public int getIntValue() {
        return value;
    }

    public static TransactionType fromIntValue(int value) {
        switch (value) {
            case 0:
                return STOCK;
            case -1:
                return UNDEFINED;
            case 1:
                return PENDING;
            default:
                return UNDEFINED;
        }
    }
}


// Transaction type