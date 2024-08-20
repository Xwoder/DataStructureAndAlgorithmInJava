package BInarySearch_;

import utils.tools.Asserts;

import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] array = {124, 133, 162, 212, 310, 558, 682, 700, 793, 891};

        Asserts.test(BinarySearch.indexOfByIteration(array, 122) == BinarySearch.ELEMENT_NOT_FOUND);
        Asserts.test(BinarySearch.indexOfByIteration(array, 124) == 0);
        Asserts.test(BinarySearch.indexOfByIteration(array, 212) == 3);
        Asserts.test(BinarySearch.indexOfByIteration(array, 891) == 9);
        Asserts.test(BinarySearch.indexOfByIteration(array, 900) == BinarySearch.ELEMENT_NOT_FOUND);

        Asserts.test(BinarySearch.indexOfByRecursion(array, 122) == BinarySearch.ELEMENT_NOT_FOUND);
        Asserts.test(BinarySearch.indexOfByRecursion(array, 124) == 0);
        Asserts.test(BinarySearch.indexOfByRecursion(array, 212) == 3);
        Asserts.test(BinarySearch.indexOfByRecursion(array, 891) == 9);
        Asserts.test(BinarySearch.indexOfByRecursion(array, 900) == BinarySearch.ELEMENT_NOT_FOUND);

    }
}
