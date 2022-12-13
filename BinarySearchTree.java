import java.util.*;

/**
 * Write a description of class BinarySearchTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinarySearchTree<T extends Comparable<T>> implements WordCountCollection<T>
{
    private BinaryNode<T> root;
    private int size;
    public BinarySearchTree()
    {
        root = null;
        size=0;
    }
    // Returns the number of elements in this collection.
    public int size()
    {
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
        root = add(element, root);
        size++;
    }
    private BinaryNode<T> add(T element, BinaryNode<T> tree)
    {
        if(tree == null)
        {
            tree = new BinaryNode(element);
        }
        else if(element.compareTo(tree.getInfo()) <= 0)
        {
            tree.setLeft(add(element, tree.getLeft()));
        }
        else
        {
            tree.setRight(add(element, tree.getRight()));
        }
        return tree;
    }
    // Returns the element of this colletion if contains an element e such that
    // e.compareTo(element) == 0; otherwise, returns null.
    public T fetch(T element)
    {
        return fetch(element, root);
    }
    private T fetch(T element, BinaryNode<T> tree)
    {
        if(tree == null)
        {
            return null;
        }
        else if(element.compareTo(tree.getInfo()) < 0)
        {
            return fetch(element, tree.getLeft());
        }
        else if(element.compareTo(tree.getInfo()) > 0)
        {
            return fetch(element, tree.getRight());
        }
        else
        {
            return tree.getInfo();
        }
    }
    // Removes all elements in this collection
    public void clear()
    {
        root = null;
        size=0;
    }
    
    // generates a list of the elements in the collection
    // Postcondion: list is independant (deep copy) of original collection
    public List<T> createList()
    {
        List<T> treeList = new ArrayList<T>();
        inorderTraverse(root, treeList);
        return treeList;
    }
    private void inorderTraverse(BinaryNode<T> tree, List<T> list)
    {
        if(tree!=null)
        {
            inorderTraverse(tree.getLeft(), list);
            list.add(tree.getInfo());
            inorderTraverse(tree.getRight(),list);
        }
    }
}
