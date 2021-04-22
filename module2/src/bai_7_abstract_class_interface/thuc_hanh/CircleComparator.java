package bai_7_abstract_class_interface.thuc_hanh;

import Bai_6_Ke_thua.thuc_hanh.thuc_hanh_1.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }

}
