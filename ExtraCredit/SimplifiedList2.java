public interface SimplifiedList2<E> {
    public boolean add(E item);
    public boolean add(int index, E item);

    public E remove(int index);
    public E set(int index, E item);
    public E get(int index);

    public boolean contains (E item);

    public boolean isEmpty();
    public void clear();
    public int size();

    public boolean isFull();
} // interface SimplifiedList
