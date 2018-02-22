package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5,3,9,6,2,32,15,2,5,47,11};
        quickSort(array);
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
    
    private static void quickSort(int[] array) {
        qSort(array,0,array.length - 1);
    }

    private static void qSort(int[] array, int low, int high) {
        if(low < high) {
            int pivot = partition(array,low,high);
            //去掉枢轴
            qSort(array,low,pivot - 1);
            qSort(array,pivot + 1,high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) high--;
            array[low] = array[high];
            while (low < high && array[low] <= pivot) low++;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}
