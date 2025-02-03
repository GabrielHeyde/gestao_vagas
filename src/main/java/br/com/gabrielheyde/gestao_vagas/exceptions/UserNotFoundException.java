package br.com.gabrielheyde.gestao_vagas.exceptions;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException() {
        super("User Not Found.");
    }
}
