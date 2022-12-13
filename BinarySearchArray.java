import java.util.*;
/**
 * Write a description of class BinarySearchArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchArray<T extends Comparable<T>> implements WordCountCollection<T>
{
    private int size;
    private ArrayList<T> list;
    public BinarySearchArray()
    {
        list = new ArrayList<T>();
        size = 0;
    }
   // Returns the number of elements in this collection.
    public int size(){
        return size;
    }
    
    // Returns true if this collection is empty; otherwise, returns false.
    public boolean isEmpty()
    {
        return size==0;
    }

    // Adds element to this collection.
    // Precondition: element is not already in the collection
    public void add (T element)
    {
        
            int high = size-1;
            int low = 0;
            int mid;
            int index = size;
             while(low<=high)
            {
                mid = low+((high-low)/2);
                if(list.get(mid).compareTo(element) < 0)
                {
                   low = mid+1; 
                }
                else if (list.get(mid).compareTo(element) > 0)
                {
                    high = mid-1;
                }
                else if (list.get(mid).compareTo(element) == 0)
                {
                    index = mid;
                    break;
                }
            }
            list.add(index, element);
        
        size++;
    }
    
    // Returns the element of this colletion if contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element)
    {
        // int high=size-1, low=0, mid;
        // while(low<=high)
        // {
            // mid = (low+high)/2;
            // T e = list.get(mid);
            // if(e.compareTo(element) > 0)
            // {
                // high = mid-1;
            // }
            // else if(e.compareTo(element) < 0)
            // {
                // low = mid+1;
            // }
            // else if(e.compareTo(element) == 0)
            // {
                // return e;
            // }
        // }
        // return null;
        for(T e : list)
        {
            if(e.compareTo(element) == 0)
            {
                return e;
            }
        }
        return null;
    }
    // Removes all elements in this collection
    public void clear()
    {
        while(!isEmpty())
        {
            list.remove(size-1);
            size--;
        }
    }
    
    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList()
    {
        List<T> list2 = list;
        return list2;
    }
}
