package priyanshudev.demo.client.authenticationClients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import priyanshudev.demo.client.authenticationClients.dto.SessionStatus;
import priyanshudev.demo.client.authenticationClients.dto.ValidateTokenRequestDto;
import priyanshudev.demo.client.authenticationClients.dto.ValidateTokenResponseDto;

@Component
public class AuthenticationClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public ValidateTokenResponseDto validate(String token, Long userId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ValidateTokenRequestDto requestDto = new ValidateTokenRequestDto();
        requestDto.setToken(token);
        requestDto.setUserId(userId);
        ResponseEntity<ValidateTokenResponseDto> l = restTemplate.postForEntity(
                "http://localhost:8000/auth/validate",
                requestDto,
                ValidateTokenResponseDto.class
        );
        return l.getBody();

    }


}
