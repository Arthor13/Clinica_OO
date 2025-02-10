package entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Exame {
    private int id;
    private static int contadorID = 1;
    private String tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultado;
    private Double custo;


    public Exame(String tipo,String dataPrescricao,Double custo) {
        this.id = contadorID++;
        this.tipo = tipo;
        this.dataPrescricao = converterData(dataPrescricao);
        this.dataRealizacao = null;
        this.resultado = null;
        this.custo = custo;
    }
    private static LocalDate converterData(String dataStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(dataStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de data inválido! Use dd/MM/yyyy.");
        }
    }


    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(LocalDate dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
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

    public void realizarExame(LocalDate dataRealizacao, String resultado){
    this.dataRealizacao = dataRealizacao;
    this.resultado = resultado;
    }
}
