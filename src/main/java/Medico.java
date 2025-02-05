package model;

class Medico extends Pessoa {

    private int crm;
    private String especialidade;

    public Medico(String nome, String cpf, LocalDate dataNascimento, int crm, String especialidade) {
        super(nome, cpf, dataNascimento);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
