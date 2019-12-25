package com.ereyesalvarez.aws.calculator.app.web.api.v1.infrastructure;

import com.ereyesalvarez.aws.calculator.app.dto.common.ErrorOut;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemIn;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemOut;
import com.ereyesalvarez.aws.calculator.app.service.infrastructure.ItemCRUDService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/item")
public class ItemController {
    private final ItemCRUDService itemCRUDService;

    @GetMapping("")
    public ResponseEntity<?> getItems() {
        List<ItemOut> response = itemCRUDService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{itemId}")
    public ResponseEntity<?> getOneItem(@PathVariable("itemId") Long itemId){
        if(itemCRUDService.itemDontExist(itemId)){
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorOut(207, "Item not found"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemCRUDService.getOneItem(itemId));

    }
    @PostMapping("")
    public ResponseEntity<?> createItem(@RequestBody ItemIn source){
        ErrorOut errorOut = itemCRUDService.validateCreateItem(source);
        if(errorOut != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorOut);
        }
        itemCRUDService.createItem(source);
        return ResponseEntity.status(HttpStatus.OK).body(new ErrorOut(0,"Ok"));
    }
    @PutMapping("")
    public ResponseEntity<?> updateItem(@RequestBody ItemIn source){
        if(itemCRUDService.itemDontExist(source.getId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorOut(207, "Item not found"));
        }
        ErrorOut errorOut = itemCRUDService.validateUpdateItem(source);
        if(errorOut != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorOut);
        }
        itemCRUDService.updateItem(source);
        return ResponseEntity.status(HttpStatus.OK).body(new ErrorOut(0,"Ok"));
    }

}
