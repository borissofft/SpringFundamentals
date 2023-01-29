package bg.softuni.mobilele.model.mapper;

import bg.softuni.mobilele.model.dto.UserRegisterDto;
import bg.softuni.mobilele.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") // This would be a Bean
public interface UserMapper { // It is quicker than ModelMapper because don't work with reflection
    @Mapping(target = "active", constant = "true")
    User userDtoToUserEntity(UserRegisterDto userRegisterDto);

}
