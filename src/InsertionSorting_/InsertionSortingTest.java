package InsertionSorting_;

import utils.printer.Printer;
import utils.tools.Asserts;
import utils.tools.Integers;

import java.util.Arrays;

public class InsertionSortingTest {
    public static void main(String[] args) {
        {
            {
                Integer[] array = Integers.random(100, 100, 999);
                InsertionSorting.sortBySwapOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }

            {
                Integer[] array = Integers.random(100, 100, 999);
                InsertionSorting.sortBySwapOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }

            {
                Integer[] array = Integers.descOrder(100, 999);
                InsertionSorting.sortBySwapOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }
        }

        {
            {
                Integer[] array = Integers.random(100, 100, 999);
                InsertionSorting.sortByMoveOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }

            {
                Integer[] array = Integers.random(100, 100, 999);
                InsertionSorting.sortByMoveOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }

            {
                Integer[] array = Integers.descOrder(100, 999);
                InsertionSorting.sortByMoveOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }
        }

        {
            {
                Integer[] array = Integers.random(100, 100, 999);
                InsertionSorting.sortByOptimizedMoveOneByOne(array);
                Integers.println(array);
                Asserts.test(Integers.isAscOrder(array));
            }

            {
                Integer[] array = Integers.random(100, 100, 999);
                InsertionSorting.sortByOptimizedMoveOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }

            {
                Integer[] array = Integers.descOrder(100, 999);
                InsertionSorting.sortByOptimizedMoveOneByOne(array);
                Asserts.test(Integers.isAscOrder(array));
            }
        }
    }
}
