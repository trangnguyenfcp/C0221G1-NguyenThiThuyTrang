package Bai_4_Lop_va_doi_tuong_trong_Java.Bai_tap;
import java.util.Scanner;
public class Bai_tap_2_Xay_dung_lop_StopWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] array = new long[100000];
        for (int i = 0; i < 100000; i++){
            array[i] = 1000*Math.round(Math.random());
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.Start();
        System.out.println("Thời gian bắt đầu là: " + stopWatch.getStartTime());
        for (int i = 0; i < 100000; i++){
            for (int j = i+1; j < 100000; j++){
                if (array[j] < array[i]){
                    long temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        stopWatch.Stop();
        System.out.println("Thời gian kết thúc là: " + stopWatch.getEndTime());
        System.out.println("Thời gian xử lí là: " + stopWatch.getElapsedTime());
    }
    public static class StopWatch {
        private long startTime;
        private long endTime;

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }
        public StopWatch(){

        }
        public void Start(){
            this.startTime = System.currentTimeMillis();
        }
        public void Stop(){
            this.endTime = System.currentTimeMillis();
        }
        public long getElapsedTime(){
            return this.endTime - this.startTime;
        }
    }
}
