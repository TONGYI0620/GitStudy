package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:归并排序
 * date: 2022/3/3 15:09
 *
 * @author 童一
 */
public class MergeSort {
    @Test
    public void test1() {
        int[] m = {5,4,38,1};
        int[] result = merSort(m);
        System.out.println(Arrays.toString(result));
    }


    public int[] merSort( int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] temp = new int[len];
        //归并排序需要递归调用
        mSort(nums, left, right, temp);
        return nums;
    }

    public void mSort(int[] nums, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right)/2;
            //将数组分成两个子序列，将子序列排序
            mSort(nums, left, mid, temp);
            mSort(nums, mid + 1, right, temp);
            //将两个子序列合并
            merge(nums, left, mid, right, temp);
        }
    }

    public void merge(int[] nums, int left, int mid, int right, int[] temp){
        int l = left;
        int r = mid + 1;
        int t = left;
        //分别从两个子序列的最左边开始，取最小值保存到temp
        //取完值之后左（右指针）后移
        while(l <= mid && r <= right){
            if(nums[l] < nums[r]){
                temp[t] = nums[l];
                t++;
                l++;
            } else {
                temp[t] = nums[r];
                t++;
                r++;
            }
        }

        //保证左子序列取完值
        while(l <= mid){
            temp[t] = nums[l];
            t++;
            l++;
        }

        //保证右子序列取完值
        while(r <= right){
            temp[t] = nums[r];
            t++;
            r++;
        }

        //将temp保证的值赋给nums
        int tl = left;
        while(tl <= right){
            nums[tl] = temp[tl];
            tl++;
        }
    }
}
