public class Node {
     int x;
     int y;
     int r;
     int id;

    public Node(int x, int y, int r, int id) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.id = id;  //node id

    }

    public int getR() {
        return r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
