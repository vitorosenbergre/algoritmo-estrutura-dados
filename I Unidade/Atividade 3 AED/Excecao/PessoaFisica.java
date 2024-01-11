public class PessoaFisica extends Cliente {
  private String CPF;
  
  public PessoaFisica(String nome, String endereco, String telefone, String CPF){
    super(nome,endereco,telefone);
    this.CPF = CPF;
  }

  public String getCPF() {
    return CPF;
  }

  public void setCPF(String cPF) {
    CPF = cPF;
  }

}
