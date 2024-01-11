public class ControleFilas {

  private Fila filaTodos;
  private Fila fila1;
  private Fila fila2;
  private Fila fila3;

  
  public ControleFilas(Fila filaTodos){
    this.filaTodos = filaTodos;
    fila1 = new Fila();
    fila2 = new Fila();
    fila3 = new Fila();
  }

  public Fila getFilaTodos() {
    return filaTodos;
  }

  public void setFilaTodos(Fila filaTodos) {
    this.filaTodos = filaTodos;
  }

  
  public void inserirFilas(int tempo) throws ListaVaziaException, ObjetoNaoEncontradoException{
    Paciente pacienteTemporario;
    for(int i=1; i<=filaTodos.getCont();i++){
      pacienteTemporario = (Paciente) filaTodos.getPosicao(i);
      
      //System.out.println("id pacientes: "+ pacienteTemporario.getId());
      //System.out.println("Tempo de chegada paciente: "+ pacienteTemporario.getTempoDeChegada());
      //System.out.println("Grau do Paciente: "+ pacienteTemporario.getGrau());

      if(pacienteTemporario.getTempoDeChegada()==tempo && pacienteTemporario.getGrau()==1){
        fila1.enfileirar(pacienteTemporario);
        //System.out.println("entrou aqui fila1: Paciente: " + pacienteTemporario.getId());
        //System.out.println("Tempo: "+tempo);
      }
      if(pacienteTemporario.getTempoDeChegada()==tempo && pacienteTemporario.getGrau()==2){
        fila2.enfileirar(pacienteTemporario);
        //System.out.println("entrou aqui fila2: Paciente: " + pacienteTemporario.getId());
        //System.out.println("Tempo: "+tempo);
      }
      if(pacienteTemporario.getTempoDeChegada()==tempo && pacienteTemporario.getGrau()==3){
        fila3.enfileirar(pacienteTemporario);
        //System.out.println("entrou aqui fila3: Paciente: " + pacienteTemporario.getId());
        //System.out.println("Tempo: "+tempo);
      }
    }
  }

  public Paciente getPacienteFila(int fila) throws ListaVaziaException{
    Paciente paciente;
    switch(fila){
      case 1:
        paciente = (Paciente) fila1.getPrimeiro();
        return paciente;
      case 2:
        paciente = (Paciente) fila2.getPrimeiro();
        return paciente;
      case 3:
        paciente = (Paciente) fila3.getPrimeiro();
        return paciente;
      default:
        return paciente =null;
    }
  }

  public Fila getFila1() {
    return fila1;
  }

  public void setFila1(Fila fila1) {
    this.fila1 = fila1;
  }

  public Fila getFila2() {
    return fila2;
  }

  public void setFila2(Fila fila2) {
    this.fila2 = fila2;
  }

  public Fila getFila3() {
    return fila3;
  }

  public void setFila3(Fila fila3) {
    this.fila3 = fila3;
  }
}
