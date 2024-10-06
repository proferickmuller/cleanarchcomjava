package domain.entities;

public class Ingresso {
    DataEvento dataEvento;
    Pessoa pessoa;

    public Ingresso(DataEvento data, Pessoa pessoa) {
        this.dataEvento = data;
        this.pessoa = pessoa;
    }

    public DataEvento getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(DataEvento dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
