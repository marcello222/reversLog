package com.marcello.course.entities.enums;

public enum ReversalStatus {

    VOUCHER(1),

    VALUE(2);

    private int code;

    private ReversalStatus(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }

    public static ReversalStatus valueOf(int code) {
        for (ReversalStatus value : ReversalStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid ReversalStatus code");
    }

}
