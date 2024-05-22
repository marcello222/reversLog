package com.marcello.course.entities.enums;

public enum RefundStatus {

    VOUCHER(1),

    VALUE(2);

    private int code;

    private RefundStatus(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public static RefundStatus valueOf(int code) {
        for (RefundStatus value : RefundStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ReversalStatus code");
    }

}
