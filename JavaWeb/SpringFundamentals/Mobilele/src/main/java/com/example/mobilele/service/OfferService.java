package com.example.mobilele.service;

import com.example.mobilele.model.entity.OfferEntity;
import com.example.mobilele.model.service.OfferUpdateServiceModel;
import com.example.mobilele.model.view.OfferDetailsView;
import com.example.mobilele.model.view.OfferView;

import java.util.List;

public interface OfferService {
    void saveOffer(OfferEntity offer);

    void deleteOffer(Long id);

    List<OfferView> getAllOffers();

    OfferDetailsView findById(Long id);

    void updateOffer(OfferUpdateServiceModel serviceModel);
}
