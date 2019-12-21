package com.ereyesalvarez.aws.calculator.app.entity.infrastructure;

import com.ereyesalvarez.aws.calculator.app.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table
public class ItemClass extends BaseEntity {
    private String title;
    @OneToMany(mappedBy = "itemClass")
    private Set<ItemType> itemTypes;
}
