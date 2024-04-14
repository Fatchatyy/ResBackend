package tn.esprit.springproject.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tn.esprit.springproject.Dto.SignUpDto;
import tn.esprit.springproject.Dto.UserDto;
import tn.esprit.springproject.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-14T20:18:55+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.login( user.getLogin() );
        userDto.role( user.getRole() );

        return userDto.build();
    }

    @Override
    public User SignUptoUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( signUpDto.firstName() );
        user.lastName( signUpDto.lastName() );
        user.login( signUpDto.login() );
        user.role( signUpDto.role() );

        return user.build();
    }
}
