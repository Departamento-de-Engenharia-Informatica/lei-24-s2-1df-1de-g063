package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void selectionSortArray() {
        SelectionSort selectionSort = new SelectionSort();
        double[] arr = {5.0, 3.0, 1.0, 4.0, 2.0};
        double[] expectedArr = {5.0, 4.0, 3.0, 2.0, 1.0};
        selectionSort.selectionSortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void selectionSortListGreenSpaces() {
        SelectionSort selectionSort = new SelectionSort();
        GreenSpace gs1 = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        GreenSpace gs2 = new GreenSpace("Park2", 200.0, Size.Large_Size, "Francisco");
        GreenSpace gs3 = new GreenSpace("Park3", 150.0, Size.Large_Size, "Francisco");
        List<GreenSpace> gsList = Arrays.asList(gs1, gs2, gs3);
        List<GreenSpace> expectedGsList = Arrays.asList(gs2, gs3, gs1);
        selectionSort.selectionSortListGreenSpaces(gsList);
        assertEquals(expectedGsList, gsList);
    }
}