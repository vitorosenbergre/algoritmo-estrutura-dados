package Figura;
// Classe responsavel por criar um Cilindro, calcula a area e o volume do Cilindro, tambem tem o resepresentante
// toString

public class Cilindro extends Circulo {// class filha da class Circulo, herdando seus atributos e metodos.
    protected double altura;

    public Cilindro(double x, double y, double raios, double altura){
        super(x,y,raios);
        this.altura = altura;
    }

    public Cilindro(){
        this.altura= 0;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    // Calcula a área do Cilindro
    public double areaCilindro(){ // o metodo utiliza um metodo da classe pai dela, o Circulo.
        return (2*super.areaCirculo()) + (2*(3.14*this.raio * this.altura));
    }
    // Calcula o volume do Cilindro
    public double volumeCilindro(){
        return (3.14*this.raio*this.raio*this.altura);
    }
    // Representa o objeto textualmente
    @Override
    public String toString(){
        return "Altura: "+ this.altura +"\n"+ super.toString();
    }
}
