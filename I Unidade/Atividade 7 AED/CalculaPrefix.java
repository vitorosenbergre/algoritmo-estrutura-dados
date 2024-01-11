import pilha.PilhaEncadeada;

public class CalculaPrefix {
  private String entrada;
  PilhaEncadeada pilha;
  private Integer saida;

  public CalculaPrefix(String entrada){
    this.entrada = entrada;
    pilha = new PilhaEncadeada(); // criação da nova pilha
  }

  public Integer Calcular(){
    
    char atual;
    int controlador=0;

    for(int i =0; i<entrada.length();i++){
      atual = entrada.charAt(i);
      if(Utilidades.VerificaOperador(atual)){
        controlador++;
        pilha.push(String.valueOf(atual));
      }else if(Utilidades.VerificaDigito(atual) && controlador == 2){
        Object a, b;
        String aString, bString;
        Integer op1, op2;

        a = pilha.pop();
        b = pilha.pop();

        aString = String.valueOf(a);
        bString = String.valueOf(b);
      
        op1 = Integer.parseInt(aString);
        op2 = Integer.parseInt(bString);
        
        saida = Utilidades.CalculaExpPosfix(atual, op1, op2);
        System.out.println(saida);
        pilha.push(saida);
      }
    }
    return saida;
  }
}