import javax.swing.JOptionPane;

public class TesteLista {
  public static void main(String[] args) throws ListaVaziaException, ObjetoNaoEncontradoException {
    ListaDuplamenteEncadeada listaNum = new ListaDuplamenteEncadeada();
    String num, controle = "";
    int numero;
    try {
      while (!controle.equals("n")) {
        num = JOptionPane.showInputDialog("Digite um número inteiro");
        numero = Integer.parseInt(num);
        listaNum.InsertHead(new Integer(numero));
        controle = JOptionPane.showInputDialog("Continuar (s/n)?");
      }
      while (!listaNum.isEmpty()) {
        System.out.println(listaNum.getFirst());
        listaNum.delete(listaNum.getFirst());
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
