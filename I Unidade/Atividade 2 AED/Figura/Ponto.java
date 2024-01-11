package Figura;
// O objetivo da classe é criar o ponto no plano, usando o metodo toString para impressão do mesmo.
public class Ponto { //
    protected double x;
    protected double y;

    public Ponto (double x, double y){
        this.x = x;
        this.y = y;
    }

    public Ponto (){        // construtor padrão
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString(){ // Serve para representar textualmente o objeto ponto.
        return "Ponto: "+"[" + this.x + "," + this.y + "]";
    }
}
