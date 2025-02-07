package servicos;

import java.time.LocalDate;


public class Pagamento {
    private Double valor;
    private LocalDate dataPagamento;
    private PagamentoStatus status;

    // Constructor
    public Pagamento(Double valor) {
        this.valor = valor;
        this.dataPagamento = null;
        this.status = PagamentoStatus.PENDENTE;
    }

    // Getter e Setter para Valor
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    // Getter e Setter para dataPagamento
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    // Getter e Setter para Status
    public PagamentoStatus getStatus() {
        return status;
    }

    public void realizarPagamento(){
        if (this.status == PagamentoStatus.PENDENTE){
            this.status = PagamentoStatus.PAGO;
            this.dataPagamento = LocalDate.now();
            System.out.println("Pagamento Realizado com Sucesso!");
        } else {
            System.out.println("Este pagamento ja foi processado ou cancelado.");
        }
    }

    public void cancelarPagamento(){
        if (this.status == PagamentoStatus.PENDENTE){
            this.status = PagamentoStatus.CANCELADO;
            System.out.println("Pagamento Cancelado!");
        } else {
            System.out.println("Não é possivel cancelar um pagamento já Realizado!");
        }
    }
}
