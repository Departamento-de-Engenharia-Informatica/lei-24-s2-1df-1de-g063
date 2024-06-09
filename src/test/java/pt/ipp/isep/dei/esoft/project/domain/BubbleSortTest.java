package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void bubbleSortArray() {
        BubbleSort bubbleSort = new BubbleSort();
        double[] arr = {5.0, 3.0, 1.0, 4.0, 2.0};
        double[] expectedArr = {5.0, 4.0, 3.0, 2.0, 1.0};
        bubbleSort.bubbleSortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void bubbleSortListGreenSpaces() {
        BubbleSort bubbleSort = new BubbleSort();
        GreenSpace gs1 = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        GreenSpace gs2 = new GreenSpace("Park2", 200.0, Size.Large_Size, "Francisco");
        GreenSpace gs3 = new GreenSpace("Park3", 150.0, Size.Large_Size, "Francisco");
        List<GreenSpace> gsList = Arrays.asList(gs1, gs2, gs3);
        List<GreenSpace> expectedGsList = Arrays.asList(gs2, gs3, gs1);
        bubbleSort.bubbleSortListGreenSpaces(gsList);
        assertEquals(expectedGsList, gsList);
    }
}