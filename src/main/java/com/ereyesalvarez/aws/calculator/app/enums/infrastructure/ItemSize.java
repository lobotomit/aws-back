package com.ereyesalvarez.aws.calculator.app.enums.infrastructure;

import com.ereyesalvarez.aws.calculator.app.enums.common.CommonState;

public enum ItemSize {
    NANO,
    MICRO,
    SMALL,
    MEDIUM;
    public static boolean isValid(Integer id) { return (id >= 0 && id < values().length); }

    public static ItemSize getValue(Integer id) {
        return values()[id];
    }
}
