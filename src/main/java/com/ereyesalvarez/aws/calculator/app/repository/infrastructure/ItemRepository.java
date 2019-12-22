package com.ereyesalvarez.aws.calculator.app.repository.infrastructure;

import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByTitle(String title);
}
