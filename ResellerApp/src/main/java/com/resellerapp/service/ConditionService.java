package com.resellerapp.service;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionEnum;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class ConditionService {
    private final ConditionRepository conditionRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public ConditionService(ConditionRepository conditionRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.conditionRepository = conditionRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    public void initConditions() {

        if (this.conditionRepository.count() != 0) {
            return;
        }

        Arrays.stream(ConditionEnum.values())
                .forEach(conditionEnum -> {
                    Condition condition = new Condition();
                    condition.setConditionName(conditionEnum);
                    switch (conditionEnum) {
                        case EXCELLENT -> condition.setDescription("In perfect condition");
                        case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                        case ACCEPTABLE -> condition.setDescription("The item is fairly worn but continues to function properly");
                    }

                    this.conditionRepository.save(condition);
                });

    }

    public Condition findByConditionName(ConditionEnum conditionName) {
        return this.conditionRepository
                .findByConditionName(conditionName)
                .orElse(null);
    }
}
