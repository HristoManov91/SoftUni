package com.example.mobilelele.service;

import com.example.mobilelele.model.entity.Offer;
import com.example.mobilelele.model.service.OfferServiceModel;

import java.util.List;

public interface OfferService {
    List<Offer> getAllOffers();

    long save(OfferServiceModel model);
}
