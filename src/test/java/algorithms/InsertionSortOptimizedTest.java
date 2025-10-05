package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

public class InsertionSortOptimizedTest {
    @Test
    public void testRandom() {
        Random r = new Random(1);
        for (int n : new int[]{0,1,5,10,100,500}) {
            int[] a = r.ints(n).toArray();
            int[] b = a.clone();
            InsertionSortOptimized.sort(a);
            java.util.Arrays.sort(b);
            assertArrayEquals(b,a);
        }
    }

    @Test
    public void testNearlySorted() {
        int[] a = new int[100];
        for (int i=0;i<100;i++) a[i]=i;
        a[20]=a[21]; a[21]=19;
        InsertionSortOptimized.sort(a);
        assertTrue(InsertionSortOptimized.isSorted(a));
    }
}
