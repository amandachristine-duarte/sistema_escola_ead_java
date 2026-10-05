public class Mensalidade {

    private double valor;
    private boolean pago;


    // Construtor

    public Mensalidade(double valor) {

        this.valor = valor;
        this.pago = false;
    }


    // Getter

    public double getValor() {

        return valor;
    }


    public boolean isPago() {

        return pago;
    }


    // Setters

    public void setValor(double valor) {

        this.valor = valor;
    }


    public void setPago(boolean pago) {

        this.pago = pago;
    }


    // Dá baixa na mensalidade

    public void darBaixa() {

        pago = true;
    }
}