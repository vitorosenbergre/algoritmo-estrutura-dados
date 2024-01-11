//package lista;

public class Element{
  private Object data;
  private Element next;

  public Element(Object data, Element next){
      this.data=data;
      this.next=next;
  }

  public Object getData(){
      return this.data;
  }

  public Element getNext(){
      return this.next;
  }

  public Object getNextObject(){
    return this.next.getData();
  }
  public void setNext(Element next){
      this.next=next;
  }

  public void inserirAntes(Object item, ListaEncadeada l){
      Element temporario = new Element(item, this);
      if(this== l.getHead())
          l.setHead(temporario);//modificado com metodo novo
      else{
          Element anterior = l.getHead();
          while(anterior!=null && anterior.getNext()!=this)
              anterior=anterior.getNext();
          anterior.setNext(temporario);
      }
  }

  public void inserirDepois(Object item,ListaEncadeada l){
      next = new Element(item, next);
      if(l.getTail() == this)
         l.setTail(next);//modificado com metodo novo
  }
}//fim classe Element
