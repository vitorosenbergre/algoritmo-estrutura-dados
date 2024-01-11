import javax.swing.JOptionPane;

public class TesteLista {
  public static void main(String[] args) throws ListaVaziaException, ObjetoNaoEncontradoException {
    ListaEncadeada listaNum = new ListaEncadeada();
    String num, controle = "";
    int numero;
    try {
      while (!controle.equals("n")) {
        num = JOptionPane.showInputDialog("Digite um número inteiro");
        numero = Integer.parseInt(num);
        listaNum.inserirInicio(new Integer(numero));
        controle = JOptionPane.showInputDialog("Continuar (s/n)?");
      }
      while (!listaNum.isEmpty()) {
        System.out.println(listaNum.getPrimeiro());
        listaNum.extrair(listaNum.getPrimeiro());
      }
    } catch (ListaVaziaException exempty) {

      System.out.println(exempty.getMessage()); // throw lista vazia, trantando exeção.

    } catch (ObjetoNaoEncontradoException exobjt) {
      System.out.println("Data: " + exobjt.getData());
      System.out.println(exobjt.getMessage()); // throw objeto n encontrado, tratando a exeção.

    }
    System.exit(0);
  }
}
