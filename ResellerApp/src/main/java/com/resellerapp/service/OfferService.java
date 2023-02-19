package com.resellerapp.service;

import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final UserService userService;
    private final ConditionService conditionService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public OfferService(OfferRepository offerRepository, UserService userService, ConditionService conditionService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.userService = userService;
        this.conditionService = conditionService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    public void addOffer(OfferServiceModel offerServiceModel) {
        Offer offer = this.modelMapper.map(offerServiceModel, Offer.class);
        offer.setCondition(this.conditionService.findByConditionName(offerServiceModel.getCondition()));
        offer.setUser(this.userService.findById(this.currentUser.getId()));
        this.offerRepository.save(offer);
    }

    public List<OfferViewModel> findAllOffersOfUser(Long currentUserId) {
        return this.offerRepository.findAllByUser_Id(currentUserId)
                .stream()
                .map(offer -> this.modelMapper.map(offer, OfferViewModel.class))
                .collect(Collectors.toList());
    }

    public List<OfferViewModel> findAll() {
        return this.offerRepository.findAll()
                .stream()
                .map(offer -> this.modelMapper.map(offer, OfferViewModel.class))
                .collect(Collectors.toList());
    }

    public void deleteOffer(Long id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow();
        this.offerRepository.delete(offer);
    }
}
