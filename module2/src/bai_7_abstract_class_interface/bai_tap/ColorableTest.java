package bai_7_abstract_class_interface.bai_tap;
import Bai_6_Ke_thua.thuc_hanh.thuc_hanh_1.*;
public class ColorableTest {
    public static void main(String[] args) {

    Square square1 = new Square(5, "black",true);
    Square square2 = new Square(6, "blue",false);
    Square square3 = new Square(7, "red",true);
    Square square4 = new Square(8, "black",false);
    Square[] listSquare = {square1, square2, square3, square4};
    for (Square square : listSquare){
        if (!square.isFilled()){
            square.howToColor();
        }
    }

}}
