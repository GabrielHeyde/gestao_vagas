package br.com.gabrielheyde.gestao_vagas.modules.Candidate.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielheyde.gestao_vagas.modules.Company.Entities.JobEntity;
import br.com.gabrielheyde.gestao_vagas.modules.Company.repositories.JobRepository;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
    
}
