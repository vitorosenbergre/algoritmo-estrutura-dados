import java.util.ArrayList;

public class Arvore<T extends Comparable> {
  
  private Elemento<T> raiz;
  private ArrayList <Elemento<T>> marcado;
  private ArrayList <Elemento<T>> fila;

  public Arvore(){
    this.raiz =null;
    marcado = new ArrayList<Elemento<T>>();
    fila = new ArrayList<Elemento<T>>();
  }

  public void inserir(T valor){
    Elemento<T> novoElemento = new Elemento<T>(valor);
    if(raiz ==null){
      raiz = novoElemento;
      fila.add(this.raiz);
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

      if(fila.size()==0){
        return;
      }else{

      Elemento<T> visitado = fila.get(0);
      
      if(visitado ==raiz){
        System.out.println(visitado.getValor());
      }

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
      BuscaLargura();
  }
  
  public void ImprimeBuscaEmLarguraInvertido(){
    if(fila.size()==0){

      for(int i=1; i<= marcado.size();i++){
        System.out.println(marcado.get(marcado.size()-i).getValor());
        if(i==marcado.size()){
          System.out.println(raiz.getValor());
        }
      }
        return;
      }else{

      Elemento<T> visitado = fila.get(0);
      
      if(visitado ==raiz){
       // System.out.println(visitado.getValor());
      }

      if(visitado.getDireita()!= null){
        if(!marcado.contains(visitado.getDireita())){
          marcado.add(visitado.getDireita());
          //System.out.println(visitado.getDireita().getValor());
          fila.add(visitado.getDireita());
        }
      }

      if(visitado.getEsquerda()!=null){
        if(!marcado.contains(visitado.getEsquerda())){
          marcado.add(visitado.getEsquerda());
          //System.out.println(visitado.getEsquerda().getValor());
          fila.add(visitado.getEsquerda());
        }
      }

      fila.remove(0);
    }
    ImprimeBuscaEmLarguraInvertido();
    }

  public int calculaAlturaEmLargura() {

    ArrayList <Elemento<T>> f= new ArrayList<Elemento<T>>();
    ArrayList <Integer> distancia= new ArrayList<>();

    f.add(raiz);

    distancia.add(0);

    int altura_maxima = 0;

    while( f.size()!=0) {

      Elemento<T>  no = (Elemento<T>)f.get(0); // desenfileirar
      int dist_pai = (int) distancia.get(0); // desenfileirar

      if (no.getEsquerda()!=null) {
          f.add(no.getEsquerda());
          distancia.add(dist_pai + 1);
      }

       if (no.getDireita()!=null) {
        f.add(no.getDireita());
        distancia.add(dist_pai + 1);
      }

      if (dist_pai > altura_maxima) 
        altura_maxima = dist_pai;

        f.remove(0);
        distancia.remove(0);
    }
      return altura_maxima;
  }
                                  
  public Boolean InsereOrdenado(Elemento <T> a, T v ) {

    if (v.compareTo(a.getValor())<0) {  
		  //o valor deve ser inserido a esquerda do no atual
	    if (a.getEsquerda()!=null) 
	      return InsereOrdenado(a.getEsquerda(),v);//senao for nulo continua navegando na arvore ate encontrar uma folha
	    else {
	      Elemento<T> n = new Elemento<T>(v);//se for nulo, cria o no e adiciona na folha
	      a.setEsquerda(n);
	      return true;	    	
	    }	      	 
	   }
	  else {
		   //o valor deve ser inserido a direita atual
      if (a.getDireita()!=null)
			      return InsereOrdenado(a.getDireita(),v);
			 else {
			      Elemento<T> n = new Elemento<T>(v);
			      a.setDireita(n);
			      return true;	    	
			    }     	 
	  }
  }

  public Elemento<T> pesquisarValor(Elemento <T> a, T v){

    if(v.compareTo(a.getValor())<0){
      if(a.getEsquerda()!=null){
        return pesquisarValor(a.getEsquerda(), v); // o valor pode estah na arvore esquerda
      }else{
        return null;
      }
    }else if(v.compareTo(a.getValor())>0){
      if(a.getDireita()!=null){
        return pesquisarValor(a.getDireita(), v); // o valor pode estah na arvore esquerda
      }else{
        return null;
      }
    }else{
      return a;
    }
  }

  public int calculaTotalNodes(Elemento<T> a) {
	  int totalesq=0;
	  int totaldir=0;   
	      
	   if (a.getEsquerda()!=null) {
	     totalesq = calculaTotalNodes(a.getEsquerda()); 
	   }
	   if (a.getDireita()!=null) {
	     totaldir = calculaTotalNodes(a.getDireita());
	   }
	   
	   return totalesq+totaldir + 1;
   }

   public int calculaTotalFolhas(Elemento<T> a) {
	  int totalesq=0;
	  int totaldir=0; 
    boolean folha = true;
    
    if(a.getEsquerda()!=null){
      totalesq = calculaTotalFolhas(a.getEsquerda());
      folha = false;
    }

	  if (a.getDireita()!=null) {
      totaldir = calculaTotalFolhas(a.getDireita());
      folha = false;
    }

    if(folha){
      return 1;
    }else{ 
      return (totaldir+totalesq);
    }
  }

  public int calculaTotalNaoFolhas(Elemento<T> a) {
	  return(calculaTotalNodes(a)-calculaTotalFolhas(a));
  }

  public void removerElemento(T valor){
    Elemento<T> nodeAtual = this.raiz;
    Elemento<T> nodePaiAtual = null;

    while(nodeAtual!= null){
      if(nodeAtual.getValor().equals(valor)){
        break;
      }else if(valor.compareTo(nodeAtual.getValor()) < 0){ 
        nodePaiAtual = nodeAtual;
        nodeAtual = nodeAtual.getEsquerda();
      }else{
        nodePaiAtual = nodeAtual;
        nodeAtual = nodeAtual.getDireita();
      }
    }

    if(nodeAtual!=null){

      // se node tem 2 filhos ou 1 filho a direita
      if(nodeAtual.getDireita()!= null){

        //inicio da remocao
        Elemento<T> NodeBusca = nodeAtual.getDireita();
        Elemento<T> NodeBuscaPai = nodeAtual;
        while(NodeBusca.getDireita()!= null){
          NodeBuscaPai = NodeBusca; 
          NodeBusca = NodeBusca.getEsquerda();                           
        }                                                               
        NodeBusca.setEsquerda(nodeAtual.getEsquerda());               
        if(nodePaiAtual!=null){                                              
          // colocar no lugar do atual ( substitui)
          if(nodeAtual.getValor().compareTo(nodePaiAtual.getValor()) < 0){
            nodePaiAtual.setEsquerda(NodeBusca);
          }else{
            nodePaiAtual.setDireita(NodeBusca);
          }
        }else{ // n tem pai atual, entao eh a raiz
            this.raiz = NodeBusca;
        }
        // remove o elemento da arvore
        if(NodeBusca.getValor().compareTo(NodeBuscaPai.getValor()) < 0){
          NodeBuscaPai.setEsquerda(null);
        }else{
          NodeBuscaPai.setDireita(null);
        }
        // fim da remocao

        // se tiver um filho a esquerda
      }else if(nodeAtual.getEsquerda()!= null){
        //inicio da remocao
        Elemento<T> NodeBusca = nodeAtual.getEsquerda();
        Elemento<T> NodeBuscaPai = nodeAtual;                   
        while(NodeBusca.getDireita()!= null){                 
          NodeBuscaPai = NodeBusca;                         
          NodeBusca = NodeBusca.getDireita();            
        }                                             

        if(nodePaiAtual!=null){                                   
          // colocar no lugar do atual ( substitui)
          if(nodeAtual.getValor().compareTo(nodePaiAtual.getValor()) < 0){
            nodePaiAtual.setEsquerda(NodeBusca);
          }else{
            nodePaiAtual.setDireita(NodeBusca);
          }
        }else{ // se o node for a raiz                     
          this.raiz = NodeBusca;                          
        }
        // remove o elemento da arvore
        if(NodeBusca.getValor().compareTo(NodeBuscaPai.getValor()) < 0){
          NodeBuscaPai.setEsquerda(null);
        }else{
          NodeBuscaPai.setDireita(null);
        }
        // fim da remocao          
      }else{ // se for folha
        if(nodePaiAtual!= null){
          if(nodeAtual.getValor().compareTo(nodePaiAtual.getValor()) < 0){
            nodePaiAtual.setEsquerda(null);
          }else{
            nodePaiAtual.setDireita(null);
          }
        }else{
          this.raiz =null;
        }
      }
    } 
  }

  
  public Elemento<T> getRaiz() {
    return raiz;
  }

  public void setRaiz(Elemento<T> raiz) {
    this.raiz = raiz;
  }
} 
