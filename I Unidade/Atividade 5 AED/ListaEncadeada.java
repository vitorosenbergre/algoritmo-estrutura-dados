//import jdk.javadoc.internal.doclets.formats.html.markup.Head;

public class ListaEncadeada {
  // private Element head;
  private Element tail;

  public final class Element { // final, não pode ser estendida, classes que herdam dela
    Object data; // é importante para que a classe não tenha seu comportamento modificado
    Element next; // termo chamado de IMUTABILIDADE

    Element(Object d, Element n) {
      data = d;
      next = n;
    }

    public Object getData() {
      return data;
    }

    public Element getNext() {
      return next;
    }

    public void inserirDepois(Object item) {
      next = new Element(item, next);
      if (tail == this) {
        tail = next;
      }
    }

    public void inserirAntes(Object item) {
      Element temp = new Element(item, this);
      if (this == tail.next) { // alterado de head para tail.next
        tail.next = temp; // alterado de head para tail.next
      } else {
        Element prevPtr = tail.next; // alterado de head para tail.next
        while (prevPtr != tail && prevPtr.next != this) {
          prevPtr = prevPtr.next;
        }
        prevPtr.next = temp;
      }
    }
  }

  public void purge() {
    tail = null;
  }

  public Element getTailNext() { // antigo getHead
    return tail.next; // mudou de getHead para getTailNext
  } // mudou de return head para return tail.next

  public Element getTail() {
    return tail;
  }

  public boolean isEmpty() {
    return (tail == null); // mudou de head para tail
  }

  public Object getPrimeiro() throws ListaVaziaException {
    if (tail.next == null) { // mudou de head para tail.next
      ListaVaziaException ex;
      ex = new ListaVaziaException();
      throw ex;
    } // throw new ListaVaziaException();
    return tail.next.data; // mudou de head.data para tail.next.data
  }

  public Object getUltimo() throws ListaVaziaException {
    if (tail == null) {
      ListaVaziaException ex;
      ex = new ListaVaziaException();
      throw ex;
    } // throw new ListaVaziaException();
    return tail.data;
  }

  public void inserirInicio(Object item) {
    if (tail == null) { // altera de head para tail.next
      Element temp = new Element(item, null); // altera de head para tail.next
      tail = temp;
      tail.next = temp;
    } else {
      Element temp = new Element(item, tail.next); // altera de head para tail.next
      tail.next = temp; // mudou de head para tail.next
    }
  }

  public void inserirFim(Object item) {
    Element temp = new Element(item, tail); // mudou de null pra tail.next

    if (tail.next == tail) { // mudou de head pra tail.next
      tail.next = temp;
      // mudou de head pra tail.next
    }
    tail = temp;
  }

  public void atribuir(ListaEncadeada l) {
    if (l != this) {
      this.purge();
      for (Element ptr = l.tail.next; ptr != tail; ptr = ptr.next) { // mudou de l.head para l.tail.next
        this.inserirFim(ptr.data); // mudou de null para tail
      }
    }
  }

  public void extrair(Object item) throws ObjetoNaoEncontradoException {
    Element ptr = tail.next; // mudou de head para tail.next
    Element prevPtr = null;

    while (ptr != tail && ptr.data != item) {
      prevPtr = ptr;
      ptr = ptr.next;
    }
    if (ptr == tail && ptr.next == tail) {
      purge();
      return;
    }
    if (ptr == tail.next) { // muda de head para tail
      tail.next = ptr.next; // muda de head para tail
    } else {
      prevPtr.next = ptr.next;
    }
    if (ptr == tail) {
      throw new ObjetoNaoEncontradoException(item);
    }
  }
}