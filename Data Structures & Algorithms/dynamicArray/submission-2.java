class DynamicArray {
    private int[] data;
    private int size;

    public DynamicArray(int capacity) {
        if (capacity < 1) capacity = 1;
        this.data = new int[capacity];
        this.size = 0;
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + ", size " + size);
        }
    }

    public int get(int i) {
        checkIndex(i);
        return data[i];
    }

    public void set(int i, int n) {
        checkIndex(i);
        data[i] = n;
    }

    public void pushback(int n) {
        if (data.length == size) {
            resize();
        }

        data[size++] = n;
    }

    public int popback() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }

        return data[--size];
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.data.length;
    }
}
