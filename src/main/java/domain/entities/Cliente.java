package domain.entities;

public class Cliente {
    private Pessoa pessoa;
    private String enderecoEmail;

    public Cliente(Pessoa pessoa, String email) {
        this.pessoa = pessoa;
        this.enderecoEmail = email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

}
