import java.util.*;

public class MyStack<T extends Comparable<T>> implements Iterable<T>{

    DoublyLinkedList<T> d = null;


  public MyStack(){

    this. d = new DoublyLinkedList<T>();


     }

     boolean isEmpty(){


       return d.isEmpty();
     }



       T peek (){

         return d.getLast();

        }


        T pop (){

       T data= peek();

        T f = d.removeLast();



            return data;

        }


      void push(T t){

         d.add(t);
         System.out.println(t);

}


    public Iterator<T> iterator(){

          return d.iterator();

}

   public String toString(){
     return d.toString();
   }




public static void main(String[] cmdLn)  {

MyStack  s = new MyStack ();
s.push(10);
s.push(20);
s.push(30);
System.out.println(s);

System.out.println(s.pop());
System.out.println(s);

System.out.println(s.peek());
System.out.println(s);

System.out.println(s.pop());
System.out.println(s);

System.out.println(s.pop());
System.out.println(s);

System.out.println(s.isEmpty());

}
}
