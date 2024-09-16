package priyanshudev.demo.client.authenticationClients.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class InvalidTokenDto {
    private final String message = "Token is invalid or null";
}
