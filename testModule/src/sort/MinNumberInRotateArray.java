package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:把一个数组最开始的若干个元素搬到数组的末尾,[1,2,3,4,5]变成[3,4,5,1,2]，或者[4,5,1,2,3]
 * 二分查找变种
 * date: 2022/4/12 19:22
 *
 * @author 童一
 */
public class MinNumberInRotateArray {

    @Test
    public void test1() {
        int[] m = {3,4,5,1,2};
        int result = minNumberInRotateArray(m);
        System.out.println(result);
    }

    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;

        while (left < right) {
            if (left == right - 1) return array[left] < array[right] ? array[left] : array[right];
            mid = (left + right)/2;
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }

        return array[left];
    }
}
