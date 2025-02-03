package br.com.gabrielheyde.gestao_vagas.modules.Company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielheyde.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.gabrielheyde.gestao_vagas.modules.Company.Entities.JobEntity;
import br.com.gabrielheyde.gestao_vagas.modules.Company.repositories.CompanyRepository;
import br.com.gabrielheyde.gestao_vagas.modules.Company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.jobRepository.save(jobEntity);
    }
    
}
