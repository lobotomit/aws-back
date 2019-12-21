package com.ereyesalvarez.aws.calculator.app.repository.infrastructure;

import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.Item;
import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.ItemClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemClassRepository extends JpaRepository<ItemClass, Long> {
}
