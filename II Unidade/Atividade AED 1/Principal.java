public class Principal {
  public static void main(String[] args) {
    Arvore<Integer> arvore = new Arvore<Integer>();

    arvore.inserir(10);
    arvore.inserir(5);
    arvore.inserir(13);
    arvore.inserir(14);
    arvore.inserir(6);
    arvore.inserir(4);
    arvore.inserir(3);

    arvore.BuscaLargura();
    arvore.ImprimeBuscaEmLarguraInvertido();
  }
}
