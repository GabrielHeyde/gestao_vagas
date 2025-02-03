package br.com.gabrielheyde.gestao_vagas.modules.Company.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gabrielheyde.gestao_vagas.modules.Company.Entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
    
}
