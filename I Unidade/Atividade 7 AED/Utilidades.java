
public class Utilidades {
  
  public static boolean VerificaDigito(char caracter){

    switch(caracter){
      case '0':
        return true;
      case '1':
        return true;
      case '2':
        return true;
      case '3':
        return true;
      case '4':
        return true;
      case '5':
        return true;
      case '6':
        return true;
      case '7':
        return true;
      case '8':
        return true;
      case '9':
        return true;
      default:
        return false;
    }
  }

  public static boolean VerificaOperador(char caracter){

    switch(caracter){
      case '+':
      case '-':
      case '/':
      case '*':
      case '$':
      case '(':
      case ')':
        return true; 
      default:
        return false;
    }
  }

  public static int VerificaPrioridade(char caracter){

    switch(caracter){
      case '+':
        return 1;
      case '-':
        return 1;
      case '*':
        return 2;
      case '/':
        return 2;
      case '$':
        return 3;
      case '(':
        return 4;
      case ')': 
        return 4;
      default:
        return -1;
    }
  }

  public static Integer CalculaExpPosfix(char operador, Integer dir, Integer esq){
    switch(operador){
      case '+': 
        return esq + dir;
      case '-':
        return esq - dir;
      case '/': 
        return esq / dir;
      case '*':
        return esq * dir;
      case '$':
        return (int) Math.pow(esq,dir);
      default:
        return -1;
    }
  }
}
