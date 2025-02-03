package br.com.gabrielheyde.gestao_vagas.modules.Company.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "job")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "Vaga para Design.")
    private String description;

    @Schema(example = "Totalpass, Alura, VR")
    private String benefits;

    @Schema(example = "SÊNIOR")
    @NotBlank(message = "Este campo é obrigatório.")
    private String level;

    @ManyToOne()
    @JoinColumn(name = "id_company", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name = "id_company", nullable = false)
    private UUID id_company;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
