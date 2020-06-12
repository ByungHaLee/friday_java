import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] arr) {
        int evenCur=0, oddCur=arr.length-1;
        int buf;
        for(; evenCur < oddCur;) {
            if(arr[evenCur]%2 == 0){
                evenCur++;
                continue;
            }
            if(arr[oddCur]%2 == 1) {
                oddCur++;
                continue;
            }

            buf = arr[evenCur];
            arr[evenCur] = arr[oddCur];
            arr[oddCur] = buf;
            oddCur--;
            evenCur++;
        }
        return arr;
    }

    @Test
    public void test() {
        int[] input = {3,1,2,4};
        int[] expectedCnt = {2,2};
        int[] output = sortArrayByParity(input);
        System.out.println(Arrays.toString(output));
        assertParity(output, expectedCnt);

    }
    public void assertParity(int[] arr, int[] cnt) {
        for(int i=0; i<cnt[0];i++)
            assertEquals(0, arr[i]%2);
        for(int i=0; i<cnt[1];i++)
            assertEquals(1, arr[i+cnt[0]]%2);
    }
}
