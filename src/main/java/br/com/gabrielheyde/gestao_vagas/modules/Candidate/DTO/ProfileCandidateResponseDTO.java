package br.com.gabrielheyde.gestao_vagas.modules.Candidate.DTO;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(example = "Desenvolvedor Java")
    private String description;

    @Schema(example = "maria_")
    private String username;

    @Schema(example = "maria_@gmail.com")
    private String email;

    private UUID id;

    @Schema(example = "Maria de Souza")
    private String name;
    
}
