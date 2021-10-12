package com.example.mobilele.service;

import com.example.mobilele.model.entity.OfferEntity;

public interface OfferService {
    void saveOffer(OfferEntity offer);

    void deleteOffer(Long id);
}
