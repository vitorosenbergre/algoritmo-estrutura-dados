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

    arvore.removerElemento(14);
    arvore.removerElemento(4);
    arvore.removerElemento(5);
    arvore.removerElemento(6);
    arvore.removerElemento(13);
    arvore.removerElemento(3);
    arvore.removerElemento(10);
    arvore.BuscaLargura();

    //System.out.println("------------------");
    //arvore.BuscaLargura();
    System.out.println("------------------");
    //arvore.ImprimeBuscaEmLarguraInvertido();
    //System.out.println(arvore.calculaAlturaEmLargura());
    //System.out.println(arvore.pesquisarValor(arvore.getRaiz(),4).getValor().toString());
    //arvore.inserir(10); // inserir a raiz
    //arvore.InsereOrdenado(arvore.getRaiz(), 6);
    //arvore.InsereOrdenado(arvore.getRaiz(), 4);
    //arvore.InsereOrdenado(arvore.getRaiz(), 11);
    //arvore.BuscaLargura();
    //System.out.println(arvore.calculaTotalNodes(arvore.getRaiz()));
    //System.out.println(arvore.calculaTotalFolhas(arvore.getRaiz()));
    //System.out.println(arvore.calculaTotalNaoFolhas(arvore.getRaiz()));
    System.out.println("------------------");

    
  }
}