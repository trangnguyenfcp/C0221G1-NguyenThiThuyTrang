package bai_7_abstract_class_interface.bai_tap;
import Bai_6_Ke_thua.thuc_hanh.thuc_hanh_1.*;
import Bai_6_Ke_thua.thuc_hanh.thuc_hanh_1.Circle;

import java.lang.reflect.Array;
import java.util.*;
public class ResizeableTest {
    public static void main(String[] args) {

      Circle circle = new Circle(3,"red", true);
      Rectangle rectangle = new Rectangle(4, 3);
      Square square = new Square(4);
      Shape[] list = {circle,rectangle,square};
       for (Shape shape: list){
           System.out.println(shape.toString());
       }
      for (Shape shape: list){
          if (shape instanceof Circle){
              ((Circle) shape).resize(Math.random());
          }
          if (shape instanceof Rectangle){
              ((Rectangle) shape).resize(Math.random());
          }else {
              System.out.println(false);
          }
      }
        for (Shape shape: list){
            System.out.println(shape.toString());
        }
    }
}
