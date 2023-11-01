import java.util.*;


public class LinearProbingHashSet<Key> {

    private int n; // number of saved elements
    private int m; //array size
    HashElement<Key> [] array;


    public LinearProbingHashSet(int m){
        this.m = m;
        this.n = 0;
        this.array = (HashElement<Key>[]) new HashElement[m];

    }

    public LinearProbingHashSet(){

        this(2);
    }

    private int hash(Key key) {

        return (key.hashCode() & 0x7fffffff) % m;
    }

    private int updateIndex(int i){

        return (++i)%m;
    }

    private double loadFactor() {

        return (double) n / m;
    }


    public void insert(Key key){
        if(loadFactor() >= 0.5){
            resize(2*m);
        }
        int i;
        for(i=hash(key); array[i]!=null; i=updateIndex(i)){
            if(array[i].getKey().equals(key)){
                array[i].increment();
                return;
            }
        }
        array[i] = new HashElement<Key>(key);
        n++;
    }

    public int getCapacity() {

        return m;
    }


    public HashElement<Key> get(Key key) {

        if (key == null)
            throw new IndexOutOfBoundsException("argument is null");


        for (int i = hash(key); array[i] != null; i = updateIndex(i)) {
            if (key.equals(array[i].getKey())) {
                return array[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {

        return get(key) != null;
    }


    void decrease(Key key){

        if (!contains(key))
            return;

        int i = hash(key);

        while (array[i] != null){
            if(key.equals(array[i].getKey())){
                array[i]. decrement();
            }
            if(array[i].getFrequencey()==0){
                delete(key);
            }

            i = updateIndex(i);
        }

    }





    private void resize(int newM)
    {
        LinearProbingHashSet<Key> temp = new LinearProbingHashSet<Key>(newM);
        for (int i = 0; i < m; i++)
        {
            if (array[i] != null)
            {
                temp.array[i] = new HashElement<Key>(array[i].getKey(), array[i].getFrequencey());
            }

        }
        this.array = temp.array;
        this.m = temp.m;
    }


    public void delete(Key key) {

        if (key == null)
            throw new IndexOutOfBoundsException("argument is null");

        if (!contains(key))
            return;

        int i;
        for (i = hash(key); !key.equals(array[i].getKey()); i = updateIndex(i));

            array[i] = null;
            i = updateIndex(i);
            n--;


            while (array[i] !=null ){


               Key temp =  array[i].getKey();
               int freq = array[i].getFrequencey();
                array[i] = null;
                n--;
                insert(temp,freq);
                i=updateIndex(i);

            }

        if (n > 0 && loadFactor() <= (double)1/8)
            resize(m/2);
        }


        private void insert(Key key, int counter){
        if (loadFactor()>=0.5)
            resize(2*m);

        int i;
        for( i = hash(key); array[i] != null; i = updateIndex(i));

        array[i]= new HashElement<Key>(key, counter);
        n++;
        }



    public Iterable<Key> keys()
    {

        Key[] b = (Key[]) new Object[n];
        MaxPQ<HashElement<Key>> q =
                new MaxPQ<HashElement<Key>>();

        for (int i = 0; i < m; i++)
        {
            if (array[i] != null)
                q.insert(array[i]);
        }

        for (int i = 0; i < n; i++)
        {
            b[i] = (q.delMax()).getKey();
        }

        return new Iterable<Key>()
        {
            public Iterator<Key> iterator()
            {
                return new Iterator<Key>()
                {
                    int index  = 0;

                    public boolean hasNext()
                    {
                        return index < b.length;
                    }

                    public Key next()
                    {
                        Key temp = b[index];
                        index++;
                        return temp;
                    }
                };
            }
        };
    }




    public static void main(String[] cmdLn)
    {

    }

}



