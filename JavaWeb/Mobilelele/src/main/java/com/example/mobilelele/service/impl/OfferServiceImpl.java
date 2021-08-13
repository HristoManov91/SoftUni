package com.example.mobilelele.service.impl;

import com.example.mobilelele.repository.OfferRepository;
import com.example.mobilelele.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
}
