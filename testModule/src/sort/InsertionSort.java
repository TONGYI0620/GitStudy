package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:插入排序
 * date: 2022/2/28 16:28
 *
 * @author 童一
 */
public class InsertionSort {

    @Test
    public void test1() {
        int[] m = {5,4,38,1};
        int[] result = sort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] sort( int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len - 1; i++){
            //临时值保存将要进行插入的值
            int temp = nums[i + 1];
            for(int j = i + 1; j > 0; j--){
                //从临时值的位置开始比较，如果小于前一个值则把前一个值后移
                if(nums[j] < nums[j-1]){
                    nums[j] = nums[j-1];
                    nums[j -1] = temp;
                }
            }
        }
        return nums;
    }

}
