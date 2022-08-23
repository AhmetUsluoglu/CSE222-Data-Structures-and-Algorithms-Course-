package pck.LDlinkedlist;

import java.util.*;
import pck.Buildings.*;


/**
 *Custom Linked List type class that Extends AbstractList and implements List.
*/ 
public class LDLinkedList<E> extends AbstractList<E> implements List<E> 
{
    // Initializing the size of the list to 0.
    private int size = 0;

    // Initializing the head to null.
    private Node<E> head = null;
    // Initializing the tail to null.
    private Node<E> tail = null;
    // A list of deleted nodes.
    private LinkedList<Node<E>> lazy = null;


    //** A constructor.*/ 
    public LDLinkedList() {}
    
    /**
     * A doubly linked list is a linked list where each node has a reference to the node before it and
     * the node after it
     */
    private static class Node<E> 
    {
        E data;
        Node<E> next = null;
        Node<E> prev = null;

        Node(E newData) { this.data = newData;}
    }

   /**
    * Check if the index is valid.
    * 
    * @param index The index of the element to be removed.
    * @return The method returns true if the index is valid and false otherwise.
    */
    private boolean checkIndex(int index) {return index < 0 || index > size;}
    
    /**
     * Return the node at the given index
     * 
     * @param index The index of the node to be returned.
     * @return The node at the specified index.
     */
    private Node<E> nodeAt(int index) {
        if(checkIndex(index)) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);;
        Node<E> temp = head;
        for(int i = 0; i < index; i++)  temp = temp.next;
        return temp;
    }
           
    /**
     * If the node is lazy, add it to the lazy list
     * 
     * @param deleted The node that was deleted from the tree.
     */
    private void addToLazy(Node<E> deleted)
    {
        if(lazy == null) lazy = new LinkedList<Node<E>>();
        lazy.add(deleted);
    }
    
    /**
     * If the lazy list is not empty, remove the last element from it and return it. Otherwise, return
     * null.
     * 
     * @return The last node in the list.
     */
    private Node<E> takeFromLazy()
    {
        if(lazy == null) return null;
        return lazy.removeLast();
    }
    
    
    /**
     * Prints the deleted list (Lazy)
     */
    public void printLazy()
    {
        if(lazy == null) {System.out.println("List Is Empty: []");return;}
        System.out.print("\nDeleted list (Lazy) : [ ");
        for(var element : lazy)
        {
            System.out.print(element.data + " ");
        }
        System.out.print("]\n");

    }
    
    /**
     * Prints the data of all the nodes in the list
     */
    public void print()
    {
        if(head == null) {System.out.println("List Is Empty\n[]");return;}//throw new IllegalStateException("List Is Empty");}
        System.out.println("\nvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        System.out.println("Head data ==> " + head.data);
        System.out.println("Tail data ==> " + tail.data);
        
        
        System.out.println("\nFrom Head to Tail");
        System.out.print("[ ");
        for(Node<E> node = head; node!=null; node = node.next)  System.out.print(node.data + " ");
        System.out.print("]");
        

        System.out.println("\nFrom Tail to Head");
        System.out.print("[ ");
        for(Node<E> node = tail; node!=null; node = node.prev)  System.out.print(node.data + " ");
        System.out.print("]");
        
        System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");


    }

    
    /**
     * Return the element at the specified index
     * 
     * @param index The index of the element to retrieve.
     * @return The data field of the node at the specified index.
     */
    public E get(int index) 
    {
        if(checkIndex(index)) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return nodeAt(index).data;
    }

    /**
     * Set the element at the specified index to the specified value
     * 
     * @param index The index of the node to be removed.
     * @param newData The new data to be inserted into the list.
     * @return Nothing.
     */
    public E set(int index, E newData) 
    {
        if(checkIndex(index)) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        
        Node<E> temp = nodeAt(index);
        E previousData = temp.data;
        temp.data = newData;
        
        return previousData;
    }

    /**
     * Return the index of the first occurrence of the specified element in this list, or -1 if this
     * list does not contain the element.
     * 
     * @param obj The object to search for.
     * @return The index of the object in the list.
     */
    public int indexOf(Object obj) 
    {
        int index = 0;
        if(obj == head.data) return index;
        if(obj == tail.data) return size-1;
        for (Node<E> temp = head; temp != null; temp = temp.next, index++) if (obj == temp.data) return index;
        return -1;
    }

    
    /**
     * Add a new node to the beginning of the list
     * 
     * @param newData The data to be added to the list.
     */
    public void addFirst(E newData) 
    {
        Node<E> newNode = takeFromLazy();
        if(newNode == null) {newNode = new Node<E>(newData);}
        newNode.data = newData;
        if(head == null)
        {
            head = newNode;
            tail = newNode;
            newNode.prev = null;
            newNode.next = null;
            size++;
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            newNode.prev = null;
            size++;
        }   
    }
    
    /**
     * Add a new node to the end of the list
     * 
     * @param newData The data to be added to the list.
     */
    public void addLast(E newData) 
    {
        Node<E> newNode = takeFromLazy();
        if(newNode == null) newNode = new Node<E>(newData);
        newNode.data = newData;

        if(tail == null)
        {
            head = newNode;
            tail = newNode;
            newNode.prev = null;
            newNode.next = null;
            size++;
        }
        else
        {
            newNode.prev = tail;
            tail.next = newNode; 
            tail = newNode;
            newNode.next = null;
            size++;
        }
    }

    /**
     * Add a new element at the specified index
     * 
     * @param index The index of the node to be removed.
     * @param newData The data to be added to the list.
     */
    public void add(int index, E newData) 
    {
        if(checkIndex(index)) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index == size) addLast(newData);
        else if (index == 0) addFirst(newData);
        else
        {
            Node<E> temp = nodeAt(index);
            
            Node<E> newNode = takeFromLazy();
            if(newNode == null) newNode =  new Node<E>(newData);
            newNode.data = newData;
            
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
            size++;
        }
    }
    
    /**
     * Add the newData to the end of the list
     * 
     * @param newData the data to be added to the list.
     * @return The return value is true if the add operation is successful.
     */
    public boolean add(E newData) {addLast(newData); return true;}

    
    /**
     * Return the first element of the list
     * 
     * @return The data in the first node.
     */
    public E getFirst() 
    {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }
    
    /**
     * Return the last element of the list
     * 
     * @return The last element in the list.
     */
    public E getLast() 
    {
        if (tail == null) throw new NoSuchElementException();
        return tail.data;
    }
    
    
    /**
     * Remove the first element of the list.
     * 
     * @return The element that was removed.
     */
    public E removeFirst()
    {
        if (head == null) throw new NoSuchElementException();
        return remove(0);
    }
    
    /**
     * Remove the last element from the list.
     * 
     * @return The element that was removed.
     */
    public E removeLast() 
    {
        if (tail == null) throw new NoSuchElementException();
        return remove(size);
    }
    
    /**
     * If the object is in the list, remove it
     * 
     * @param obj The object to be removed from the list.
     * @return Nothing.
     */
    public boolean remove(Object obj) 
    {
        for (Node<E> temp = head; temp != null; temp = temp.next) 
        {
            if (obj == temp.data) 
            {
                if(temp == head)
                {
                    head = temp.next;
                    if(size!=1) temp.next.prev = null;
                } 
                else if (temp == tail)
                {
                    tail = temp.prev;
                    if(size!=1) temp.prev.next = null;
                }
                else
                {
                    if(temp != null && temp.prev != null) 
                            temp.prev.next = temp.next;
                    if(temp != null && temp.next != null)
                            temp.next.prev = temp.prev;
                }
                size--;
                temp.prev = null;
                temp.next = null;
                addToLazy(temp);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Remove the element at the specified index and return the removed element
     * 
     * @param index The index of the element to be removed.
     * @return The data that was removed.
     */
    public E remove(int index) 
    {
        if(checkIndex(index)) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Node<E> temp = nodeAt(index);

        if(index == 0)
        {
            head = temp.next;
            if(size!=1) temp.next.prev = null;
        } 
        else if (index == size-1)
        {
            tail = temp.prev;
            if(size!=1) temp.prev.next = null;
        }
        else
        {
            if(temp != null && temp.prev != null) 
                    temp.prev.next = temp.next;
            if(temp != null && temp.next != null )
                    temp.next.prev = temp.prev;
        } 
        size--;
        E newData = temp.data;
        temp.prev = null;
        temp.next = null;
        addToLazy(temp);
        return newData;
    }

    
    /**
     * Returns true if the array contains the specified element
     * 
     * @param obj The object to search for.
     * @return The index of the object in the list.
     */
    public boolean contains(Object obj) {return indexOf(obj) >= 0;}
    
    /**
     * Return the number of elements in the list
     * 
     * @return The size of the list.
     */
    public int size() {return size;}

    /**
     * This class implements the Iterator interface and provides a way to iterate through the linked
     * list
     */
    private class LDListIterator implements Iterator<E>
    {
        // Initializing the current node to the head node.
        private Node <E> current; 

        // This is the constructor of the iterator. It initializes the current node to the head node.
        public LDListIterator() {current = head;}

        /**
         * Return true if there is a next element in the iteration
         * 
         * @return The hasNext() method returns a boolean value.
         */
        public boolean hasNext() {return current != null;}

        /**
         * Return the next element in the iteration
         * 
         * @return The data in the current node.
         */
        public E next() 
        {
            if (!hasNext()) throw new NoSuchElementException("Size: " + size());
            
            E data = current.data;
            current = current.next;

            return data;
        }
    }

}
