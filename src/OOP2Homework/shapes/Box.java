package OOP2Homework.shapes;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Box() {

    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double computeArea(){
        double S = 2*(length*width+width*height+length*height);
        return S;
    }
    public double computeVolume(){
        double V = length*width*height;
        return V;
    }
    public void display(){
        System.out.println("Box<长="+length+", 宽="+width+", 高="+height+">:");
        System.out.println("\t表面积S="+computeArea());
        System.out.println("\t体积V="+computeVolume());
        System.out.println("***********************************");
    }
}
