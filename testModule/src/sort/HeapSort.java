package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:堆排序
 * date: 2022/3/4 16:21
 *
 * @author 童一
 */
public class HeapSort {

    @Test
    public void test1() {
        int[] m = {5,4,2,6,7,9,3,8,1};
        int[] result = hSort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] hSort( int[] nums) {
        int length = nums.length;
        build(nums,length);
        for (int i = nums.length-1; i > 0; i--) {

            swap(nums,0,--length);

            heapify(nums,length,0);
        }
        return nums;
    }
    public void build(int[] nums, int length) {
        for (int i = length/2; i >=0; i--) {
            heapify(nums,length,i);
        }
    }

    public void heapify(int[] nums, int length, int i) {
        int left = 2 * i + 1;
        int right = 2 * i+2;
        int largest = i;
        if (left < length && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < length && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, largest, i);
            heapify(nums, length, largest);
        }
    }

    public void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
