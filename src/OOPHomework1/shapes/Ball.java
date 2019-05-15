package OOPHomework1.shapes;

public class Ball {
    private double radius;
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double computeArea(){
        double S = 4*Math.PI*Math.pow(radius,2);
        return S;
    }
    public double computeVolume(){
        double V = (4*Math.PI*Math.pow(radius,3))/3;
        return V;
    }
    public void display(){
        System.out.println("Ball<R="+radius+", Color="+color+">");
        System.out.println("\t表面积S="+computeArea());
        System.out.println("\t体积V="+computeVolume());
        System.out.println("***********************************");
    }
}
