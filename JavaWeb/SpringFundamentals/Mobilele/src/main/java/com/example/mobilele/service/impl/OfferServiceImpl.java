package com.example.mobilele.service.impl;

import com.example.mobilele.model.entity.OfferEntity;
import com.example.mobilele.model.service.OfferUpdateServiceModel;
import com.example.mobilele.model.view.OfferDetailsView;
import com.example.mobilele.model.view.OfferView;
import com.example.mobilele.repository.OfferRepository;
import com.example.mobilele.service.OfferService;
import com.example.mobilele.web.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveOffer(OfferEntity offer) {
        offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public List<OfferView> getAllOffers() {
        return offerRepository
                .findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public OfferDetailsView findById(Long id) {
        return offerRepository.findById(id).map(this::mapDetailsView).get();
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel serviceModel) {
        OfferEntity offerEntity = offerRepository.findById(serviceModel.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Offer with id " + serviceModel.getId() + " not found!"));

        offerEntity
                .setPrice(serviceModel.getPrice())
                .setDescription(serviceModel.getDescription())
                .setEngine(serviceModel.getEngine())
                .setImageUrl(serviceModel.getImageUrl())
                .setMileage(serviceModel.getMileage())
                .setTransmission(serviceModel.getTransmission())
                .setYear(serviceModel.getYear());

        offerRepository.save(offerEntity);
    }

    private OfferView map(OfferEntity offerEntity) {
        OfferView summaryView = this.modelMapper
                .map(offerEntity, OfferView.class);

        summaryView.setModel(offerEntity.getModel().getName());
        summaryView.setBrand(offerEntity.getModel().getBrand().getName());

        return summaryView;
    }

    private OfferDetailsView mapDetailsView(OfferEntity offer) {
        OfferDetailsView offerDetailsView = this.modelMapper.map(offer, OfferDetailsView.class);
        offerDetailsView.setModel(offer.getModel().getName());
        offerDetailsView.setBrand(offer.getModel().getBrand().getName());
        offerDetailsView.setSellerFullName(offer.getSeller().getFirstName() + " " + offer.getSeller().getLastName());
        return offerDetailsView;
    }
}
