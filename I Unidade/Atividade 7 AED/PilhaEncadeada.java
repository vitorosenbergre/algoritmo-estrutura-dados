//package pilha;

import java.lang.Object;
//import lista.ListaEncadeada;
//import lista.ObjetoNaoEncontradoException;

public class PilhaEncadeada implements Pilha {
//utiliza uma lista para guardar a pilha
private ListaEncadeada lista = new ListaEncadeada();

private int count; // numero d elementos na pilha

@Override
public void fazVazia(){
    lista.estaVazia(); // faz a lista vazia
}
@Override
public boolean estaVazia(){
    return count == 0; // verifica se o numero de elementos é zero
}
@Override
public Object getTop() {
    return lista.getHead(); // pega o elemento cabeca da lista
}
@Override
public void push(Object obj){//?
    
    lista.inserirInicio(obj); // insere no inicio da lista
}

@Override
public Object pop(){
	//remove a cabeca da lista
  if(!lista.estaVazia()){
	Object dado = lista.getHead().getData();	
    try{    
      lista.extrair(dado);
    }catch(ObjetoNaoEncontradoException e){

    }
  return dado;
  }
  return null;
  }
}
