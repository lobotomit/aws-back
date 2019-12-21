package com.ereyesalvarez.aws.calculator.app.entity.infrastructure;

import com.ereyesalvarez.aws.calculator.app.entity.BaseEntity;
import com.ereyesalvarez.aws.calculator.app.enums.infrastructure.ItemSize;
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
public class ItemType extends BaseEntity {
    private String title;
    private ItemSize size;
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn
    private ItemClass itemClass;
}
