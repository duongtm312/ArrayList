import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];

    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (index > size && index < 0) {
            System.out.println("Error add index: " + index);
        } else {
            elements[index] = element;
        }
    }

    public boolean add(E element) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = element;
        return true;
    }

    public E remove(int index) {
        E delete = null;
        if (index > size && index < 0) {
            System.out.println("Error remove index: " + index);
        } else {
            delete = (E) elements[index];
            for (int i = 0; i < elements.length - 1; i++) {
                if (i >= index) {
                    elements[i] = elements[i + 1];
                }
            }
            size--;
        }
        return delete;
    }

    public int size() {
        return size;
    }

    public E clones() {

        return (E) Arrays.copyOf(elements, size);
    }
    public boolean contain(E obj){
        for (Object element:elements
             ) {
            if (obj==element){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E obj){
        int index=-1;
        for (int i = 0; i <elements.length ; i++) {
            if (elements[i].equals(obj)){
                index=i;
            }
        }
        return index;
    }
    public E get(int index){
        return (E) elements[index];
    }
    public void clear(){
        elements=new Object[DEFAULT_CAPACITY];
    }

}
