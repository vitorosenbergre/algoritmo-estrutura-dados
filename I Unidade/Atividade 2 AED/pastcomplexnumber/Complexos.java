package pastcomplexnumber;
// Classe responsavel por fazer a soma e a subtração de numeros complexos, ela foi bem rustica,
// pedi ao usuario que passasse os valores reais e inteiros de cada numero complexo.

public class Complexos {

    private double valorReal;
    private double valorImg;

    public Complexos (double valorReal,double valorImg){
        this.valorReal = valorReal;
        this.valorImg = valorImg;       
    }
    public Complexos (){
        this.valorReal = 0;
        this.valorImg = 0;
    }

    public double getValorReal() {
        return valorReal;
    }

    public void setValorReal(double valorReal) {
        this.valorReal = valorReal;
    }

    public double getValorImg() {
        return valorImg;
    }

    public void setValorImg(double valorImg) {
        this.valorImg = valorImg;
    }
    // retorna um objeto, sendo esse objeto a soma de dois numeros complexos
    public static Complexos somaComplexosObject (Complexos c1, Complexos c2){
        return new Complexos(c1.valorReal+c2.valorReal,c1.valorImg+c2.valorImg);
    }
    
    // retorna um objeto, sendo esse objeto a subtração de dois numeros complexos
    public static Complexos subtracaoComplexosObject (Complexos c1, Complexos c2){
        return new Complexos(c1.valorReal-c2.valorReal,c1.valorImg-c2.valorImg);
    }

    public String toString (){ //fazer a impressão textual do objeto, facilitou o codigo.
        if(getValorImg()>=0){
            return " " + getValorReal() + " + " + getValorImg() + "i" + " ";
        }else {
            return " " + getValorReal() + "" + getValorImg() + "i" + " ";
        }       
    }  
}