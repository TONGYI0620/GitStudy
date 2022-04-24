package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:选择排序
 * date: 2022/2/28 16:28
 *
 * @author 童一
 */
public class Selectionsort {

    @Test
    public void test1() {
        int[] m = {5,4,38,1};
        int[] result = sort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] sort( int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                int temp = nums[i];
                //如果大于后面的值替换
                if(temp > nums[j]){
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return nums;
    }

}
