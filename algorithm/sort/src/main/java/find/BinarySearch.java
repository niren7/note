package find;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(binarySearch(array,4));
        int[] repeatArray = {1,2,3,3,4,5,5,5,6,7};
        System.out.println(binarySearch(array,5));
    }

    //没有重复元素的情况
    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        //正确的终结条件是：low > high 也就是搜索空间为空。准确定好条件能避免想当然的错误
        //不要使用low == high来判断,可能会导致死循环,例如当在数组{1,2}中找0的时候,high会变成-1
        while (low <= high) {
            //用加法可能会溢出
            int mid = low + (high - low) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            }
            if (array[mid] > target) {
                high = mid - 1;
            }
            if (array[mid] == target) {
                return mid;
            }
        }
        //一般二分查找的默认约定是找不到就返回应该插入的位置下标
        //满足终结条件以后，返回值完全不需要纠结，直接返回低位 low。
            //因为回过头去放慢镜头，二分查找的过程就是一个 维护 low 的过程：low从0起始。
            //只在中位数遇到确定小于目标数时才前进，并且永不后退。low一直在朝着第一个目标数的位置在逼近。直到最终到达。
        //为什么不返回高位 high
            //因为如果没找到，返回的应该是这个数字应该插入位置的下标。
            //这样在右边越界是可以的，但左边越界是不可以的，因为最小的数应该插入在nums[0]。所以只有low满足。
        return low;
    }

    //有重复元素的情况
    //二分就变成寻找元素第一次出现的位置。
    public static int binarySearch1(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            //用加法可能会溢出
            int mid = low + (high - low) / 2;
            if (array[mid] < target) {
                low = mid + 1;
            }
            if (array[mid] >= target) {
                high = mid - 1;
            }
        }
        return low;
    }
}
