import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] arr) {
        int centerValue = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i] * arr[i];
            // find center
            if(arr[i] < centerValue) {
                centerValue = arr[i];
                index = i;
            }
        }
        int[] result = new int[arr.length];
        int leftCur = index - 1, rightCur = index + 1;
        result[0] = arr[index];
        for(int i=1; i<arr.length; i++) {
            if(rightCur >= arr.length || (leftCur >= 0 && arr[leftCur]<arr[rightCur] )) {
                result[i] = arr[leftCur];
                leftCur--;
            } else {
                result[i] = arr[rightCur];
                rightCur++;
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] input = {-4,-1,0,3,10};
        int[] expectedOutput = {0,1,9,16,100};
        int[] output = sortedSquares(input);
        assertArrayEquals(expectedOutput, output);
    }

    @Test
    public void test2() {
        int[] input = {-7,-3,2,3,11};
        int[] expectedOutput = {4,9,9,49,121};
        int[] output = sortedSquares(input);
        assertArrayEquals(expectedOutput, output);
    }
}
