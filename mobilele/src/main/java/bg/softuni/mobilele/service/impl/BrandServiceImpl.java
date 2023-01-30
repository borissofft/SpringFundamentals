package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.BrandDto;
import bg.softuni.mobilele.model.dto.ModelDto;
import bg.softuni.mobilele.model.entity.Brand;
import bg.softuni.mobilele.model.entity.Model;
import bg.softuni.mobilele.repository.BrandRepository;
import bg.softuni.mobilele.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDto> getAllBrands() {
        return this.brandRepository
                .findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    private BrandDto mapBrand(Brand brandEntity) {
        List<ModelDto> models = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel).toList();

        BrandDto result = new BrandDto();
        result.setModels(models);
        result.setName(brandEntity.getName());
        return result;
    }
    private ModelDto mapModel(Model modelEntity) {
        ModelDto result = new ModelDto();
        result.setId(modelEntity.getId());
        result.setName(modelEntity.getName());
        return result;
    }

}
