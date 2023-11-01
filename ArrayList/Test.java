
import java.util.*;

public class Test{


public static<T extends Comparable<T>>MyArrayList<T>findMinMax(MyArrayList<T>list){

MyArrayList<T> pair = new MyArrayList<T>();


if(list.isEmpty())
return null;
pair.add(list.get(0));
pair.add(list.get(list.size()-1));

for( T t : list){
if(t.compareTo(pair.get(0)) < 0)
pair.set(0,t);
if(t.compareTo(pair.get(1))>0)
pair.set(1,t);
}
return pair;

}


public static<T> MyArrayList<T> findMinMax(MyArrayList<T> list, Comparator<T>c){
  MyArrayList<T> pair = new MyArrayList<T>();
  if(list.isEmpty())
  return null;
  pair.add(list.get(0));
  pair.add(list.get(list.size()-1));

  for ( T t : list){
  if(c.compare(t,pair.get(0)) < 0)
  pair.set(0,t);
  if(c.compare(t,pair.get(1))>0)
  pair.set(1,t);
  }
  return pair;
}

/*public static void main(String[] args) {

  MyArrayList<Land> list = new MyArrayList<Land>();
  Land Sweden = new Land(10000,"Stockholm","Sweden");
  Land  Germany = new Land ( 2000,"Berlin","Germany");
  Land Denmark = new Land( 900000,"Copenhagen","Denmark" );
  Land  Norway= new Land ( 8000,"Oslo","Norway");
  list.add(Sweden);
  list.add(Denmark);
  list.add(Germany);
  list.add(Norway);

  System.out.println(list.toString());

  System.out.println(findMinMax(list));

  System.out.println(findMinMax(list,new B()));

  System.out.println(findMinMax(list,new N ()));

    System.out.println(findMinMax(list,new C()));

}*/

}
