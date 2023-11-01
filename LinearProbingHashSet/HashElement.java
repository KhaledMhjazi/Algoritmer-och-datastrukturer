public class HashElement<Key> implements Comparable<HashElement<Key>>{


    public int m;
    public int n;

    Key key;


    public HashElement(Key key){

        this.key = key;
        n=1;

    }


    public HashElement(Key key,int counter){

        this.key = key;
        n= counter;


    }



    public void increment(){

        n = n+1;


    }

    public void decrement(){


        n = n-1;
    }




    public int getFrequencey(){


        return n;

    }




    public Key getKey(){
        return key;

    }




    void setKey(Key key) {

        this. key = key;

    }




    public int compareTo(HashElement that){

        if(this.n < that.n)
            return -1;

        if(this.n > that.n)
            return 1;

        return 0;
    }





}


