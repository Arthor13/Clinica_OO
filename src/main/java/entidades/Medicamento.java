package entidades;

public class Medicamento {

    private int id;
    private String nome;
    private String tipo;
    private String dosagem;
    private static int contadorID = 1;

    public Medicamento(String nome, String tipo, String dosagem) {
        this.id = contadorID;
        this.nome = nome;
        this.tipo = tipo;
        this.dosagem = dosagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }
}