package com.ereyesalvarez.aws.calculator.app.entity.infrastructure;

import com.ereyesalvarez.aws.calculator.app.entity.TimestampBaseEntity;
import com.ereyesalvarez.aws.calculator.app.enums.common.CommonState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table
public class Item extends TimestampBaseEntity {
    private String title;
    private CommonState state;
    private String project;

    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "item_type")
    private ItemType type;

}
