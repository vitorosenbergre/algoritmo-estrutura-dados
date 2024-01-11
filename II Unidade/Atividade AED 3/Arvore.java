
abstract class Arvore implements Comparable<Arvore> {
    public final int frequencia; 
    

    public Arvore(int freq) { 
    	frequencia = freq; 
    }

    public int compareTo(Arvore no) {
        return frequencia - no.frequencia;
    }
}