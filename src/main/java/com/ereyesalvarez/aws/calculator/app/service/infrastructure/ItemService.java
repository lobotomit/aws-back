package com.ereyesalvarez.aws.calculator.app.service.infrastructure;

import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemOut;
import com.ereyesalvarez.aws.calculator.app.entity.infrastructure.Item;
import com.ereyesalvarez.aws.calculator.app.repository.infrastructure.ItemRepository;
import lombok.RequiredArgsConstructor;
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
    
}
