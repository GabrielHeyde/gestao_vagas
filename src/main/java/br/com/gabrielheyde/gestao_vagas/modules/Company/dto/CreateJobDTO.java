package br.com.gabrielheyde.gestao_vagas.modules.Company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolvedora Júnior.", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "TotalPass, VR, Plano de Saúde", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    
    @Schema(example = "JÚNIOR", requiredMode = RequiredMode.REQUIRED)
    private String level;
    
}
