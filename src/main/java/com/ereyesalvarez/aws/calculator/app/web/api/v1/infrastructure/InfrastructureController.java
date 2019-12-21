package com.ereyesalvarez.aws.calculator.app.web.api.v1.infrastructure;

import com.ereyesalvarez.aws.calculator.app.dto.infrastructure.ItemOut;
import com.ereyesalvarez.aws.calculator.app.service.infrastructure.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/item")
public class InfrastructureController {
    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity getCategoriesForAdmin(
        @RequestParam(value = "super", required = false, defaultValue = "false") boolean superAdmin
    ) {
        List<ItemOut> response = itemService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
