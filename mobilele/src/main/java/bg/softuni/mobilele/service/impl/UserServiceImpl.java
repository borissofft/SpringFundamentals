package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.User;
import bg.softuni.mobilele.model.mapper.UserMapper;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.UserService;
import bg.softuni.mobilele.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public void registerAndLogin(UserRegisterDto userRegisterDto) {

        User newUser = this.userMapper.userDtoToUserEntity(userRegisterDto);
        newUser.setPassword(this.passwordEncoder.encode(userRegisterDto.getPassword()));

        this.userRepository.save(newUser);
        login(newUser);

    }

    @Override
    public boolean login(UserLoginDto loginDto) {
        Optional<User> userOpt = this.userRepository.findByEmail(loginDto.getUsername()); // We will use email instead of username because when start to learn Spring Security will be more interesting
        if (userOpt.isEmpty()) {
            this.LOGGER.info("User with name [{}] not found.", loginDto.getUsername());
            return false;
        }

        String rawPassword = loginDto.getPassword(); // it comes from html form
        String encodedPassword = userOpt.get().getPassword(); // it comes from DB (hashed password)
        boolean success = this.passwordEncoder.matches(rawPassword, encodedPassword);

        if (success) {
            login(userOpt.get());
        } else {
            logout();
        }

        return success;
    }


    private void login(User user) {
        this.currentUser.setLoggedIn(true);
        this.currentUser.setName(user.getFirstName() + " " + user.getLastName());
        this.currentUser.setEmail(user.getEmail());
    }

    @Override
    public void logout() {
        this.currentUser.clear();
    }


}
