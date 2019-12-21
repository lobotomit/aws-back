package com.ereyesalvarez.aws.calculator.app.dto.infrastructure;

import com.ereyesalvarez.aws.calculator.app.enums.infrastructure.ItemSize;
import lombok.Data;

@Data
public class ItemTypeOut {
    private String title;
    private ItemSize size;
    private Double price;
}
