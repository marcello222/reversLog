package com.marcello.course.entities.enums;

public enum GuaranteeStatus {

    WITHIN_GUARANTEE(1),

    OUT_GUARANTEE(2);

    private int code;

    private GuaranteeStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GuaranteeStatus valueOf(int code) {
        for (GuaranteeStatus value : GuaranteeStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid GuaranteeStatus code");
    }

}
