package br.com.gabrielheyde.gestao_vagas.modules.Candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielheyde.gestao_vagas.exceptions.JobNotFoundException;
import br.com.gabrielheyde.gestao_vagas.exceptions.UserNotFoundException;
import br.com.gabrielheyde.gestao_vagas.modules.Candidate.CandidateRepository;
import br.com.gabrielheyde.gestao_vagas.modules.Candidate.entity.ApplyJobEntity;
import br.com.gabrielheyde.gestao_vagas.modules.Candidate.repository.ApplyJobRepository;
import br.com.gabrielheyde.gestao_vagas.modules.Company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {
        this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });
        this.jobRepository.findById(idJob)
        .orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        var applyJob = ApplyJobEntity.builder()
        .candidate_id(idCandidate)
        .job_id(idJob).build();

        applyJob = applyJobRepository.save(applyJob);
        return applyJob;
    }
    
}
