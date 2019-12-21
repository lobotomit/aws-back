package com.ereyesalvarez.aws.calculator.app.enums.common;

public enum CommonState {
    ARCHIVED,
    ACTIVE;
    public static boolean isValid(Integer id) { return (id >= 0 && id < values().length); }

    public static CommonState getValue(Integer id) {
        return values()[id];
    }
}
