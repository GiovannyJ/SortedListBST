
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
     /**
      * Adds entry to the list 
      * @param newEntry: entry to be added to the list
      */
    public void add(T newEntry){
        //add the new entry to the list and increase the number of entries
        list.add(newEntry); //BST handles the order 
        numberOfEntries++;
    }

    /**
     * removes specified entry from the list
     * @param anEntry: entry to be removed from the list
     * @return: TRUE if the entry was removed, FALSE if not
     */
    public boolean remove(T anEntry){
        //if the list can remove an entry then decrease th num of entries
        if(list.remove(anEntry) != null){
            numberOfEntries--;
            return true;
        }
        return false;
    }
    
    /**
     * removes specified entry from a list at a given position
     * @param givenPosition: the position at which to remove an entry
     * @return: the entry that was removed at the positoin
     * @throws: IndexOutOfBoundsException if the given postion is not in bounds
     */
    public T remove(int givenPosition){
        //check if the position is out of bounds
        if(givenPosition > getLength() || givenPosition < 0){
            throw new IndexOutOfBoundsException("The Index is out of Bounds");
        }
        //get the entry at the given postion
        T entry = getEntry(givenPosition);
        
        //call the remove method
        if(remove(entry))
            return entry;
        
        return null;
    }


    /**
     * retrives the entry from the given position
     * @param givenPosition: the postion at which to retrive the entry
     * @return: the entry that was at the given postion
     * @throws: IndexOutOfBoundsException if the given postion is not in bounds
     */
    public T getEntry(int givenPosition){
        //check the bounds
        if(givenPosition > getLength() || givenPosition < 0){
            throw new IndexOutOfBoundsException("The Index is out of Bounds");
        }
        
        //initialize iterator and other values
        Iterator<T> listIterator = list.getInorderIterator();
        int i = 0;
        T entry = null;

        //iterate through the list while you are not at he gicen postion
        while(listIterator.hasNext() && i != givenPosition){
            entry = listIterator.next();
            i++;
        }
        return entry;
    }
    

    /**
     * retrieves the postion of the given entry 
     * @param anEntry: the entry to find the postion of
     * @return: the numeric postion at which the entry was found -1 if not found
     */
    public int getPosition(T anEntry){
        //position starts at 1 in the list
        int position = 1;
        
        //if the postion is in bounds and the entry is greater than the one at that position
        //then we are not at the right position yet
        while(position <= getLength() && anEntry.compareTo(getEntry(position)) > 0){
                position++;
        }//iterates until the position is found


        //if the list does not contain the entry than its position is negated OR
        //if the entry position is outside of the list then its position is negated
        if(position > getLength() || !contains(anEntry)){
            position = -position;
        }
        return position;
        

    }

    /**
     * checks if the list has a certain entry
     * @param anEntry: the entry to check if it exists
     * @return: TRUE if the entry was found FALSE IF NOT  
    */
    public boolean contains(T anEntry){
        //call the contains method from BST
        return list.contains(anEntry);
    }
    

    /**
     * Clears the list of all entries
     */
    public void clear(){
        //call the clear method from BST and reset the number of entries
        list.clear();
        numberOfEntries = 0;
    }

    /**
     * gets the current length of the list
     * @return the number of entries in the list
     */
    public int getLength(){
        //property that stores the length of the list
        return numberOfEntries;
    }
    
    /**
     * checks if the list is empty or not
     * @return: TRUE if the list is empty FALSE if not
     */
    public boolean isEmpty(){
        //if there are no entries in the list then it is empty
        return numberOfEntries == 0;
    }

    /**
     * Converts the list to an array that is indexable
     * @return: an array version of the list
     */
    public T[] toArray(){
        //initiate obj array to work with an return
        T[] res = (T[]) new Object[numberOfEntries];

        //create iterator to go through the list
        Iterator<T> listIter = list.getInorderIterator();
        
        //iniitalize indexer
        int i = 0;
        //while there are still values in the iterator
        while(listIter.hasNext()){
            //append each index with the itertor value
            res[i] = listIter.next();
            i++;
        }
        return res;
    }
}
