package offer;

import java.util.Collections;
import java.util.Comparator;

public class Heap<T extends Comparable<T>> {
    private T[] arr;
    private Comparator<T> comparator;
    private int size;
    private static final int MAX_SIZE = 1_000;

    public Heap() {
        this(null);
    }

    public Heap(Comparator<T> comparator) {
        arr = (T[]) new Object[MAX_SIZE];
        if (comparator == null) {
            this.comparator = new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    return o1.compareTo(o2);
                }
            };
        } else {
            this.comparator = comparator;
        }
    }

    private void shiftUp(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        T obj = arr[index];
        while (index > 0) {
            // 找父元素对象的位置
            int parentIndex = (index - 1) / 2;
            //子节点优先级高
            if (comparator.compare(arr[index], arr[parentIndex]) < 0) {
                arr[index] = arr[parentIndex];
                index = parentIndex;
            } else {
                break;
            }
        }
        arr[index] = obj;
    }

    private void shiftDown(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException(index);
        T obj = arr[index];
        int leftIndex = 2 * index + 1;
        while (leftIndex < size) {
            T child = arr[leftIndex];
            //右孩子优先级更高
            if (leftIndex + 1 < size && comparator.compare(arr[leftIndex], arr[leftIndex + 1]) > 0) {
                child = arr[leftIndex + 1];
                leftIndex = leftIndex + 1;
            }
            if (comparator.compare(arr[index], child) > 0) {
                arr[index] = child;
                index = leftIndex;
                leftIndex = 2 * index + 1;
            } else {
                break;
            }
        }
        arr[index] = obj;
    }

    public void add(T t) {
        if (size >= MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException(MAX_SIZE);
        }
        arr[size++] = t;
        shiftUp(size - 1);
    }

    public T remove() {
        if (size <= 0)
            throw new ArrayIndexOutOfBoundsException(0);
        T t = arr[0];
        T tmp = arr[size - 1];
        size--;
        if (size !=0){
            arr[0] = tmp;
            shiftDown(0);
        }
        return t;
    }

}
