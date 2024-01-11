import java.util.Scanner;

public class Atendimento {
  public static void main(String[] args) throws ListaVaziaException, ObjetoNaoEncontradoException {
    
    // tempos medios de antendimento
    int tf1 =2;
    int tf2 =4;
    int tf3 =8;

    int i=0;
  
    // controlar os tempos agora
    int tempo =0;

    // fila que armazena todos os pacientes
    Fila filaTodos = new Fila();
    
    // fila que vai fazer o controle do algoritmo
    ControleFilas controle = new ControleFilas(filaTodos);

    // fila que vai armazenar os que foram interrompidos
    Fila filaStandby = new Fila();

    // fila que representa o paciente sendo atendido
    Fila filaAtendimento = new Fila();

    // paciente 1 e 2 tempos corretos = tempo total(tempo que percorreu) - (tempo de chegada -1);
    // paciente 3 4 5 tempo corretos -1 = tempo total(tempo que percorreu) - (tempo de chegada -1);
    // paciente 6 tempo correto -3 = tempo total(tempo que percorreu) - (tempo de chegada -1);
    // tempo de espera = tempo total - tempo de atendimento; Ex: 8 - 8 = 0, Ex2: 13-5 = 8

    // variavel usada pra fazer o cast da filaAtendimento
    Paciente pacienteTemporario = null;

    // variavel usada para fazer o cast da filaStandby
    Paciente pacienteStand = null;

    // scanner para leitura
    Scanner sc1 = new Scanner(System.in);

    System.out.println("Quer adicionar pacientes ? 1/0");
    int nome = sc1.nextInt();
    
    // public Paciente (int tempoDeChegada, int grau, int id)

    do{

      i++;
      if(nome==1){
        System.out.println("Tempo de Chegada do paciente: ");
        int tempodechegada = sc1.nextInt();
        System.out.println("Prioridade do paciente: ");
        int prioridade = sc1.nextInt();
        Paciente p = new Paciente(tempodechegada,prioridade,i);
        filaTodos.enfileirar(p);

        System.out.println("Deseja adicionar outro paciente ? 1/0");
        nome = sc1.nextInt();

      }else{
        filaTodos.enfileirar(new Paciente(1,2,1));
        filaTodos.enfileirar(new Paciente(1,1,2));
        filaTodos.enfileirar(new Paciente(2,3,3));
        filaTodos.enfileirar(new Paciente(2,2,4));
        filaTodos.enfileirar(new Paciente(2,1,5));
        filaTodos.enfileirar(new Paciente(4,2,6));
      }
    }while(nome == 1);


    do{
      tempo++;
      controle.inserirFilas(tempo);

      if(filaAtendimento.estaVazia() != false){
        pacienteTemporario = (Paciente) filaAtendimento.getPrimeiro();
      }

      // ------------------------ comeco da fila3---------------
      if(controle.getFila3().estaVazia()!= false){
        if(filaAtendimento.estaVazia() != false && pacienteTemporario.getGrau() != 3){
          pacienteStand = (Paciente) filaAtendimento.getPrimeiro();
          pacienteStand.setTempoAntesAtendimento(pacienteStand.getTempoDeAtendimento());
          pacienteStand.setTempoDeAtendimento(0);
          filaStandby.enfileirar(pacienteStand);
          filaAtendimento.desenfileirarInicio();
          filaAtendimento.enfileirar(controle.getPacienteFila(3));
        }

        controle.getPacienteFila(3).setTempoDeAtendimento(controle.getPacienteFila(3).getTempoDeAtendimento()+1);

        if(controle.getPacienteFila(3).getTempoDeAtendimento()==tf3){
          filaAtendimento.desenfileirarInicio();
          controle.getPacienteFila(3).setTempoTotal(tempo-(controle.getPacienteFila(3).getTempoDeChegada()-1));
          controle.getPacienteFila(3).setTempoDeEspera(controle.getPacienteFila(3).getTempoTotal()-controle.getPacienteFila(3).getTempoDeAtendimento());
          
          
          System.out.println("Paciente: "+controle.getPacienteFila(3).getId());
          System.out.println("Prioridade: "+ controle.getPacienteFila(3).getGrau());
          System.out.println("Tempo de Espera: "+ controle.getPacienteFila(3).getTempoDeEspera());
          System.out.println("Tempo de Atendimento: "+ controle.getPacienteFila(3).getTempoDeAtendimento());
          System.out.println("Tempo total: "+ controle.getPacienteFila(3).getTempoTotal());
          System.out.println("");

          if(filaStandby.estaVazia() != false){
            filaAtendimento.enfileirar(filaStandby.getPrimeiro());
            filaStandby.desenfileirarInicio();
          }
          controle.getFila3().desenfileirarInicio();
        } // --------------------------- comeco da fila2-----------------------------
      }else if((controle.getFila2().estaVazia()!= false && filaAtendimento.estaVazia()==false) || (controle.getFila2().estaVazia()!= false && pacienteTemporario.getGrau()==2)){

        if(filaAtendimento.estaVazia()== false){
          filaAtendimento.enfileirar(controle.getPacienteFila(2));
        }

        controle.getPacienteFila(2).setTempoDeAtendimento(controle.getPacienteFila(2).getTempoDeAtendimento()+1);

        if(controle.getPacienteFila(2).getTempoDeAtendimento()==tf2){
          controle.getPacienteFila(2).setTempoDeAtendimento(controle.getPacienteFila(2).getTempoDeAtendimento()+controle.getPacienteFila(2).getTempoAntesAtendimento());
          controle.getPacienteFila(2).setTempoTotal(tempo-(controle.getPacienteFila(2).getTempoDeChegada()-1));
          controle.getPacienteFila(2).setTempoDeEspera(controle.getPacienteFila(2).getTempoTotal()-controle.getPacienteFila(2).getTempoDeAtendimento());
          
          System.out.println("Paciente: "+controle.getPacienteFila(2).getId());
          System.out.println("Prioridade: "+ controle.getPacienteFila(2).getGrau());
          System.out.println("Tempo de Espera: "+ controle.getPacienteFila(2).getTempoDeEspera());
          System.out.println("Tempo de Atendimento: "+controle.getPacienteFila(2).getTempoDeAtendimento());
          System.out.println("Tempo Total: "+ controle.getPacienteFila(2).getTempoTotal());
          System.out.println("");
          
          controle.getFila2().desenfileirarInicio();
          filaAtendimento.desenfileirarInicio();
        }
          // -----------------------------------comeco da fila 1----------------------------------
      }else if((controle.getFila1().estaVazia()!= false && filaAtendimento.estaVazia()==false) || (controle.getFila1().estaVazia()!= false && pacienteTemporario.getGrau()==1)){
        
        if(filaAtendimento.estaVazia()== false){
          filaAtendimento.enfileirar(controle.getPacienteFila(1));
        }

        controle.getPacienteFila(1).setTempoDeAtendimento(controle.getPacienteFila(1).getTempoDeAtendimento()+1);

        if(controle.getPacienteFila(1).getTempoDeAtendimento()==tf1){
          controle.getPacienteFila(1).setTempoDeAtendimento(controle.getPacienteFila(1).getTempoDeAtendimento()+controle.getPacienteFila(1).getTempoAntesAtendimento());
          controle.getPacienteFila(1).setTempoTotal(tempo-(controle.getPacienteFila(1).getTempoDeChegada()-1));
          controle.getPacienteFila(1).setTempoDeEspera(controle.getPacienteFila(1).getTempoTotal()-controle.getPacienteFila(1).getTempoDeAtendimento());
          
          System.out.println("Paciente: "+controle.getPacienteFila(1).getId());
          System.out.println("Prioridade: "+ controle.getPacienteFila(1).getGrau());
          System.out.println("Tempo de Espera: "+ controle.getPacienteFila(1).getTempoDeEspera());
          System.out.println("Tempo de Atendimento: "+controle.getPacienteFila(1).getTempoDeAtendimento());
          System.out.println("Tempo Total: "+ controle.getPacienteFila(1).getTempoTotal());
          System.out.println("");
          
          controle.getFila1().desenfileirarInicio();
          filaAtendimento.desenfileirarInicio();
        }
      }

    }while(controle.getFila1().estaVazia() != false || controle.getFila2().estaVazia() != false ||
     controle.getFila3().estaVazia() != false || filaAtendimento.estaVazia() != false);

     sc1.close();
  }
}
