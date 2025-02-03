package br.com.gabrielheyde.gestao_vagas.modules.Candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Daniel de Souza")
    private String name;

    @Schema(example = "daniel_souza")
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços em branco.")
    private String username;

    @Schema(example = "daniel_souza@hotmail.com")
    @Email(message = "O campo [e-mail] deve conter um endereço de e-mail válido.")
    private String email;

    
    @Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres.")
    @Schema(example = "admin1234", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha do candidato")
    private String password;

    @Schema(example = "Desenvolvedor Java Pleno.")
    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createAt;
    
}
