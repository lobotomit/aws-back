package com.ereyesalvarez.aws.calculator.app.dto.infrastructure;

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
    String typeItemClassTitle;
}
