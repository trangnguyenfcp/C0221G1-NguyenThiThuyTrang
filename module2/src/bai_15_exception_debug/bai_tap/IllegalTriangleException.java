package bai_15_exception_debug.bai_tap;

public class IllegalTriangleException extends RuntimeException{
   public IllegalTriangleException(String s){
       System.out.println(s);
   }
}
