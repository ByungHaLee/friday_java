import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] arr) {
        int evenCur=0, oddCur=1;
        int buf;
        for(;evenCur < arr.length && oddCur < arr.length;) {
            if(arr[evenCur]%2 == 0) {
                evenCur += 2;
                continue;
            }
            if(arr[oddCur]%2 == 1) {
                oddCur += 2;
                continue;
            }
            buf = arr[evenCur];
            arr[evenCur] = arr[oddCur];
            arr[oddCur] = buf;
            evenCur += 2;
            oddCur += 2;
        }
        return arr;
    }

    @Test
    public void test() {
        int[] input = {4,2,5,7};
        int[] output = sortArrayByParityII(input);
        assertParity(output);
    }

    private void assertParity(int[] output) {
        for(int i=0; i<output.length; i++)
            assertEquals(i%2, output[i]%2);
    }
}
