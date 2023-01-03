package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.entity.User;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(UserLoginDto loginDto) {
        Optional<User> userOpt = this.userRepository.findByEmail(loginDto.getUsername()); // We will use email instead of username because when start to learn Spring Security will be more interesting
        if (userOpt.isEmpty()) {
            this.LOGGER.debug("User with name [{}] not found.", loginDto.getUsername());
            return false;
        }
        return userOpt.get().getPassword().equals(loginDto.getPassword());
    }

}
