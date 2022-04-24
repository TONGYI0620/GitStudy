package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:基数排序
 * date: 2022/3/8 10:26
 *
 * @author 童一
 */
public class RadixSort {

    @Test
    public void test1() {
        int[] m = {1,11,11,11,11,111,1,111,1,1,111,1111,1111,1,11,111,1,11};
        int[] result = rSort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] rSort( int[] nums) {
        int max = nums[0];
        int maxLength = 0;
        for(int i = 1; i < nums.length; i++) {
            if(max < nums[i]) {
                max = nums[i];
            }
        }
        while(max > 0) {
            max /= 10;
            maxLength++;
        }

        //基数排序是非比较排序，从最低位开始按照大小装到对应的桶里面
        int[][] bucket = new int[10][nums.length];
        //记录每个桶里面装了几个数
        int[] bucketElementCounts = new int[10];

        int digitOfElement;
        int index;
        //从最低位开始向上加
        for(int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for(int j = 0; j < nums.length; j++) {
                //取的是当前待排数的应装桶的位置（第几个桶）
                digitOfElement = nums[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = nums[j];
                bucketElementCounts[digitOfElement]++;
            }
            index = 0;
            //将数字按照桶的顺序push出来
            for(int k = 0; k < bucketElementCounts.length; k++) {
                if(bucketElementCounts[k] != 0) {
                    for(int l = 0; l < bucketElementCounts[k]; l++) {
                        nums[index] = bucket[k][l];
                        index++;
                    }
                    bucketElementCounts[k] = 0;
                }
            }
        }
        return nums;
    }
}
