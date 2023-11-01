import java.util.*;


public class MyArrayList <T> implements Iterable <T> {

int size;

  T[] a;




  public MyArrayList(){

    a = (T[]) new Object[5];
    size = 0;

  }

public boolean add (T t){

    try{
      if(size == a.length - 1 ){

      T [] a2 = (T[]) new Object[ 2 * a.length];

       for(int i = 0; i < a.length; i++){

         a2[i] = a[i];

       }
        a = a2;
      }

      a[size++] = t;
    }
    catch(Exception e){
      return false;
    }

    return  true;
  }



public void add (int index, T t){

    a[index] = t;


      }



  public boolean contains (T t){
     for(int i = 0; i < a.length; i++){

       if(a[i] == t ){

          return true;
   }

 }

              return false;

  }


  public T get(int index){

      if (a[index] != null){

           return a[index];
    }

                 else{

                    return null;
                  }
  }



  public int indexOf(T t){

    for(int i = 0; i < a.length ; i++ ){

      if(a[i] == t){

        return i;
      }


    }
 return -1;
  }



public T Remove (int index){

T n = a[index];
for(int i = index; i < a.length -1; i++ ){

  a[i]=a[i+1];}

return n;
}



public boolean remove(T t){

 int c = indexOf(t);

if ( c > 0 &&  c < a.length -1){


  T b = Remove(c);

   return true;


}
 return false;
}







public int removeAll(T t){
  int count=0;

for(int i = 0; i < a.length ; i++ ){
  while(a[i]==t){
    T b = Remove(i);
    count++;

  }
}return count;
    }







public T set(int index, T t){
    T p =a[index];

    add(index,t);

  return p;
}




public boolean isEmpty(){
  if(size==0){
     return true;
  }else
  return false;
}



public int size(){
  return size;
}



public Iterator<T> iterator()
{
  return new Iterator<T>()
  {
    int index=0;
    public boolean hasNext(){
      return index<size;


    }

    public T next(){
      return a[index++];
    }
  };


}






public void clear(){
for(int i=0;i<size;i++){
  a[i]=null;

}
size=0;

}



public String toString(){
   Iterator s = this.iterator();

 String b = "[";

 while(s.hasNext()){

 b += " " + s.next();
 }


 return b + "]";

}





  public static void main (String[] args){

  MyArrayList <Integer>list =new MyArrayList <Integer>();
  //list.add(2);
  //list.add(4);
  //list.add(3);
  //list.add(3);




  //list.add(0,10);
//  System.out.println(list.Remove(0));
//System.out.println(list.size());
//System.out.println(list.isEmpty());
//System.out.println(list.removeAll(3));
//list.clear();
//System.out.println(list.toString());

}

}
