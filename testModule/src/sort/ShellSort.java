package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:希尔排序
 * date: 2022/3/2 18:32
 *
 * @author 童一
 */
public class ShellSort {
    @Test
    public void test1() {
        int[] m = {5,8,6,2,1,4,9,3,7};
//        int[] m = {5,4,38,1};
        int[] result = ss(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] ss( int[] nums) {
        int len = nums.length;
        for(int gap = len/2; gap > 0; gap /= 2){
            for(int i = gap; i < len; i++){
                for(int j = i - gap; j >= 0; j -= gap){
                    if(nums[j] > nums[j + gap]){
                        int temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
                }
            }
        }
        return nums;
    }
}
