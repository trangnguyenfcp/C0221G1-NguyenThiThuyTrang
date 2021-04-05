package Bai_5_Access_modifier_static_method_static_property.Bai_tap;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    Circle(){

    }
    Circle(double radius){

    }

    protected double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }

}
class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
    }


}