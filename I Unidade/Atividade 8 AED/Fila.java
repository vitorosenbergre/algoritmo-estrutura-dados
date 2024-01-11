
public class Fila{
  
  ListaEncadeada list = new ListaEncadeada();

  private int cont=0;

  public void enfileirar(Object paciente){
    list.inserirFim(paciente);
    cont++;
  }

  public void desenfileirarInicio() throws ObjetoNaoEncontradoException, ListaVaziaException{
    list.extrair(getPrimeiro());
  }

  public void desenfileirarFim() throws ObjetoNaoEncontradoException, ListaVaziaException{
    list.extrair(getUltimo());
  }

  public Object getUltimo() throws ListaVaziaException{
    return list.getUltimo();
  } 

  public Object getPrimeiro() throws ListaVaziaException{
    return list.getPrimeiro();
  }

  public void fazVazia(){
    list.fazVazia();
  }

  public boolean estaVazia(){
    return list.estaVazia();
  }
  
  public ListaEncadeada retornarLista(){
    return list;
  }
  
  public void inserirInicio(Object paciente){
    list.inserirInicio(paciente);
  }

  public Object getPosicao(int posicao) throws ListaVaziaException{
    return list.getPosicao(posicao);
  }

  public int getCont(){
    return cont;
  }

}
