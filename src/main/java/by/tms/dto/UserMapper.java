package by.tms.dto;

import by.tms.entity.User;

public class UserMapper {
    public User convertUserDtoToUser(UserDto userDto, User user) {
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
