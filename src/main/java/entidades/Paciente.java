package entidades;

class Paciente extends Pessoa {

    private List<String> historicoExames;
    private boolean pagamentoPendente;

    public Paciente(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.historicoExames = new ArrayList<>();
        this.pagamentoPendente = false;
    }

    public List<String> getHistoricoExames() {
        return historicoExames;
    }

    public void adicionarExame(String exame) {
        historicoExames.add(exame);
    }

    public boolean isPagamentoPendente() {
        return pagamentoPendente;
    }

    public void bloquearCadastro() {
        this.pagamentoPendente = true;
    }

    public void realizarPagamento() {
        this.pagamentoPendente = false;
    }
}