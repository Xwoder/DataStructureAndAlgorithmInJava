package BInarySearch_;

public class BinarySearch {
    public static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 插入排序，迭代式实现
     *
     * @param array 数组
     * @param targetValue 目标值
     * @return 若目标值存在，则返回其索引；否则，返回 ELEMENT_NOT_FOUND
     */
    public static int indexOfByIteration(int[] array, int targetValue) {
        int begin = 0;
        int end = array.length;

        while (begin < end) {
            int mid = begin + ((end - begin) >> 1);
            int midValue = array[mid];
            if (targetValue > midValue) {
                begin = mid + 1;
            } else if (targetValue < midValue) {
                end = mid;
            } else {
                return mid;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 插入排序，递归式实现
     *
     * @param array 数组
     * @param targetValue 目标值
     * @return 若目标值存在，则返回其索引；否则，返回 ELEMENT_NOT_FOUND
     */
    public static int indexOfByRecursion(int[] array, int targetValue) {
        return indexOfByRecursion(array,targetValue, 0,array.length);
    }

    private static int indexOfByRecursion(int[] array, int targetValue, int begin, int end) {
        if (begin >= end) {
            return ELEMENT_NOT_FOUND;
        }

        int mid = begin + ((end - begin) >> 1);
        int midValue = array[mid];

        if (targetValue > midValue) {
            return indexOfByRecursion(array, targetValue, mid + 1, end);
        } else if (targetValue < midValue) {
            return indexOfByRecursion(array, targetValue, begin, mid);
        } else {
            return mid;
        }
    }
}
