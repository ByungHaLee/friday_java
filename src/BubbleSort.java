import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSort {
    public int[] bubbleSort(int[] arr) {
        int buf;
        int cnt = 0;
        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    buf = arr[i];
                    arr[i] = arr[j];
                    arr[j] = buf;
                }
                cnt++;
            }
        }
        System.out.println("n:"+arr.length+" cnt:"+cnt);
        return arr;
    }

    @Test
    public void test() {
        int[] input = {4, 7, 2, 3, 8};
        int[] expectedOutput = {2, 3, 4, 7, 8};
        int[] output = bubbleSort(input);
        assertArrayEquals(expectedOutput, output);
    }
}
