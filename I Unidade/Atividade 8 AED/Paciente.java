public class Paciente {
  private int id;
  private int grau;
  private int tempoDeChegada;
  private int tempoDeEspera=0;
  private int tempoDeAtendimento=0;
  private int tempoTotal=0;
  private int tempoAntesAtendimento=0;


  public Paciente (int tempoDeChegada, int grau, int id){
    this.grau = grau;
    this. tempoDeChegada = tempoDeChegada;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getGrau() {
    return grau;
  }

  public void setGrau(int grau) {
    this.grau = grau;
  }

  public int getTempoDeChegada() {
    return tempoDeChegada;
  }

  public void setTempoDeChegada(int tempoDeChegada) {
    this.tempoDeChegada = tempoDeChegada;
  }

  public int getTempoDeEspera() {
    return tempoDeEspera;
  }

  public void setTempoDeEspera(int tempoDeEspera) {
    this.tempoDeEspera = tempoDeEspera;
  }

  public int getTempoDeAtendimento() {
    return tempoDeAtendimento;
  }

  public void setTempoDeAtendimento(int tempoDeAtendimento) {
    this.tempoDeAtendimento = tempoDeAtendimento;
  }

  public int getTempoTotal() {
    return tempoTotal;
  }

  public void setTempoTotal(int tempoTotal) {
    this.tempoTotal = tempoTotal;
  }

  public int getTempoAntesAtendimento() {
    return tempoAntesAtendimento;
  }

  public void setTempoAntesAtendimento(int tempoAntesAtendimento) {
    this.tempoAntesAtendimento = tempoAntesAtendimento;
  }
  public String toString(){
    return "Paciente: "+ id +" Tempo de chegada: "+ tempoDeChegada +"Tempo de Espera: "+ tempoDeEspera+"Tempo de Atendimento: "+tempoDeAtendimento+" Tempo Total: "+ tempoTotal; 
  }

}
