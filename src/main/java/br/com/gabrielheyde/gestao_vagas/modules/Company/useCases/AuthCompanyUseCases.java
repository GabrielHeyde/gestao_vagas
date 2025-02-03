package br.com.gabrielheyde.gestao_vagas.modules.Company.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.gabrielheyde.gestao_vagas.modules.Company.dto.AuthCompanyDTO;
import br.com.gabrielheyde.gestao_vagas.modules.Company.dto.AuthCompanyResponseDTO;
import br.com.gabrielheyde.gestao_vagas.modules.Company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCases {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthCompanyResponseDTO execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
            () -> {
                throw new UsernameNotFoundException("User Not Found");
            });

            var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

            if (passwordMatches == false) {
                throw new AuthenticationException();
            } else {
                Algorithm algorithm = Algorithm.HMAC256(secretKey);

                var expiresIn = Instant.now().plus(Duration.ofHours(2));

                var token = JWT.create().withIssuer("javagas")
                .withExpiresAt(expiresIn)
                .withSubject(company.getId().toString())
                .withClaim("roles", Arrays.asList("COMPANY"))
                .sign(algorithm);

                var authCompanyResponseDTO = AuthCompanyResponseDTO.builder()
                .access_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();

                return authCompanyResponseDTO;
            }
    }
}
