package com.ereyesalvarez.aws.calculator.app.dto.infrastructure;

import com.ereyesalvarez.aws.calculator.app.enums.common.CommonState;
import com.ereyesalvarez.aws.calculator.app.enums.infrastructure.ItemSize;
import lombok.Data;

@Data
public class ItemIn {
    Long id;
    String title;
    String project;
    Long typeId;
}
