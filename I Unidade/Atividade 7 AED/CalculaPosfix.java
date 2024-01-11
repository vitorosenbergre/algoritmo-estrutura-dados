//import pilha.PilhaEncadeada;

public class CalculaPosfix {
  private String entrada;
  PilhaEncadeada pilha;
  private Integer saida;

  public CalculaPosfix(String entrada){
    this.entrada = entrada;
    pilha = new PilhaEncadeada(); // criação da nova pilha
  }

  public Integer Calcular(){
    
    char atual;

    for(int i =0; i<entrada.length();i++){
      atual = entrada.charAt(i);
      if(Utilidades.VerificaDigito(atual)){
        pilha.push(String.valueOf(atual));
      }else if(Utilidades.VerificaOperador(atual)){
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

  public static void main(String[] args) {
    //String entrada = "56+6-";
    String entrada = "42$3*3-";
    //Integer out;
    String saidainfix;
    Posfixtoinfix infixtopos = new Posfixtoinfix(entrada);
    //CalculaPosfix pos = new CalculaPosfix(entrada);
    //out = pos.Calcular();
    saidainfix = infixtopos.Transformar();

    System.out.println("A expressao posfixa eh: " +entrada);
    //System.out.println("O calculo da expressao eh: "+out);
    System.out.println("O calculo da expressao eh: "+saidainfix);
  }
}
