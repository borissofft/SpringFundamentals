package com.resellerapp.service;

import com.resellerapp.model.view.OfferViewModel;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final UserService userService;
    private final OfferService offerService;
    private final ConditionService conditionService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public HomeService(UserService userService, OfferService offerService, ConditionService conditionService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.offerService = offerService;
        this.conditionService = conditionService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    public List<OfferViewModel> findAllOffersOfCurrentUser(Long currentUserId) {
        return this.offerService.findAllOffersOfUser(currentUserId);
    }

    public List<OfferViewModel> findAllOffers() {
            return this.offerService.findAll();
    }

    public void deleteCurrentOffer(Long id) {
        this.offerService.deleteOffer(id);
    }
}
