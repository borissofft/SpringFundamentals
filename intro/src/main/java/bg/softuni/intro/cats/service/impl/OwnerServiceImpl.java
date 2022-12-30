package bg.softuni.intro.cats.service.impl;

import bg.softuni.intro.cats.model.dto.CreateOwnerDto;
import bg.softuni.intro.cats.model.entity.CatEntity;
import bg.softuni.intro.cats.model.entity.OwnerEntity;
import bg.softuni.intro.cats.repository.OwnerRepository;
import bg.softuni.intro.cats.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void createOwner(CreateOwnerDto createOwnerDto) {

        OwnerEntity owner = new OwnerEntity();
        owner.setOwnerName(createOwnerDto.getOwnerName());

        createOwnerDto.getCatNames()
                .forEach(name -> {
                    CatEntity cat = new CatEntity();
                    cat.setCatName(name);
                    cat.setOwner(owner); // bidirectional relation
                    owner.addCat(cat); // bidirectional relation
                });

        this.ownerRepository.save(owner);

    }

}
