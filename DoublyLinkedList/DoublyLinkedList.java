import java.util.*;


public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T>{

         ListNode<T> head;
         ListNode<T> tail;
         int size;


        public DoublyLinkedList(){

          head = null;
          tail = null;

          size = 0;

                     }


    void add(T t){

   if(isEmpty()) {
      ListNode<T> newNode = new ListNode<T>(t, null,null);
      head = newNode;
      tail = newNode;


        }


         else {
        tail.next = new ListNode<T>(t, null,tail);
        tail = tail.next;
           }


        size++;




     }


     void add(int index,T t){
       if (index < 0 || index >= size)
               {
                   throw new IndexOutOfBoundsException(
                   "Vid add(int index, T t)   index är inte tillåtet");
               }

               if (index == 0)
           {

               head = new ListNode<T>(t, head,null);
               head.previous = head;
               size++;
               return;
           }

           ListNode<T> current = head;
           ListNode<T> prev = null;

         for (int i = 0; i < index - 1; i++){

           prev = current;
           current = current.next;}

         current.next = new ListNode<T>(t, current.next,prev);
         current.next.previous=current;
         size++;


      }


      T get(int index){
        if (isEmpty())
              return null;

        ListNode<T> current = head;

        for (int i = 0; i < index; i++){

        current = current.next;
        }


        return current.value;

      }


       T getFirst(){
         if (isEmpty())
               return null;

           return head.value;

       }


       T getLast(){

           if (isEmpty())
               return null;

           ListNode<T> node = head;

           while (node.next != null)
               node = node.next;


          return node.value;
         }



         int remove(T t){

        int s=0;

           if (isEmpty())
               return 0;

               ListNode<T> node = head;

               if(head == tail && head.value.equals(t)){
                 head=null;
                 size=0;
                 s++;

               }
               else {



       while (node != tail)
       {
           if (node.value.equals(t))
           {
               if (node == head)
               {
                   head = node.next;
                   head.previous = null;
                   size--;
                   s++;



               }

              else
              { node.previous.next = node.next;


               size--;
               s++;


               }



           }

           if (node.value.equals(t)){
             node.next.previous = node.previous;




           }




           node = node.next;

       }




    if (node == tail && tail.value.equals(t)) {

    T a = removeLast();



         s++;



          }



       }

      return s;

   }






             T remove(int index){

            if (isEmpty())
                        return null;

                        if (index < 0 || index >= size)
                 {
                     throw new IndexOutOfBoundsException(
                     "Vid add(int index, T t)  index är inte tillåtet!");
                 }

         if(index==0){
             T b = head.value;
           head = head.next;
           head.next.previous=null;
           size--;
         return b ;
         }

         ListNode<T> n1 = head;
         ListNode<T> n2 = head.next;

         for (int i = 0; i < index; i++){
         n1=n2;
         n2=n2.next;}

         n1.next = n2.next;
         n2.next.previous=n1;
         size --;

         return n2.value ;


         }



    public T removeFirst(){

        if(isEmpty()){
            return null;
            }

     ListNode<T> tmp = head;

      if(head == tail){
        head = null;
        size = 0;
      }

      else{

        head = head.next;
        head.previous = null;
        size--;}
        return tmp.value;
    }


    public T removeLast(){

            if(isEmpty()) {
                return null;
            }


             T temp = tail.value;

             if (head == tail){

             head = null;
             size = 0;

           }

           else{


            tail.previous.next = null;
            tail = tail.previous;

            size--;
          }
            return temp;

        }


    boolean isEmpty(){
          return size==0;
        }




        int size(){
          return size;}


          void clear(){

            head = null;
            size = 0;
          }









    public Iterator<T> iterator(){

            return new Iterator<T>()
            {
                ListNode<T> node = head;
                public boolean hasNext()
                {
                    return node != null;
                }

                public T next()
                {  //throw new NoSuchElementException();
                    ListNode<T> tmpNode = node;
                    node = node.next;
                    return tmpNode.value;
                }
            };
        }


        public String toString()  {
                  String s = "(";
                  for (T t : this)
                  {
                      s += t + ", ";
                  }

                  if (!isEmpty())
                      s = s.substring(0,s.length()-2);
                  s += ")";
                  return s;
              }


      public void reverse(){

        MyStack <T> s = new MyStack <T>();

       for (T t : this){

           s.push(t)  ;

           int p = remove(t);

}
        while(!s.isEmpty()){
          T l = s.pop();

              add(l);}
}




       public void addAtFirstSmaller(T t){

         ListNode<T> n = new ListNode(t,null,tail);
       ListNode<T> current = tail;

           if (isEmpty()){

            add(t);

           }


             while (n.previous!=null){






               if (current.value.compareTo(t) < 0){

               ListNode<T> newNode = new ListNode(t,current.next,current);
               current.next = newNode;
               if (newNode.next != null)
                    newNode.next.previous = newNode;
                else{

                  tail = newNode;

                }


               size++;
               break;



          }


           else{
             if (current.value.compareTo(t) > 0 && head==tail){

                  head = new ListNode(t,head,null);
                  current.previous = head;


                  size++;




            }




    else{


             if (current.value.compareTo(t) > 0 && current.previous==null){

                  head = new ListNode(t,current, null);
                  current.previous= head;


                  size++;




            }
}




            }

             n = current;
            current = current.previous;



            }





                   }





    public static void main(String[] cmdLn)
    {

      DoublyLinkedList <Integer> lista = new DoublyLinkedList<Integer>();


      int[]a = {33,7,9,15,2,30,25,44,5,11,3,87,77,8,6,78,86,4,55};



 for(int t : a){





          lista.addAtFirstSmaller(t);}

              System.out.println(Arrays.toString(a));
              System.out.println(lista);

              for(int i =0 ; i < lista.size() ; i++){

                  a[i] =lista.get(i);

              }

              for (int t : a){
                          System.out.print(t + ", ");
}



//             System.out.println(lista);
//                 lista.add(2,500);
//
// //System.out.println(lista.remove(1));
//
//                 System.out.println(lista);




                //lista.clear();
                //lista.remove(1);

              //  System.out.println(lista);
            }


}
