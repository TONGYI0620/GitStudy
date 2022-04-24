package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。归并排序变种
 * date: 2022/4/11 20:10
 *
 * @author 童一
 */
public class InversePairs {
    @Test
    public void test1() {
        int[] m = {1,2,3,4,5,6,7,0};
        int result = inversePairs(m);
        System.out.println(result);
    }

    public int inversePairs(int [] array) {
        int len = array.length;
        return recursion(array, 0, len - 1);
    }

    public int recursion (int[] array, int left, int right) {
        int c = 0;
        int c1 = 0;
        int c2 = 0;
        while (left < right) {
            int mid = (left + right)/2;
            c1 = recursion(array, left, mid);
            c2 = recursion(array, mid + 1, right);
            c = merge(array, left, mid, right);
            return c + c1 + c2;
        }
        return c + c1 + c2;
    }

    public int merge (int[] array, int left, int mid, int right) {
        int count = 0;
        int[] temp = new int[right - left + 1];
        int index = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (array[l] < array[r]) {
                temp[index] = array[l];
                index++;
                l++;
            } else {
                temp[index] = array[r];
                index++;
                r++;
                count += mid - l + 1;
            }
        }

        while (l <= mid) {
            temp[index] = array[l];
            index++;
            l++;
        }

        while (r <= right) {
            temp[index] = array[r];
            index++;
            r++;
        }


        for (int i = 0, j = left; i < temp.length; i++, j++){
            array[j] = temp[i];
        }

        return count;
    }
}
