package Bai_6_Ke_thua.thuc_hanh.bai_tap;

import Bai_6_Ke_thua.thuc_hanh.thuc_hanh_1.Shape;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    Triangle(){}
    Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    public double getArea(){
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", area=" + getArea() +
                ", perimeter= " + getPerimeter() +
                super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        triangle.getArea();
        triangle.getPerimeter();
        System.out.println(triangle.toString());
    }
}
