package com.ereyesalvarez.aws.calculator.app.repository.infrastructure;

import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.ItemClass;
import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType, Long> {
}
