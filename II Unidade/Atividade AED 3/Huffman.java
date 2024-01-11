import java.util.PriorityQueue;

public class Huffman {

	public static void main(String[] args) {

    String string = "hipopotamo"; 
        
    int[] charFreqs = new int[256];

    for (char c : string.toCharArray()){
      charFreqs[c]++;
    } 

    Arvore raiz = construirArvore(charFreqs);
        
    System.out.println("TABELA DE CÓDIGOS");
    System.out.println("SÍMBOLO\tQUANTIDADE\tHUFFMAN CÓDIGO");
    imprimirBits(raiz, new StringBuffer());
    
    String textoCompactado = compactar(raiz,string);

    System.out.println("\nTEXTO COMPACTADO");
    System.out.println(textoCompactado); 
        
    System.out.println("\n\nTEXTO DECODIFICADO");
    System.out.println(decodificar(raiz,textoCompactado));

  }

	
    public static Arvore construirArvore(int[] charFreqs) {
 
      PriorityQueue<Arvore> folhas = new PriorityQueue<Arvore>();
      
        for (int i = 0; i < charFreqs.length; i++){
          if (charFreqs[i] > 0){
              folhas.offer(new Folha(charFreqs[i], (char)i)); 
          } 
        } 

        while (folhas.size() > 1) {

          Arvore a = folhas.poll();  
          Arvore b = folhas.poll(); 
          
          folhas.offer(new Elemento(a, b)); 
        }

      return folhas.poll();
    }
 

    public static String compactar(Arvore raiz, String string){
      
    	String textoCompactado ="";
        for (char c : string.toCharArray()){
        	textoCompactado+=(transformarBits(raiz, new StringBuffer(),c));
        }

    	return textoCompactado; 
    }
    

    public static String decodificar(Arvore raiz, String textoCompactado) {
      
    	String textoDescompactado="";         
    	Elemento no = (Elemento)raiz;    
    	for (char bit : textoCompactado.toCharArray()){
    		if (bit == '0'){ 
    		  if (no.esquerda instanceof Folha) { 
    		  	textoDescompactado += ((Folha)no.esquerda).valor; 
	          no = (Elemento)raiz; 
	    	  }else{  
	    		  no = (Elemento) no.esquerda; 
	    	  } 
    		}else if (bit == '1'){ 
    		  if (no.direita instanceof Folha) {
    		  	textoDescompactado += ((Folha)no.direita).valor; 
	          no = (Elemento)raiz; 
	    		}else{
	    		  no = (Elemento) no.direita; 
	    		}
    		}
    	} 
    	return textoDescompactado; 
    }    
    

    public static void imprimirBits(Arvore atual, StringBuffer prefix) {
      
      if (atual instanceof Folha) {
        Folha folha = (Folha)atual;
            
        System.out.println(folha.valor + "\t" + folha.frequencia + "\t\t" + prefix);
        
      }else if (atual instanceof Elemento) {
        
        Elemento no = (Elemento)atual;
        
        prefix.append('0');
        imprimirBits(no.esquerda, prefix);
        prefix.deleteCharAt(prefix.length()-1);
       
        prefix.append('1');                          
        imprimirBits(no.direita, prefix);                
        prefix.deleteCharAt(prefix.length()-1);
      }
    }
    

    public static String transformarBits(Arvore atual, StringBuffer prefix, char w) {
        
        if (atual instanceof Folha) {
            Folha folha = (Folha)atual;
            
            if (folha.valor == w ){
            	return prefix.toString(); 
            }
            
        } else if (atual instanceof Elemento) {
            
          Elemento no = (Elemento)atual;
 
            prefix.append('0');
            String esquerda = transformarBits(no.esquerda, prefix, w);
            prefix.deleteCharAt(prefix.length()-1);
 
            prefix.append('1');
            String direita = transformarBits(no.direita, prefix,w);
            prefix.deleteCharAt(prefix.length()-1);
            
            if (esquerda==null){
              return direita;
            }else{
              return esquerda;
            } 
        }
		return null;
    }

}