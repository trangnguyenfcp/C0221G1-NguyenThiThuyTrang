package Bai_6_Ke_thua.thuc_hanh.bai_tap;

public class Cylinder extends Circle {
    private double height;
    private double volume;
    public Cylinder(double radius, double height, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getArea(){
        return super.getArea();
    }
    public double getVolume(){
        volume = getArea()*height;
        return volume;
    }

    @Override
    public String toString() {
        return
                "height=" + height +
                ", volume=" + volume + " "+
                super.toString()
                ;
    }

    public static void main(String[] args) {
        Circle cylinder = new Cylinder(5.0, 10.0, "blue");
        cylinder.getArea();
        ((Cylinder) cylinder).getVolume();
        System.out.println(cylinder.toString());

    }
}
