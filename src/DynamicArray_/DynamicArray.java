package DynamicArray_;

import java.text.MessageFormat;

public class DynamicArray<T> {
    public static final int ELEMENT_NOT_FOUND_INDEX = -1;
    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size = 0;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }

        //noinspection unchecked
        this.array = (T[]) new Object[capacity];
    }

    public T set(int index, T element) throws IndexOutOfBoundsException {
        rangeCheck(index);

        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    /**
     * 返回指定索引的元素
     *
     * @param index 索引
     * @return 位于指定索引的元素
     * @throws IndexOutOfBoundsException 索引越界异常
     */
    public T get(int index) throws IndexOutOfBoundsException {
        rangeCheck(index);

        return array[index];
    }

    public int index(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND_INDEX;
    }

    public boolean contains(T element) {
        return index(element) != ELEMENT_NOT_FOUND_INDEX;
    }

    /**
     * 清空数组
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void add(T element) {
        add(size, element);
    }


    /**
     * 删除索引为 index 的元素
     *
     * @param index 索引
     * @return 被删除的元素
     */
    public T remove(int index) {
        rangeCheck(index);

        T element = array[index];

        for (int i = index+1; i < size; i++) {
            array[i-1] = array[i];
        }

        array[size--] = null;

        return element;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            String errorMsg = MessageFormat.format("index = {0}, size = {1}", index, size);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }

    public void add(int index, T element) {
        rangeCheckForAdd(index);


        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    private void ensureCapacity(int requiredCapacity) {
        int currentCapacity = array.length;
        if (currentCapacity >= requiredCapacity) {
            return;
        }

        int newCapacity = currentCapacity + (currentCapacity >> 1);
        //noinspection unchecked
        T[] newArray = (T[]) new Object[newCapacity];

        if (size >= 0) {
            System.arraycopy(array, 0, newArray, 0, size);
        }

        array = newArray;
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            String errorMsg = MessageFormat.format("index = {0}, size = {1}", index, size);
            throw new IndexOutOfBoundsException(errorMsg);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return "array = %s, size = %d, capacity = %d".formatted(sb, size, array.length);
    }

    public int getSize() {
        return size;
    }
}
