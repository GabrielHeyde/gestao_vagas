package br.com.gabrielheyde.gestao_vagas.exceptions;

public class JobNotFoundException extends RuntimeException {

    public JobNotFoundException() {
        super("Job Not Found.");
    }
    
}
