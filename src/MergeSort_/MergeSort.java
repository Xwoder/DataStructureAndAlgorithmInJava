package MergeSort_;

public class MergeSort {
    public static void sort(Integer[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        sort(array, 0, array.length);
    }

    private static void sort(Integer[] array, int begin, int end) {
        if (end - begin <= 1) {
            return;
        }

        final int mid = begin + ((end - begin) >> 1);

        sort(array, begin, mid);
        sort(array, mid, end);
        merge(array, begin, mid, end);
    }

    private static void merge(Integer[] array, int begin, int mid, int end) {
        final Integer[] leftHalf = new Integer[mid - begin];
        if (mid - begin >= 0) {
            System.arraycopy(array, begin, leftHalf, 0, mid - begin);
        }

        final Integer[] rightHalf = new Integer[end - mid];
        if (end - mid >= 0) {
            System.arraycopy(array, mid, rightHalf, 0, end - mid);
        }

        int leftCur = 0;
        int rightCur = 0;

        int arrayCur = begin;

        while ((leftCur < leftHalf.length) && (rightCur < rightHalf.length)) {
            if (leftHalf[leftCur] <= rightHalf[rightCur]) {
                array[arrayCur] = leftHalf[leftCur];
                leftCur++;
            } else {
                array[arrayCur] = rightHalf[rightCur];
                rightCur++;
            }
            arrayCur++;
        }

        while (leftCur < leftHalf.length) {
            array[arrayCur] = leftHalf[leftCur];
            arrayCur++;
            leftCur++;
        }

        while (rightCur < rightHalf.length) {
            array[arrayCur] = rightHalf[rightCur];
            arrayCur++;
            rightCur++;
        }
    }

}
