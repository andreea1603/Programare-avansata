public class Shape {
    int x;
    int y;
    int sides;
    int size;

    public Shape(int x, int y, int sides, int size) {
        this.x = x;
        this.y = y;
        this.sides = sides;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", sides=" + sides +
                ", size=" + size +
                '}';
    }

    public Shape(){

    }


}
