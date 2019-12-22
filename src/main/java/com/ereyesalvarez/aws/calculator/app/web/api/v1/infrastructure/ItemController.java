package com.ereyesalvarez.aws.calculator.app.web.api.v1.infrastructure;

import com.ereyesalvarez.aws.calculator.app.dto.common.ErrorOut;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemIn;
import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemOut;
import com.ereyesalvarez.aws.calculator.app.service.infrastructure.ItemService;
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
    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<?> getItems() {
        List<ItemOut> response = itemService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping("")
    public ResponseEntity<?> createItem(@RequestBody ItemIn source){
        ErrorOut errorOut = itemService.validateCreateItem(source);
        if(errorOut != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorOut);
        }
        itemService.createItem(source);
        return ResponseEntity.status(HttpStatus.OK).body(new ErrorOut(0,"Ok"));
    }
    @PutMapping("")
    public ResponseEntity<?> updateItem(@RequestBody ItemIn source){
        ErrorOut errorOut = itemService.validateUpdateItem(source);
        if(errorOut != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorOut);
        }
        itemService.createItem(source);
        return ResponseEntity.status(HttpStatus.OK).body(new ErrorOut(0,"Ok"));
    }

}
