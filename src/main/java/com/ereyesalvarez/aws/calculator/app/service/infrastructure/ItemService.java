package com.ereyesalvarez.aws.calculator.app.service.infrastructure;

import com.ereyesalvarez.aws.calculator.app.dto.common.ErrorOut;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemIn;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemOut;
import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.Item;
import com.ereyesalvarez.aws.calculator.app.repository.infrastructure.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemOut> getAll(){
        ModelMapper modelMapper = new ModelMapper();
        List<ItemOut> response = new ArrayList<>();
            List<Item> items = itemRepository.findAll();
            items.forEach(item -> {
                response.add(modelMapper.map(item, ItemOut.class));
            });
            return response;

    }
    public ErrorOut validateCreateItem(ItemIn source){
        if(StringUtils.isBlank(source.getTitle())){
            return new ErrorOut(201, "Item title required");
        }
        if(source.getTypeId() == null){
            return new ErrorOut(202, "Item type required");
        }
        if(StringUtils.isBlank(source.getProject())){
            return new ErrorOut(203, "Item project required");
        }
        return null;
    }
}
