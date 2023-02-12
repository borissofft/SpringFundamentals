package com.softuni.battleships.model.validation;

import com.softuni.battleships.repository.ShipRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueShipNameValidator implements ConstraintValidator<UniqueShipName, String> {
    private final ShipRepository shipRepository;

    @Autowired
    public UniqueShipNameValidator(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.shipRepository
                .findByName(value)
                .isEmpty();
    }
}
