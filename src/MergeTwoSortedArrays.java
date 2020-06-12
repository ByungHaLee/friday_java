import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
* 2.
* merge two sorted arrays
* Write a function that accepts two sorted arrays of numbers
* return a combined array of the numbers in sorted order
* The optimal solution is O(n) linear time, if you get stuck you can research ‘merge sort’
* input: [3, 4, 7, 8] [1, 5, 6, 9]
* output: [1, 3, 4, 5, 6, 7, 8, 9]
*/
public class MergeTwoSortedArrays {
    public int[] mergeTwoSortedArrays(int[][] arr) {
        int[] left = arr[0], right = arr[1];
        int leftCur = 0, rightCur = 0;
        int length = left.length + right.length;
        int[] result = new int[length];

        for(int i=0; i<length; i++) {
            if(rightCur >= right.length || (leftCur < left.length && left[leftCur] < right[rightCur])){
                result[i] = left[leftCur];
                leftCur++;
            }
            else {
                result[i] = right[rightCur];
                rightCur++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] input = {{3,4,7,8}, {1,5,6,9}};
        int[] expectedOutput = {1,3,4,5,6,7,8,9};
        int[] output = mergeTwoSortedArrays(input);
        assertArrayEquals(expectedOutput, output);
    }
}
