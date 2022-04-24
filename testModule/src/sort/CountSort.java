package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:计数排序
 * date: 2022/3/4 14:35
 *
 * @author 童一
 */
public class CountSort {

    @Test
    public void test1() {
        int[] m = {5,4,38,1};
        int[] result = cSort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] cSort( int[] nums){
        int len = nums.length;
        //new int 默认装填0
        int[] temp = new int[1000];

        for(int i = 0; i < len; i++){
            temp[nums[i]]++;
        }

        //nums数组下标
        int k = 0;
        for(int j = 0; j < 100; j++){
            //将temp保存的值按个数装填回nums
            while(0 != temp[j]){
                nums[k] = j;
                k++;
                temp[j]--;
            }
        }

        return nums;
    }
}
