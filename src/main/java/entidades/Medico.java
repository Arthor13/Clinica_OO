package entidades;

import excecoes.CpfInvalidoException;
import excecoes.CrmInvalidoException;
import java.time.LocalDate;

public class Medico extends Pessoa {

    private int crm;
    private String especialidade;

    public Medico(String nome, String cpf, LocalDate dataNascimento, int crm, String especialidade) throws CrmInvalidoException, CpfInvalidoException {
        super(nome, cpf, dataNascimento);
        setCrm(crm); // Verificação do CRM
        this.especialidade = especialidade;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) throws CrmInvalidoException {
        if (String.valueOf(crm).length() != 4) {
            throw new CrmInvalidoException("CRM inválido. Deve conter exatamente 4 dígitos.");
        }
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + getCpf() + "\nData de Nascimento: " + getDataNascimento() + "\nCRM: " + crm + "\nEspecialidade: " + especialidade;
    }
}
