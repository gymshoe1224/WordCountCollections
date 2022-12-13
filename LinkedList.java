import java.util.*;

/**
 * Write a description of class LinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedList<T extends Comparable<T>> implements WordCountCollection<T>
{
    // Returns the number of elements in this collection.
    private int size;
    private LLNode<T> front, rear;
    public LinkedList()
    {
        size = 0;
        front = null;
        rear = null;
    }
    
    public int size()
    {
        return size;
    }
    
    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add (T element){
        LLNode<T> temp = new LLNode<T>(element);
        if(rear == null)
        {
            front = temp;
        }
        else
        {
            rear.setLink(temp);
        }
        rear = temp;
        size++;
    }
    
    // Returns the element of this colletion if contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element){
        LLNode<T> currNode = front;
        while(currNode != null)
        {
            T e = currNode.getInfo();
            if(e.compareTo(element) == 0)
            {
                return e;
            }
            currNode = currNode.getLink();
        }
        return null;
    }

    // Removes all elements in this collection
    public void clear(){
        front = null;
        rear = null;
        size = 0;
    }
    
    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList(){
        LLNode<T> k = front;
        List<T> list = new ArrayList<T>();
        while(k != null)
        {
            list.add(k.getInfo());
            k = k.getLink();
        }
        return list;
    }
}
