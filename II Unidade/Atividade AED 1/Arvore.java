import java.util.ArrayList;

public class Arvore<T extends Comparable> {
  
  private Elemento<T> raiz;

  public Arvore(){
    this.raiz =null;
  }

  public void inserir(T valor){
    Elemento<T> novoElemento = new Elemento<T>(valor);
    if(raiz ==null){
      raiz = novoElemento;
    }else{
      Elemento<T> atual = this.raiz;
      while(true){
        if(novoElemento.getValor().compareTo(atual.getValor())==-1){
          if(atual.getEsquerda() != null){
            atual = atual.getEsquerda();
          }else{
            atual.setEsquerda(novoElemento);
            break;
          }
        }else{
          if(atual.getDireita() != null){
            atual = atual.getDireita();
          }else{
            atual.setDireita(novoElemento);
            break;
          }
        }
      }
    }
  }

  public void ImprimePreOrdem(Elemento<T> elementoPercorrido){
    if(elementoPercorrido!=null){
      ImprimePreOrdem(elementoPercorrido.getEsquerda());
      System.out.println(elementoPercorrido.getValor());
      ImprimePreOrdem(elementoPercorrido.getDireita());
      
    }
  }
  
  public void BuscaLargura(){
    ArrayList <Elemento<T>> marcado = new ArrayList<Elemento<T>>();
    ArrayList <Elemento<T>> fila = new ArrayList<Elemento<T>>();
    Elemento<T> atual = this.raiz;
    marcado.add(atual);
    System.out.println(atual.getValor());
    fila.add(atual);
    while(fila.size() >0){
      Elemento<T> visitado = fila.get(0);

      if(visitado.getDireita()!= null){
        if(!marcado.contains(visitado.getDireita())){
          marcado.add(visitado.getDireita());
          System.out.println(visitado.getDireita().getValor());
          fila.add(visitado.getDireita());
        }
      }

      if(visitado.getEsquerda()!=null){
        if(!marcado.contains(visitado.getEsquerda())){
          marcado.add(visitado.getEsquerda());
          System.out.println(visitado.getEsquerda().getValor());
          fila.add(visitado.getEsquerda());
        }
      }

      fila.remove(0);
    }
  }
  
  public void ImprimeBuscaEmLarguraInvertido(){
    ArrayList <Elemento<T>> marcado = new ArrayList<Elemento<T>>();
    ArrayList <Elemento<T>> fila = new ArrayList<Elemento<T>>();

    Elemento<T> atual = this.raiz;
    marcado.add(atual);
    fila.add(atual);
    while(fila.size() >0){
      Elemento<T> visitado = fila.get(0);

      if(visitado.getDireita()!= null){
        if(!marcado.contains(visitado.getDireita())){
          marcado.add(visitado.getDireita());
          fila.add(visitado.getDireita());
        }
      }

      if(visitado.getEsquerda()!=null){
        if(!marcado.contains(visitado.getEsquerda())){
          marcado.add(visitado.getEsquerda());
          fila.add(visitado.getEsquerda());
        }
      }

      fila.remove(0);
    }

    for(int i=1; i<= marcado.size();i++){
      System.out.println(marcado.get(marcado.size()-i).getValor());
    }
  }


  public Elemento<T> getRaiz() {
    return raiz;
  }

  public void setRaiz(Elemento<T> raiz) {
    this.raiz = raiz;
  }
} 
