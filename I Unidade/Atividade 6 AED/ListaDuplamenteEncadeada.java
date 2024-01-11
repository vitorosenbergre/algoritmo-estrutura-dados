/**
 * ListaDuplamenteEncadeada
 */
public class ListaDuplamenteEncadeada {

  private Element head;
  private Element tail;

  public final class Element {
    Object data;
    Element next, prev;

    Element(Object data, Element prev, Element next) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    } // fim do construtor Element

    public void setNext(Element next) {
      this.next = next;
    } // fim do metodo setNext

    public void InsertNext(Element item) {
      Element temp = new Element(item, this, next);
      next = temp;
      if (this == tail) {
        tail = next;
      } else { // fim do if
        (temp.next).prev = temp;
      } // fim do else
    } // fim do metodo InsertNext

    public void InsertPrevious(Element item) {
      Element temp = new Element(item, this.prev, this);
      prev = temp;
      if (this == head) {
        head = prev;
      } else { // fim do if
        (temp.prev).next = temp;
      } // fim do else
    } // fim do metodo InsertPrevious
  } // fim da class interna Element

  public Element getHead() {
    return head;
  } // fim do metodo getHead

  public Element getTail() {
    return tail;
  }// fim do metodo getTail

  public Object getFirst() throws ListaVaziaException {
    if (head == null) {
      throw new ListaVaziaException();
    } // fim if
    return head.data;
  } // fim metodo getFirst

  public Object getLast() throws ListaVaziaException {
    if (tail == null) {
      throw new ListaVaziaException();
    } // fim if
    return tail.data;
  } // fim metodo getLast

  public boolean isEmpty() {
    return (head == null && tail == null);
  } // fim do metodo isEmpty

  public void purge() {
    head = null;
    tail = null;
  } // fim do metodo purge

  public void InsertHead(Object item) {
    Element temp = new Element(item, null, head);
    if (head == null) {
      tail = temp;
    } else {
      head.prev = temp;
    }
    head = temp;
  }

  public void InsertTail(Object item) {
    Element temp = new Element(item, tail, null);
    if (tail == null) {
      head = temp;
    } else { // fim if
      tail.next = temp;
    } // fim else
    tail = temp;
  } // fim void InserTail

  public void toAdd(ListaDuplamenteEncadeada lista) {
    if (lista != this) {
      this.purge();
      for (Element pointer = lista.head; pointer != null; pointer = pointer.next) {
        this.InsertTail(pointer.data);
      } // fim do for
    } // fim do if
  } // fim do metodo toAdd

  public void delete(Object item) throws ObjetoNaoEncontradoException {

    if (tail == head && head.data.equals(item)) {
      purge();
      return;
    }

    Element ptr = head;

    while (ptr != null && ptr.data != item) {
      ptr = ptr.next;
    }

    if (ptr == null) {
      throw new ObjetoNaoEncontradoException(item);
    }

    if (ptr == head) {
      head = ptr.next;
      head.prev = null;
    } else if (ptr == tail) {
      tail = ptr.prev;
      tail.next = null;
    } else {
      (ptr.prev).next = ptr.next;
      (ptr.next).prev = ptr.prev;
    }
  }
}