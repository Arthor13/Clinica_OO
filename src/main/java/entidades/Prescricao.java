package entidades;

public class Prescricao
{
    private int id;
    private List<Medicamento> medicamento = new ArrayList<>();
    private List<Exame> exame = new ArrayList<>();
    private Consulta consultaAssociada;
    private String dataValidade;

    public Prescricao(int id, List<Medicamento> medicamento, List<Exame> exame, Consulta consultaAssociada, String dataValidade)
    {
        this.id = id;
        this.medicamento = medicamento;
        this.exame = exame;
        this.consultaAssociada = consultaAssociada;
        this.dataValidade = dataValidade;
    }

    setMedicamento(List<Medicamento> medicamento)
    {
        this.medicamento = medicamento;
    }

    getMedicamento()
    {
        return medicamento;
    }

    setExame(List<Exame> exame)
    {
        this.exame = exame;
    }

    getExame()
    {
        return exame;
    }

    setConsultaAssociada(Consulta consultaAssociada)
    {
        this.consultaAssociada = consultaAssociada;
    }

    getConsultaAssociada()
    {
        return consultaAssociada;
    }

    setDataValidade(String dataValidade)
    {
        this.dataValidade = dataValidade;
    }

    getDataValidade()
    {
        return dataValidade;
    }

}