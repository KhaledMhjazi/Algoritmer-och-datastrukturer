import java.awt.*;
import java.util.*;
import java.io.*;

public class Graph {
    private int V;
    private int E;

    //List of all the nodes
   static ArrayList<Node> nodes = new ArrayList<>();

    //List of the visiting nodes
    public ArrayList<Integer> visiting = new ArrayList<>();

    public LinkedList<Integer>[] adj;

    ArrayList<Integer> vist = new ArrayList<>();

    public Graph(int V) {
        this.V = V;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }


    public void addEdge(int v, int w) {
        if (v < 0 || v >= V || w < 0 || w >= V) {
            throw new IndexOutOfBoundsException("No such node!");
        }

        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


    public void drawGraph(ArrayList<Node> antennas) {

        StdDraw.setPenColor(Color.black);



        for (Node a : antennas) {

            StdDraw.circle(a.getX(), a.getY(), a.getR());
        }


    }

    public int getV() {
        return V;
    }



   // b) Man ska kunna ta reda på om två noder är sammankopplade (connected).
//    System.out.println(connected(antennas, graph, 0, 1));

    static ArrayList<Node> fromFile(String fileName) {

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                scanner.next();
                int id = scanner.nextInt();
                scanner.next();
                int x = scanner.nextInt();
                scanner.next();
                int y = scanner.nextInt();
                scanner.next();
                int r = scanner.nextInt();
                Node node1 = new Node(x, y, r, id);
                nodes.add(id, node1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return nodes;
    }

    static Graph getGraph(ArrayList<Node> nodes) {

        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 1000);
        StdDraw.setPenRadius(0.001);

        int V = nodes.size();
        Graph graph = new Graph(V);
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (i != j && overlap(nodes.get(i), nodes.get(j))) {
                    graph.addEdge(i, j);
                    StdDraw.setPenColor(Color.BLUE);
                    StdDraw.line(nodes.get(i).getX(),nodes.get(i).getY(),nodes.get(j).getX(),nodes.get(j).getY());
                }
        return graph;
    }

    static boolean overlap(Node a1, Node a2) {
        return (distance(a1, a2) < ((double) (a1.getR() + a2.getR())));
    }

    static double distance(Node a1, Node a2) {
        double ret = (a1.getX() - a2.getX()) * (a1.getX() - a2.getX());
        ret += (a1.getY() - a2.getY()) * (a1.getY() - a2.getY());
        ret = Math.sqrt(ret);
        return ret;
    }



    //This method is used as a recursive helper method to recursively call itself
    //until found all the possible nodes
    private void dfsHelper(int v, boolean[] visited) {
        //Met a new node
        visited[v] = true;

        //List to store visited
        visiting.add(v);


        //Going through the node-ids in the adj list
        for (int n : adj[v]) {
            if (!visited[n]){
                dfsHelper(n, visited);
            }
        }
    }


    public void dfs(int v) {
        //Declaring a visiting boolean-array
        boolean[] visited = new boolean[V];

        //Start recursive method
        dfsHelper(v, visited);
    }

    //Returning if two circle is in the same network
    public boolean twoCircleConnected(Node c1, Node c2){
        visiting.clear();
        dfs(c1.id);
        return visiting.contains(c2.id);
    }

    //Counts the amount of networks on the map
    public int networkCounter(){
        int amountN = 0;
        Map<Integer, Boolean> hm = new HashMap<>();

        //Going through the nodes
        for(Node b : nodes){


            //If contains skip that node
            if (hm.containsKey(b.id)){
                continue;
            }

            //Reset networks list
            visiting.clear();
            dfs(b.id);

            //If not contains in hm
            if(visiting.size()>1){

                //Put whole network in the hm
                for(Integer a : visiting){
                    hm.put(a,true);
                }

                visiting.clear();
                amountN++;
            }
        }
        visiting.clear();
        return amountN;
    }

    public int longestDistansInNetwork(Node cir){
        int longdistance = 0;
        int distand;
        int dist = (int) (Math.sqrt(Math.pow(cir.x,2)+Math.pow(cir.y,2)));

        visiting.clear();
        dfs(cir.id);

        for(Integer id: visiting){
            distand = (int) (Math.sqrt((Math.pow(nodes.get(id).x,2)+Math.pow(nodes.get(id).y,2)))-dist);
            if(longdistance < Math.abs(distand)){
                longdistance = Math.abs(distand);
            }
        }

        return longdistance;
    }

    public LinkedList<Integer> shortestPath (Node c1, Node c2)
    {
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        //Assigning -1 to each position in the array
        int[] prev = Arrays.stream(new int[V]).map(p -> p = -1).toArray();

        //Checking the nodes are the same
        if (c1 == c2) return path;

        //Adding node to queue
        queue.add(c1.id);

        //Going through the list
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            //Going through adjacent list
            for (int n : adj[curr]) {

                //Havn't visited node
                if (prev[n] == -1) {

                    //Store the previous value in vertex
                    prev[n] = curr;

                    //Finds the node we searching for
                    if (n == c2.id) {

                        //Building the path
                        while (n != c1.id) {
                            path.addFirst(n);
                            n = prev[n];
                        }

                        return path;
                    }
                    queue.add(n);
                }
            }
        }
        return path;
    }

    //Returning the length of the path
    public int shortestPathLength (Node c1, Node c2){
        LinkedList<Integer> path = shortestPath(c1, c2);
        int removeAmount = 0;
        if (path != null) {
            for (Integer a : path) {
                if (a == c1.id) {
                    removeAmount++;
                }
            }
            return shortestPath(c1, c2).size() - removeAmount;
        }
        return 0;
    }





    public static void main(String[] cmdLn) {
        Graph g = new Graph(Graph.nodes.size());

        StdDraw.show();

        ArrayList<Node> node = fromFile("./src/karta1.txt");

        String home = System.getProperty("user.home");

        System.out.println(home);
        Graph graph = getGraph(node);
       



        graph.drawGraph(node);



    }


}

