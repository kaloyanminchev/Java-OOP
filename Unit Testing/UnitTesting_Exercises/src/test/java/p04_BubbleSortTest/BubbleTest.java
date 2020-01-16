package p04_BubbleSortTest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class BubbleTest {

    @Test
    public void bubbleSortShouldSortElements() {
        int[] actual = {13, 42, 69};
        int[] expected = {13, 42, 69};

        Bubble.sort(actual);

        Arrays.sort(expected);

        assertArrayEquals(expected, actual);
    }
}