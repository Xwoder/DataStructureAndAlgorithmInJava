package InsertionSorting_;

public class InsertionSorting {
    public static void sortBySwapOneByOne(Integer[] array) {
        if (array == null) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void sortByMoveOneByOne(Integer[] array) {
        if (array == null) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int curValue = array[i];
            int j;
            for (j = i; j > 0; j--) {
                if (array[j - 1] <= curValue) {
                    break;
                }
                array[j] = array[j - 1];
            }

            array[j] = curValue;
        }
    }

    /**
     * 插入排序，使用折半查找优化
     *
     * @param array 待排序的数组
     */
    public static void sortByOptimizedMoveOneByOne(Integer[] array) {
        if (array == null) {
            return;
        }


        for (int i = 1; i < array.length; i++) {
            final int curValue = array[i];

            int begin = 0;
            int end = i;

            while (begin < end) {
                final int mid = begin + ((end - begin) >> 1);
                final Integer midValue = array[mid];
                if (curValue >= midValue) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }

            for (int j = i; j > begin; j--) {
                array[j] = array[j - 1];
            }

            array[begin] = curValue;
        }
    }


    /**
     * 交换数组位于给定索引的元素
     *
     * @param array 数组
     * @param i     第1个索引
     * @param j     第2个索引
     */
    private static void swap(Integer[] array, int i, int j) {
        final var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
