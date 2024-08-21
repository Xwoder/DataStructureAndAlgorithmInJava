package MergeSort_;

import InsertionSorting_.InsertionSorting;
import utils.tools.Asserts;
import utils.tools.Integers;

public class MergeSortTest {
    public static void main(String[] args) {
        {
            Integer[] array = Integers.random(100, 100, 999);
            MergeSort.sort(array);
            Asserts.test(Integers.isAscOrder(array));
        }

        {
            Integer[] array = Integers.random(100, 100, 999);
            MergeSort.sort(array);
            Asserts.test(Integers.isAscOrder(array));
        }

        {
            Integer[] array = Integers.descOrder(100, 999);
            MergeSort.sort(array);
            Asserts.test(Integers.isAscOrder(array));
        }
    }
}
