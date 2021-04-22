package bai_11_dsa_stack_queue.bai_tap;
import java.util.*;
public class Demerging {
    public static void main(String[] args) {
        String[][] danhSach = new String[][]{
                {"nam","1/1"},
                {"nu","2/2"},
                {"nam","3/3"},
                {"nu","4/4"},
                {"nam","5/5"},
        };
    Queue NU = new LinkedList();
    Queue NAM = new LinkedList();
    for (int i = 0; i < danhSach.length; i++){
        for (int j = 0; j < 2; j++){
            if (danhSach[i][1] == "nu"){
                NU.add(danhSach[i][j]);
            }else {
                NAM.add(danhSach[i][j]);
            }
    }}

        Queue employee = new LinkedList();
    for (int i = 0; i < NU.size(); i++){
        employee.add(NU.remove());
    }
        for (int i = 0; i < NAM.size(); i++){
            employee.add(NAM.remove());
        }
        for (int i =0; i < employee.size(); i++) {
            for (int j = 0; j < 2; j++){
                System.out.println(employee.remove());
            }
        }
    }
}
