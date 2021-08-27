package com.example.mobilelele.service.impl;

import com.example.mobilelele.model.entity.Offer;
import com.example.mobilelele.model.service.OfferServiceModel;
import com.example.mobilelele.repository.OfferRepository;
import com.example.mobilelele.security.CurrentUser;
import com.example.mobilelele.service.ModelService;
import com.example.mobilelele.service.OfferService;
import com.example.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final ModelService modelService;
    private final UserService userService;

    public OfferServiceImpl(OfferRepository offerRepository, CurrentUser currentUser, ModelMapper modelMapper, ModelService modelService, UserService userService) {
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.userService = userService;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public long save(OfferServiceModel model) {
        Offer offer = asNewEntity(model);
        Offer newEntity = offerRepository.save(offer);
        return newEntity.getId();
    }

    private Offer asNewEntity(OfferServiceModel model){
        Offer offer = new Offer();
        modelMapper.map(model , offer);
        offer.setModel(modelService.findById(model.getModelId()));
        offer.setSeller(userService.findByUsername(currentUser.getName()));
        return offer;
    }
}
