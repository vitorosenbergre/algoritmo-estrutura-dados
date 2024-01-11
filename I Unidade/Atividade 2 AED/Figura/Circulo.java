package Figura;
// A classe é responsável por criar um círculo, possui o metodo get e set de raio, um metodo para descobrir a 
// área do circulo e o toString para representar o objeto.
// a classe é uma classe filha, tendo a classe pai como a classe ponto, herdando seus atributos e metodos.
public class Circulo extends Ponto{
    protected double raio;

    public Circulo (double x, double y, double raio){
        super(x,y);         // herdando os atributos da classe Ponto
        this.raio = raio;
    }
    
    public Circulo (){  // construtor padrão
        this.raio =0;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
    // responsável pela área do circulo
    public double areaCirculo(){    
        return (3.14 *this.raio *this.raio); // 3,14 = valor aproximado de pi
    }
    // representação do objeto
    @Override
    public String toString(){
        return (super.toString()+ "\nRaio = "+ this.raio);  // herdando tbm o toString da classe pai.
    }
}
