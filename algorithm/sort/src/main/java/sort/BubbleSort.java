package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5,3,9,6,2};
        bubble(array);
        for(int i: array) {
            System.out.print(i + ",");
        }
    }

    private static void bubble(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for(int j = 1; j < length - i; j++) {
                if(array[j] < array[j-1]) {
                    swap(array, j, j-1);
                }
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
