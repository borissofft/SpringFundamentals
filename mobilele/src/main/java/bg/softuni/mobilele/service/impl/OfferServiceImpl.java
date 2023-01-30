package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;


    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void addOffer(AddOfferDto addOfferDto) {
        // TODO ...
    }

}
