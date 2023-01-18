package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDto;
import bg.softuni.mobilele.model.dto.UserRegisterDto;

public interface UserService {
    public boolean login(UserLoginDto loginDto);

    public void logout();

    public void registerAndLogin(UserRegisterDto userRegisterDto);

}
