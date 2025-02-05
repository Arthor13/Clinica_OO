package model;

public class Exame {
    private int id;
    private static int contadorID = 1;
    private String tipo;
    private String dataPreescricao;
    private String dataRealizacao;
    private String resultado;
    private Double custo;


    public Exame(int id, String tipo, String dataPreescricao, String dataRealizacao, String resultado, Double custo) {
        this.id = contadorID++;
        this.tipo = tipo;
        this.dataPreescricao = dataPreescricao;
        this.dataRealizacao = dataRealizacao;
        this.resultado = resultado;
        this.custo = custo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataPreescricao() {
        return dataPreescricao;
    }

    public void setDataPreescricao(String dataPreescricao) {
        this.dataPreescricao = dataPreescricao;
    }

    public String getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public void realizarExame(String dataRealizacao, String resultado){
    this.dataRealizacao = dataRealizacao;
    this.resultado = resultado;
    }
}
