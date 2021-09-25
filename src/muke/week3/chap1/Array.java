package muke.week3.chap1;

import java.util.Arrays;

public class Array<T> {

    /**
     * 数据.
     */
    private T[] dataArray;
    /**
     * 有效数据个数.
     */
    private int size;
    /**
     * 开辟数组长度.
     */
    private int capacity;

    public Array() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("初始化数组不可小于0");
        }

        this.capacity = capacity;
        dataArray = (T[]) new Object[capacity];
    }

    /**
     * 设置头位置数据.
     *
     * @param t 数据
     */
    public void setFirst(T t) {
        set(0, t);
    }

    /**
     * 设置尾位置数据.
     *
     * @param t 数据
     */
    public void setLast(T t) {
        set(size - 1, t);
    }

    /**
     * 设置指定位置元素.
     *
     * @param index 位置
     * @param t     数据
     */
    public void set(int index, T t) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("索引值异常");
        }
        dataArray[index] = t;
    }

    /**
     * 添加数据到末尾.
     *
     * @param t 数据
     */
    public void addLast(T t) {
        addElement(size, t);
    }

    /**
     * 添加数据到开头.
     *
     * @param t 数据
     */
    public void addFirst(T t) {
        addElement(0, t);
    }

    /**
     * 在指定的位置添加元素
     *
     * @param index 指定的索引位置
     * @param t     数据
     */
    public void addElement(int index, T t) {
        // 默认当前数组中不可出现null为数据元素。所以将size限定为size以下.
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引值异常");
        }

        if (size == dataArray.length) {
            resize(2 * capacity);
        }

        for (int i = size - 1; i >= index; i--) {
            dataArray[i + 1] = dataArray[i];
        }
        dataArray[index] = t;
        size++;
    }

    /**
     * 删除头数据.
     */
    public void deleteFirst() {
        deleteElement(0);
    }

    /**
     * 删除尾数据.
     */
    public void deleteLast() {
        deleteElement(size - 1);
    }

    /**
     * 删除指定位置的元素.
     *
     * @param index 位置
     */
    public void deleteElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("索引值异常");
        }
        for (int i = index; i < dataArray.length; i++) {
            dataArray[index] = dataArray[index + 1];
        }
        size--;
        // 注意这里的垃圾回收.
        dataArray[size] = null;
        if (size == dataArray.length / 2) {
            resize(dataArray.length / 2);
        }
    }

    /**
     * 删除数据（只删除一次）.
     *
     * @param t 数据
     */
    public void deleteElementFirst(T t) {
        int i = find(t);
        if (i != -1) {
            deleteElement(i);
        }
    }

    /**
     * 数组中是否包含数据.
     *
     * @param t 数据
     * @return 是否包含
     */
    public boolean contains(T t) {
        for (T data : dataArray) {
            if (data.equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找指定位置的数据.
     *
     * @param index 指定位置
     * @return 数据
     */
    public T find(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("索引值异常");
        }
        return dataArray[index];
    }

    /**
     * 查找指定数据的位置.
     *
     * @param t 数据
     * @return 位置
     */
    public int find(T t) {
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取有效数据个数.
     *
     * @return 有效数据个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取开辟内存长度.
     *
     * @return 开辟内存长度
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * 是否为空数组.
     *
     * @return 是否为空数组
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * 数组内存扩容.
     *
     * @param capacity 容量
     */
    private void resize(int capacity) {
        T[] newDataArray = (T[]) new Object[capacity];
        this.capacity = capacity;
        for (int i = 0; i < dataArray.length && i < capacity; i++) {
            newDataArray[i] = dataArray[i];
        }
        dataArray = newDataArray;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(dataArray) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
