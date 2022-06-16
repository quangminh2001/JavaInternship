package lesson1.exampleinter;

public class Rectangle implements Shape {
    private int longs;
    private int width;

    public Rectangle(int longs, int width) {
        this.longs = longs;
        this.width = width;
    }

    @Override
    public double calculatePerimeter() {
        return longs * 2 + width * 2;
    }
}
