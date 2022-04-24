package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:冒泡
 * date: 2022/3/8 10:41
 *
 * @author 童一
 */
public class BubblingSort {

    @Test
    public void test1() {
        int[] m = {5,4,38,1};
        int[] result = bSort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] bSort( int[] nums) {
        int len = nums.length;
        for(int i = len; i > 0; i--){
            for(int j = 0; j < i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }
}
