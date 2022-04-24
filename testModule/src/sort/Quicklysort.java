package sortAlgorithm;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:快速排序
 * date: 2022/2/28 16:28
 *
 * @author 童一
 */
public class Quicklysort {

    @Test
    public void test1() {
        int[] m = {5,8,6,2,1,4,9,3,7};
        int[] result = quicksort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] quicksort( int[] nums) {
        //递归需要传递数组和左右指针
        qsort(nums,0,nums.length-1);
        return nums;
    }

    void qsort(int[] nums,int left,int right){
        if(left<right){
            int i = left;
            int j = right;
            //保存轴点，此时左边nums[left]已过时，可以被覆盖
            int temp = nums[left];
            //i>j时说明已经满足左边小于轴点右边大于轴点
            while(i<j){
                //右边需要全部大于轴点
                while(i<j&&temp<nums[j]) j--;
                //如果不大于轴点则换到左边替换上一个过时数据
                //替换之后右边的nums[j]已过时，可以被替换
                nums[i] = nums[j];
                //左边需要全部小于轴点，“ = ”放在一边即可
                while(i<j&&nums[i]<=temp) i++;
                //如果不小于则替换到右边的过时
                //此时nums[i]已过时可以被替换
                nums[j] = nums[i];
            }
            //最后将轴点替换回来
            nums[i] = temp;
            //将轴点左右两边递归排序
            qsort(nums,left,i-1);
            qsort(nums,i+1,right);
        }
    }
}
