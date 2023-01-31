package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.AddOfferDto;
import bg.softuni.mobilele.model.entity.Model;
import bg.softuni.mobilele.model.entity.Offer;
import bg.softuni.mobilele.model.entity.User;
import bg.softuni.mobilele.model.mapper.OfferMapper;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.OfferService;
import bg.softuni.mobilele.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final CurrentUser currentUser;
    private final OfferMapper offerMapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, CurrentUser currentUser, OfferMapper offerMapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.currentUser = currentUser;
        this.offerMapper = offerMapper;
    }

    @Override
    public void addOffer(AddOfferDto addOfferDto) {
        Offer newOffer = this.offerMapper.addOfferDtoToOfferEntity(addOfferDto);

        // TODO ... current user should be logged in

        User seller = this.userRepository.findByEmail(this.currentUser.getEmail()).orElseThrow();
        Model model = this.modelRepository.findById(addOfferDto.getModelId()).orElseThrow();

        newOffer.setModel(model);
        newOffer.setSeller(seller);

        this.offerRepository.save(newOffer);
    }


}
