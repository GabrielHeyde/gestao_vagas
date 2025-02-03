package br.com.gabrielheyde.gestao_vagas.modules.Candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gabrielheyde.gestao_vagas.exceptions.UserFoundException;
import br.com.gabrielheyde.gestao_vagas.modules.Candidate.CandidateEntity;
import br.com.gabrielheyde.gestao_vagas.modules.Candidate.CandidateRepository;

@Service
public class CreateCandidateUserCases {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return this.candidateRepository.save(candidateEntity);
    }
    
}
