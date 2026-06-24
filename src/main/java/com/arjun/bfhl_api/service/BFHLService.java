package com.arjun.bfhl_api.service;

import com.arjun.bfhl_api.dto.BFHLRequestDTO;
import com.arjun.bfhl_api.dto.BFHLResponseDTO;

public interface BFHLService {

    BFHLResponseDTO processData(BFHLRequestDTO request);
}