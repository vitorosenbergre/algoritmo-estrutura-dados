
class Elemento extends Arvore {
  public final Arvore esquerda, direita; 

  public Elemento(Arvore esquerda, Arvore direita) {
      super(esquerda.frequencia + direita.frequencia);
      this.esquerda = esquerda;
      this.direita = direita;
  }
}