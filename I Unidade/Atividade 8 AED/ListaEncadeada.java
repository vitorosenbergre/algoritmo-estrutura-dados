//package lista;

public class ListaEncadeada{
    private Element head;
    private Element tail;

    
    public void fazVazia(){
        this.head=null;
        this.tail=null;
    }
    public void setHead(Element h) {
    	this.head = h;    	
    }
    public void setTail(Element t) {
    	this.tail = t;    	
    }
    public void inserirInicio(Object novo){
        Element temporario = new Element(novo, head);

        if(head==null)
            tail=temporario;
        head=temporario;
    }

    public void inserirFim(Object novo){
        Element temporario = new Element(novo, null);

        if(head==null)
            head=temporario;
        else
            tail.setNext(temporario);
        tail = temporario;
    }

    public Object getPrimeiro() throws ListaVaziaException{
        if(this.head==null)
            throw new ListaVaziaException();
        return this.head.getData();
    }

    public Object getUltimo() throws ListaVaziaException{
        if(this.tail==null)
            throw new ListaVaziaException();
        return this.tail.getData();
    }

    public boolean estaVazia(){
      if(this.head == null){
        return false;
      } else{
        return true;
      }
    }

    public Object getPosicao(int posicao) throws ListaVaziaException{
      if(this.head == null){
        throw new ListaVaziaException();
      }
      Object objeto =null;
      Element atual = getHead();
      int i =0;
      while(atual != null && i<posicao){
        objeto = atual.getData();
        atual = atual.getNext();
        i++;
      }

      return objeto;
    }
  
    public void extrair(Object item) throws ObjetoNaoEncontradoException{
        Element ponteiro = head;
        Element ponteiroAnterior = null;

        while(ponteiro != null && ponteiro.getData()!=item){
            ponteiroAnterior = ponteiro;
            ponteiro = ponteiro.getNext();
        }
        if(ponteiro == null)
            throw new ObjetoNaoEncontradoException();
        if(ponteiro == head)
            head = ponteiro.getNext();
        else
            ponteiroAnterior.setNext(ponteiro.getNext());
        if(ponteiro==tail)
            tail=ponteiroAnterior;
    }//fim metodo extrair

    public Element buscar(Object item) throws ObjetoNaoEncontradoException{
        Element ponteiro = head;

        while(ponteiro!=null && ponteiro.getData()!=item)
            ponteiro = ponteiro.getNext();
        if(ponteiro == null)
            throw new ObjetoNaoEncontradoException();
        else
            return ponteiro;
    }//fim metodo buscar

    

    public Element getTail(){
        return this.tail;
    }

    public Element getHead(){
        return this.head;
    }
}