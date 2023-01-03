package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.dto.UserLoginDto;

public interface UserService {

    public boolean login(UserLoginDto loginDto);

}
