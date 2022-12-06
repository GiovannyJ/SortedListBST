
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
    //!needs to add in order
    //!use in order iterator
    public void add(T newEntry){

    }

    @Override
    public boolean remove(T anEntry){
        return false;
    }

    
    public T remove(int givenPosition){
        return T;
    }

    public T getEntry(int givenPosition){
        return T;
    }

    public int getPosition(T anEntry){
        return 0;
    }

    public boolean contains(T anEntry){
        return false;
    }

    public void clear(){

    }

    public int getLength(){
        return 0;
    }
    
    public boolean isEmpty(){
        return false;
    }

    public T[] toArray(){
        return T;
    }
}
