import java.util.*;

public class ListNode<T>{

T value;

ListNode<T> next;
ListNode<T> previous;

public ListNode(T value){
  this .value = value ;
  this .next= null;
  this .previous=null;

}
public ListNode(T value, ListNode<T> next,ListNode<T> previous){

  this .value = value ;
  this .next= next;
  this .previous=previous;

}



}
