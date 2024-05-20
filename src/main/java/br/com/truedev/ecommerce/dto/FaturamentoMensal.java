package br.com.truedev.ecommerce.dto;

public class FaturamentoMensal {
    private Integer mes;
    private Double valor;

    public FaturamentoMensal(Integer mes, Double valor) {
        this.mes = mes;
        this.valor = valor;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
