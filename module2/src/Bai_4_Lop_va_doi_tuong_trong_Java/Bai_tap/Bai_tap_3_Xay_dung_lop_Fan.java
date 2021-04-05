package Bai_4_Lop_va_doi_tuong_trong_Java.Bai_tap;

public class Bai_tap_3_Xay_dung_lop_Fan {

    public static void main(String[] args) {
        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;
        Fan fan1 = new Fan();
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        Fan fan2 = new Fan();
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }

    public static class Fan{
        public final int SLOW = 1;
        public final int MEDIUM = 2;
        public final int FAST = 3;
        private int speed = SLOW;
        private boolean on = false;
        private double radius = 5;
        private String color = "blue";

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setOn(boolean on) {
            this.on = on;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isOn() {
            return on;
        }

        public double getRadius() {
            return radius;
        }

        public String getColor() {
            return color;
        }
        public Fan(){

        }
        public String toString(){
            if (isOn()){
                return "fan is on, tốc độ là " + getSpeed() + " ,màu quạt là " + getColor() + " ,bán kính cánh quạt là " + getRadius();
            } else {
                return "fan is off, màu quạt là " + getColor() ;
            }
        }
    }

}
