package priyanshudev.demo.client.authenticationClients.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class UserDto {
    private String email;
    private String name;
    private Set<Role> roles;
}
