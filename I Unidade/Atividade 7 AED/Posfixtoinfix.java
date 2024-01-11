//import pilha.PilhaEncadeada;

public class Posfixtoinfix {
    private String entrada;
    PilhaEncadeada pilha;
    private String saida ="";
    
    private boolean verificador = true;
  
    public Posfixtoinfix(String entrada){
      this.entrada = entrada;
      pilha = new PilhaEncadeada(); // criação da nova pilha
    }

    public String Transformar(){
      
      char atual;
      int i =0;
      while(verificador){
        atual = entrada.charAt(i);
    
        if(Utilidades.VerificaDigito(atual)){
          pilha.push(String.valueOf(atual));
        }else if(Utilidades.VerificaOperador(atual)){
          Object a, b;
          String aString, bString;

          a = pilha.pop();
          b = pilha.pop();

          aString = String.valueOf(a);
          bString = String.valueOf(b);
        
          saida = bString + atual + aString;

          System.out.println(saida);
          pilha.push(saida);
        }
        i++;
        if(entrada.length()==saida.length()){
          verificador = false;
        }
      }
      return saida;
    }
}
