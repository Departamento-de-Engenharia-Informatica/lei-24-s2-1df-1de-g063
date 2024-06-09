package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void mergeSortArray() {
        MergeSort mergeSort = new MergeSort();
        double[] arr = {5.0, 3.0, 1.0, 4.0, 2.0};
        double[] expectedArr = {5.0, 4.0, 3.0, 2.0, 1.0};
        mergeSort.mergeSortArray(arr);
        assertArrayEquals(expectedArr, arr);
    }

    @Test
    void mergeSortGreenSpaces() {
        MergeSort mergeSort = new MergeSort();
        GreenSpace gs1 = new GreenSpace("Park1", 100.0, Size.Large_Size, "Francisco");
        GreenSpace gs2 = new GreenSpace("Park2", 200.0, Size.Large_Size, "Francisco");
        GreenSpace gs3 = new GreenSpace("Park3", 150.0, Size.Large_Size, "Francisco");
        List<GreenSpace> gsList = Arrays.asList(gs1, gs2, gs3);
        List<GreenSpace> expectedGsList = Arrays.asList(gs2, gs3, gs1);
        mergeSort.mergeSortGreenSpaces(gsList);
        assertEquals(expectedGsList, gsList);
    }
}