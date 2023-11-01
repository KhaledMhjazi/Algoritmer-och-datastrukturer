import java.util.*;


public class Land implements Comparable<Land>{

 String name;
 String capital ;
  int numbers;

public Land(int numbers,String capital,String name )
{
this.numbers = numbers;
this.name = name;
this.capital = capital;

}

public String toString(){

return  numbers +" " + capital +" "+ name +" ,";

}

public int compareTo(Land l){

if(numbers <l.numbers)
return -1;

if(numbers > l.numbers)
return 1;

return 0;


}

/*public static void main (String []args){

  Land l = new Land (20000,"Svergie","Stockholm" );
  Land l1 = new Land (50000,"Norge","Oslo" );

   System.out.println(l1.compareTo(l));
   System.out.println(l1.toString());
   System.out.println(l.toString());




}*/


}

class B implements Comparator <Land>{

  public int compare(Land l1, Land l2){


  return  ((String)l1.name).compareTo(l2.name);



  }


}
class N implements Comparator <Land>{

  public int compare(Land l1,Land l2){


     return ((Integer)l1.numbers).compareTo (l2.numbers);



  }


}



class C implements Comparator <Land>{

  public int compare(Land l1, Land l2){


     return ((String)l1.capital).compareTo(l2.capital);



  }



  }
