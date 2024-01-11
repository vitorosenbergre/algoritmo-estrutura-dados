public class Conta {
  private Cliente cliente;
  private String numero;
  private double saldo;

  public Conta(Cliente cliente, String numero, double saldo) {
    this.numero = numero;
    this.saldo = saldo;
    this.cliente = cliente;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void debitarMoney(Conta contaDebito, double money) throws SaldoInsuficienteException{
    if(money<= contaDebito.getSaldo()){
      contaDebito.setSaldo(contaDebito.getSaldo()-money);
    }else{
      SaldoInsuficienteException ex;
      ex = new SaldoInsuficienteException(contaDebito.getSaldo(),contaDebito.getNumero());
      throw ex;
    }
  }

  public void transferirMoney(Conta contaReceber,Conta contaTransferir, double money)
      throws SaldoInsuficienteException {
    if(money<= contaTransferir.getSaldo()){
      contaReceber.setSaldo(contaReceber.getSaldo()+money);
      contaTransferir.setSaldo(contaTransferir.getSaldo()-money);
    }else{
      SaldoInsuficienteException ex;
      ex = new SaldoInsuficienteException(contaTransferir.getSaldo(),contaTransferir.getNumero());
      throw ex;
    }
  }

  public String toString (){
    return "Numero da Conta: " + numero+ "\nAgencia: " + cliente + saldo;
  }
  
}
