package com.ereyesalvarez.aws.calculator.app.dto.infrastructure;

import com.ereyesalvarez.aws.calculator.app.enums.common.CommonState;
import com.ereyesalvarez.aws.calculator.app.enums.infrastructure.ItemSize;
import lombok.Data;

@Data
public class ItemOut {
    Long id;
    String title;
    String project;
    Long typeId;
    String typeTitle;
    Double typePrice;
    ItemSize typeSize;
    Long typeItemClassId;
    String typeItemClassTitle;
    CommonState state;
    public int getTypeSizeId(){
        return typeSize.ordinal();
    }
    public int getStateId(){
        return state.ordinal();
    }
}
