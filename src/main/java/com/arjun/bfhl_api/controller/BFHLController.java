package com.arjun.bfhl_api.controller;

import com.arjun.bfhl_api.dto.BFHLRequestDTO;
import com.arjun.bfhl_api.dto.BFHLResponseDTO;
import com.arjun.bfhl_api.service.BFHLService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bfhl")
public class BFHLController {

    private final BFHLService bfhlService;

    public BFHLController(BFHLService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<BFHLResponseDTO> processData(
            @RequestBody BFHLRequestDTO request) {

        return ResponseEntity.ok(
                bfhlService.processData(request)
        );
    }
}