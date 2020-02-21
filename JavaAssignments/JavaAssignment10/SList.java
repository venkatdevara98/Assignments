/*
Generics, Arrays and Containers

Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.

Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).

Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.

The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 */
public class SList {
    int data;
    SList next;
    public void iterator(){
        SListIterator iterator=new SListIterator();
        iterator.addElement(2);
        iterator.addElement(3);
        iterator.addElement(4);
        iterator.addElement(5);
        iterator.iterate();
    }
    public static void main(String args[]){
        SList sList=new SList();
        sList.iterator();
    }
}
class SListIterator{
    SList start;
    public void iterate(){
        while(start!=null){
            System.out.println(start.data);
            start=start.next;
        }
    }
    public void addElement(int data){
        if(start==null){
            start=new SList();
            start.data=data;
            start.next=null;
        }
        else{
            SList finalNode=start;
            while(finalNode.next!=null){
                finalNode=finalNode.next;
            }
            SList newNode=new SList();
            newNode.data=data;
            newNode.next=null;
            finalNode.next=newNode;
        }
    }
}