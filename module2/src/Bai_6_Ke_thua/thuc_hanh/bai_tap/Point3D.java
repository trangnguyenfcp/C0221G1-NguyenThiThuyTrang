package Bai_6_Ke_thua.thuc_hanh.bai_tap;

public class Point3D extends Point2D {
    float z = 0.0f;
    Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public float[] getXYZ(){
        return new float[]{x,y,z};
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + z +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point2D point = new Point3D(3, 4, 5);
        System.out.println(point.toString());
    }
}
