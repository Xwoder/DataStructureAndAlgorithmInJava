package DynamicArray_;

import utils.tools.Asserts;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>();
        for (int i = 0; i < 11; i++) {
            array.add(i * 10);
            System.out.println(array);
        }

        Asserts.test(array.get(5) == 50);
        Asserts.test(array.getSize() == 11);
    }
}
