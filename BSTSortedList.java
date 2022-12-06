
/**
 * BSTSortedList.java - Shell for Assignment #5
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import TreePackage.*;

public class BSTSortedList<T extends Comparable<? super T>>
implements SortedListInterface<T>
{
    private BinarySearchTree<T> list;   //the sorted list, represented as a BST
    private int numberOfEntries;        //number of entries currently in list

    //default constructor -- list is initially empty
    public BSTSortedList()
    {
        list = new BinarySearchTree<>();
        numberOfEntries = 0;
    }

    //FILL IN IMPLEMENTATION OF METHODS BELOW
    
}
