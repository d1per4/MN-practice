package first_tasks.task1;

import first_tasks.task2.Drawable;
import first_tasks.task3.Color;

public class Rectangle extends Shape implements Drawable, Comparable<Shape> {

    private double length;

    private double weight;

    private Color color;

    public Rectangle(double length, double weight, Color color){
        this.length = length;
        this.weight = weight;
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * weight;
    }

    @Override
    public double getPerimeter() {
        return (length + weight) * 2;
    }

    @Override
    public void draw() {
        System.out.println("Рисуем прямоугольник длиной " + length + " и высотой " + weight);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", weight=" + weight +
                ", color=" + color +
                '}';
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(getArea(), o.getArea());
    }
}
