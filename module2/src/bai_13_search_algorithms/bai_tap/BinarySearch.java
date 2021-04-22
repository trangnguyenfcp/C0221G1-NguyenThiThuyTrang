package bai_13_search_algorithms.bai_tap;

public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int binarySearch(int[] array, int left, int right ,int value){
        if (left<=right){
        int middle = (right  + left)/2;
        if (array[middle] == value){
            return middle;
        }
        if (array[middle] < value){
            return binarySearch(array, middle + 1,  right ,value);
        }else {
            return binarySearch(array, left,  middle-1 ,value);
        }}
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(binarySearch(list, 0, 12, 79));

    }
}
