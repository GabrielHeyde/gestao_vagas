package br.com.gabrielheyde.gestao_vagas.modules.Candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{

    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
    
    Optional<CandidateEntity> findByUsername(String username);
}
