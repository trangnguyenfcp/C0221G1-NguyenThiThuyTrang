package Bai_6_Ke_thua.thuc_hanh.bai_tap;

public class Circle {
    private double radius;
    private String color;
    private double area;
    public String getColor() {
        return color;
    }
    Circle(){}
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius(){
        return radius;
    }
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    public double getArea(){
        area = Math.PI*radius*radius;
        return area;
    }
    @Override
    public String toString() {
        return "radius=" + radius +
                ", color='" + color + '\'' +
                ", area=" + area
                ;
    }
}
