package com.marcello.course.entities.enums;

public enum OrderStatus {

    WITHIN_WARRANTY(1),

    OUT_OF_WARRANTY(2);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }

}
