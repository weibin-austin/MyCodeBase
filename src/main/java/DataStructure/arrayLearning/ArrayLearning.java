package DataStructure.arrayLearning;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class ArrayLearning {
    public static void main(String[] args) {

//        初始化数组
        int[] nums = new int[10];
        nums[0] = 1;
        //System.out.println(Arrays.toString(nums));

        int[] arr = new int[]{36, 11, 23, 5, 7, 15, 27};
        //System.out.println(Arrays.toString(arr));

        String[] strings = new String[]{"water", "color", "student", "teacher", "fire", "wood"};
        //System.out.println(Arrays.toString(strings));

//        java.util.Arrays; 包内的方法

//        用于：primitive data type Array & Object[], 没有比较器. 基本数据类型是用 x.compareTo(y) 来排序
        Arrays.sort(arr);
        //System.out.println("Ascending order: " + Arrays.toString(arr));


//        用于: wrapper type Array & reference type Array -> Arrays.sort(T[], Comparator<? super T> c)
//        !!! Only Integer[] Character[] ... !!!!
        Integer[] arr1 = new Integer[]{36, 11, 23, 5, 7, 15, 27};
        Arrays.sort(arr1, Collections.reverseOrder());
        //System.out.println("Descending order: " + Arrays.toString(arr1));



/* 二维数组 */

        int[][] array = new int[10][3];
        for(int i = 0; i < 10; i++) {
            array[i][0] = i;
            array[i][1] = i * 10;
            array[i][2] = i * 100;
            //System.out.println(Arrays.toString(array[i]));
        }

        //System.out.println(Arrays.toString(array));

        int[][] intervals = new int[][]{
                {1, 30},
                {11, 19},
                {15, 29}
        };

//        !!! int[0] and int[1] both reference data type array!!! 可以用 Arrays.sort(T[], Comparator<? super T> c)
        Arrays.sort(intervals, (a, b) ->  a[0] - b[0]);
        Arrays.sort(intervals, (a, b) ->  Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(intervals, (a, b) -> Objects.equals(a[0], b[0]) ? a[1] - b[1] : a[0] - b[0]);

        /*     比较器的写法：
                1. 直接比较              (a, b) ->  a[0] - b[0]
                2. Integer的静态方法     (a, b) ->  Integer.compare(a[0], b[0])
       IDE推荐： 3. Comparator的静态方法  Comparator.comparingInt(o -> o[1])
                4. 自定义比较器方法：     (a, b) -> Objects.equals(a[0], b[0]) ? a[1] - b[1] : a[0] - b[0]


       */

        for(int[] interval: intervals) {
            System.out.println(Arrays.toString(interval));
        }

        // 对于List的地址输出可以直接输出List中的每个元素

        // 对于array的地址输输出的是array在heap中的地址
        // Arrays.toString(a), Arrays类的静态方法 Arrays.toString(a) 可以输出array中的每一个元素
        int[] a = new int[]{1, 2, 3};
        System.out.println(a);                  // [I@5caf905d
        System.out.println(a.toString());       // [I@5caf905d
        System.out.println(Arrays.toString(a)); // [1, 2, 3]: Returns a string representation of the contents of the specified array.


         int[] array0 = new int[]{1,2,3,4,5,6,7,8,9};
         int[] dummy = array0.clone();
        System.out.println(dummy.toString()); // [I@3a71f4dd
        System.out.println(array0.toString()); // [I@7adf9f5f
    }

    @Test
    public void basic_test() {
        int[] arr = new int[2];
        arr[0]++;
//        boolean res = --arr[0] == 0;
        boolean res = arr[0]-- == 0;
        System.out.println(res);
        /*
            if, for example, i = 5:

            --i decrements i by 1 then gives you the value of i (4).

            i-- gives you the value of i (5) then decrements it by 1.

            Both will give you the same result in a for loop.
         */
    }

    @Test
    public void basic_test1() {
        int[][] maze = new int[][] {{0,0,1,0,0},
                                    {0,0,0,0,0},
                                    {0,0,0,1,0},
                                    {1,1,0,1,1},
                                    {0,0,0,0,0}};

        int n = maze.length,
            m = maze[0].length;

        int[][] dist = new int[n][m];
        for(int i = 0; i < n ; i++) {
            Arrays.fill(dist[i], 1); // dist[i] 代表一个array，将dist[i]这个array中的全部elements fill 为 1
        }

        // Arrays

        for(int[] d: dist) {
            System.out.println(Arrays.toString(d));
        }


    }

    @Test
    public void test_row_column() {
        int[][] matrix = new int[2][5];
        int count = 0;
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = count++;

        for(int[] row: matrix)
            System.out.println(Arrays.toString(row));
        /*      row = 2, column = 5
                [[0, 1, 2, 3, 4],
                 [5, 6, 7, 8, 9]]

         */
    }
}
