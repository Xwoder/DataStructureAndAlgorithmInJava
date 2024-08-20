package InsertionSorting_;

import utils.tools.Asserts;
import utils.tools.Integers;

public class InsertionSortingTest {
    public static void main(String[] args) {
        {
            Integer[] array = Integers.random(100, 100, 999);
            InsertionSorting.sortSwapOneByOne(array);
            Asserts.test(Integers.isAscOrder(array));
        }

        {
            Integer[] array = Integers.random(100, 100, 999);
            InsertionSorting.sortOptimizedSwapOneByOne(array);
            Asserts.test(Integers.isAscOrder(array));
        }

        {
            Integer[] array = Integers.descOrder(100, 999);
            InsertionSorting.sortOptimizedSwapOneByOne(array);
            Asserts.test(Integers.isAscOrder(array));
        }
    }
}
