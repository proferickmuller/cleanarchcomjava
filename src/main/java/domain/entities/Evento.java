package domain.entities;

import java.util.ArrayList;

public class Evento {
    private String nome;
    private final ArrayList<DataEvento> datas;
    private boolean isRestrito;
    private Integer lotacao;

    public Evento(String nome) {
        this.nome = nome;
        this.datas = new ArrayList<>();
    }

    public ArrayList<DataEvento> getDatas() {
        return datas;
    }

    public void adicionarData(DataEvento data) {
        this.datas.add(data);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isRestrito() {
        return isRestrito;
    }

    public void setRestrito(boolean restrito) {
        isRestrito = restrito;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }
}