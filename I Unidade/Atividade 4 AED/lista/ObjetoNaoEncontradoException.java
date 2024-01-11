
public class ObjetoNaoEncontradoException extends Exception {

  private static final long serialVersionUID = 1L;

  private Object data;

  public ObjetoNaoEncontradoException (Object d){
    super("Objeto não encontrado");
    this.data = d;
  }

  public Object getData(){
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
