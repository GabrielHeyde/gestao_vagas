package br.com.gabrielheyde.gestao_vagas.modules.Company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gabrielheyde.gestao_vagas.exceptions.UserFoundException;
import br.com.gabrielheyde.gestao_vagas.modules.Company.Entities.CompanyEntity;
import br.com.gabrielheyde.gestao_vagas.modules.Company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCases {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });
        
        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);

        return this.companyRepository.save(companyEntity);
    }
    
}
