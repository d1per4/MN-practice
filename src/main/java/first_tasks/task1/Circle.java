package first_tasks.task1;

import first_tasks.task2.Drawable;
import first_tasks.task3.Color;

public class Circle extends Shape implements Drawable, Comparable<Shape> {

    private double radius;

    private Color color;

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Circle(double radius, Color color){
        if(radius < 0){
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return 3.14 * (radius * radius);
    }

    @Override
    public double getPerimeter() {
       return 2 * 3.14 * radius;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем круг радиусом " + radius);
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color=" + color +
                '}';
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(getArea(), o.getArea());
    }
}
