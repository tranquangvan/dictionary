package Dictionary2;

import java.util.AbstractList;
import java.util.List;

public class MyVector<E> extends AbstractList<E> implements Cloneable, List<E>,java.io.Serializable{

    protected Object[] items;
    protected int arraySize;
    protected int maxCap;

    public MyVector(int initialCapacity, int capacityIncrement) {
        super();
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
        }
        this.items = new Object[initialCapacity];
        this.arraySize = 0;
        this.maxCap = capacityIncrement;
    }
    public MyVector(int initialCapacity) {
        this(initialCapacity, 0);
    }

    public MyVector() {
        this(10);
    }

    @Override
    public E get(int index) {
        if (index>= arraySize)
            throw new ArrayIndexOutOfBoundsException(index);
        return items(index);
    }

    private E items(int index) {
        return (E) items[index];
    }


    public boolean add(Object element) {
        int newArraySize = this.arraySize + 1;
        if(this.maxCap == newArraySize) {
            this.items = this.increaseCap(newArraySize);
            this.items[this.arraySize] = element;
            this.arraySize += 1;
            return true;
            //System.out.println(this.items[this.arraySize);
        } else {
            this.items[this.arraySize] = element;
            this.arraySize +=1;
            return true;
        }
    }

    @Override
    public String toString() {
        String output = "[";
        //output = this.items[0].toString();
        for(int i = 0; i < this.arraySize; i++) {
            output += this.items[i] + ", ";
        }
        output += "]";
        return output;
    }
    public void clear() {
        for(int i = 0; i < this.arraySize; i++) {
            this.items[i] = null;
            this.arraySize = 0;
        }
    }
    public boolean contains(Object element) {
        boolean doesContain = false;
        for(int i = 0; i < this.arraySize; i++) {
            if(element == this.items[i]) {
                doesContain = true;
                i = this.arraySize;
            }
        }
        return doesContain;
    }
    public Object elementAt(int index) {
        if(this.arraySize >= index) {
            return this.items[index];
        } else {
            Object temp = null;
            System.out.println("No index of " + index);
            return temp;
        }
    }
    public int indexOf(Object element) {
        Object index = "No value found";
        for(int i = 0; i < this.arraySize; i++) {
            if(element == this.items[i]) {
                index = i;
                break;
            }
        }
        return (int) index;
    }
    public boolean isEmpty() {
        if(this.arraySize == 0) {
            return true;
        }
        return false;
    }
    public void replace(int index, Object element) {
        if(this.arraySize > index) {
            this.items[index] = element;
        } else {
            System.out.println("No element at " + index);
        }
    }
    public int size() {
        return this.arraySize;
    }
    public void reverse() {
        Object[] temp = new Object[this.items.length];
        int j = this.arraySize;
        for(int i = 0; i < this.arraySize; i++) {
            temp[j] = this.items[i];
            j--;
        }
        this.items = temp;
    }
    public void ensureCapacity(int minCapacity) {
        if(minCapacity > this.items.length) {
            this.items = this.increaseCap(minCapacity);
        }
    }
    public Object[] increaseCap(int minCap) {
        Object[] arr1 = new Object[minCap * 2];
        for(int i = 0; i < minCap; i++) {
            arr1[i] = this.items[i];
        }
        this.maxCap = this.maxCap * 2;
        return arr1;
    }
    @Override
    public Object clone() {
        return this.items;
    }
    public boolean checkIndex(int index) {
        boolean check = false;
        if(index < this.arraySize) {
            check = true;
        }
        return check;
    }
    public void removeAt(int index) {
        if(true == this.checkIndex(index)) {
            Object[] temp = new Object[this.arraySize - 1];
            for(int j = 0; j < index; j++) {
                temp[j] = this.items[j];
            }
            for(int j = index + 1; j < this.arraySize; j++) {
                temp[j-1] = this.items[j];
            }
            this.items = temp;
            this.arraySize = this.arraySize - 1;
        }
    }
    public void insertAt(int index, Object element) {
        if (this.checkIndex(index) == true) {
            Object[] temp = new Object[this.arraySize];
            for(int i = index; i < this.arraySize; i++) {
                temp[i+1] = this.items[i];
            }
            this.items[index] = element;
            for (int i = index + 1; i < this.arraySize; i++) {
                this.items[i] = temp[i - 1];
            }
            this.arraySize = this.arraySize - 1;
        }
    }
    public boolean remove(Object element) {
        for(int i = 0; i < this.items.length; i++) {
            if(this.items[i] == element) {
                this.removeAt(i);
                return true;
            }
        }
        return false;
    }
    public void removeRange(int fromIndex, int toIndex) {
        for(int i = fromIndex; i < toIndex; i++) {
            this.removeAt(i);
        }
    }
    public void merge(MyVector vector2) {
        this.ensureCapacity(vector2.size() + this.arraySize);
        for(int i = 0; i < vector2.size(); i++) {
            this.add(vector2);
        }
    }
}