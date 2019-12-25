package com.ereyesalvarez.aws.calculator.app.service.infrastructure;

import com.ereyesalvarez.aws.calculator.app.dto.common.ErrorOut;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemIn;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemOut;
import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.Item;
import com.ereyesalvarez.aws.calculator.app.enums.common.CommonState;
import com.ereyesalvarez.aws.calculator.app.repository.infrastructure.ItemRepository;
import com.ereyesalvarez.aws.calculator.app.repository.infrastructure.ItemTypeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemCRUDService {
    private final ItemRepository itemRepository;
    private final ItemTypeRepository itemTypeRepository;

    public boolean itemExist(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.isPresent();
    }

    public Item getOneItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<ItemOut> getAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<ItemOut> response = new ArrayList<>();
        List<Item> items = itemRepository.findAll();
        items.forEach(item -> response.add(modelMapper.map(item, ItemOut.class)));
        return response;
    }

    public ErrorOut validateCreateItem(ItemIn source) {
        if (StringUtils.isBlank(source.getTitle())) {
            return new ErrorOut(201, "Item title required");
        }
        if (itemRepository.findByTitle(source.getTitle()).isPresent()) {
            return new ErrorOut(205, "Item title already assigned");
        }
        if (source.getTypeId() == null) {
            return new ErrorOut(202, "Item type required");
        }
        if (!itemTypeRepository.findById(source.getTypeId()).isPresent()) {
            return new ErrorOut(204, "Item type not found");
        }
        if (StringUtils.isBlank(source.getProject())) {
            return new ErrorOut(203, "Item project required");
        }
        return null;
    }

    public void createItem(ItemIn source) {
        ModelMapper modelMapper = new ModelMapper();
        Item item = modelMapper.map(source, Item.class);
        item.setState(CommonState.ACTIVE);
        itemTypeRepository.findById(source.getTypeId()).ifPresent(item::setType);
        itemRepository.save(item);
    }

    public ErrorOut validateUpdateItem(ItemIn source) {
        if (source.getId() == null) {
            return new ErrorOut(206, "Id is mandatory");
        }
        Item item = itemRepository.findById(source.getId()).orElse(null);
        if (item == null) {
            return new ErrorOut(207, "Item not found");
        }
        if (!source.getTitle().equals(item.getTitle())) {
            if (itemRepository.findByTitle(source.getTitle()).isPresent()) {
                return new ErrorOut(205, "Item title already assigned");
            }
        }
        if (!itemTypeRepository.findById(source.getTypeId()).isPresent()) {
            return new ErrorOut(204, "Item type not found");
        }
        return null;
    }

    public void updateItem(ItemIn source) {
        Item item = itemRepository.findById(source.getId()).orElse(null);
        if (item == null) {
            return;
        }
        if (!source.getTitle().equals(item.getTitle())) {
            item.setTitle(source.getTitle());
        }
        if (!StringUtils.isBlank(source.getProject()) && !source.getProject().equals(item.getProject())) {
            item.setProject(source.getProject());
        }
        if (item.getType() != null && !item.getType().getId().equals(source.getTypeId())) {
            itemTypeRepository.findById(source.getTypeId()).ifPresent(item::setType);
        }
        itemRepository.save(item);
    }
}
