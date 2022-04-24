package sortAlgorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Description:桶排序
 * date: 2022/3/8 10:42
 *
 * @author 童一
 */
public class BucketSort {

    @Test
    public void test1() {
        int[] m = {5,4,38,1};
        int[] result = bSort(m);
        System.out.println(Arrays.toString(result));
    }

    public int[] bSort( int[] arr) {
        int length = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }

        int count = (max - min) / length + 1;

        int temp = count;

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        //构造桶
        while (count > 0) {
            count--;
            ArrayList<Integer> kid = new ArrayList<>();
            list.add(kid);
        }

        //将数装进对应桶
        for (int i = 0; i < length; i++) list.get((arr[i] - min) / length).add(arr[i]);


        int index = 0;
        while (count != temp) {
            //对桶里面的数排序
            Collections.sort(list.get(count));
            //将排序好的数取出来
            for (int i = 0; i < list.get(count).size(); i++) {
                arr[index++] = list.get(count).get(i);
            }
            count++;
        }
        return arr;
    }
}
