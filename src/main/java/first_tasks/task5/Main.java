package first_tasks.task5;

import first_tasks.task1.Circle;
import first_tasks.task1.Rectangle;
import first_tasks.task1.Shape;
import first_tasks.task3.Color;
import first_tasks.task6.Canvas;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(4, Color.BLUE);
        Rectangle rectangle1 = new Rectangle(3, 2, Color.RED);
        Circle circle2 = new Circle(5, Color.RED);
        Rectangle rectangle2 = new Rectangle(4, 3, Color.BLUE);
        Circle circle3 = new Circle(6, Color.BLUE);
        Rectangle rectangle3 = new Rectangle(5, 4, Color.GREEN);


        List<Shape> shapeList = new ArrayList<>(
                Arrays.asList(circle1, circle2, circle3, rectangle1, rectangle2, rectangle3)
        );

//        System.out.println(getCircles(shapeList));
//        System.out.println(getSumArea(shapeList));
//        getShapesWithColor(shapeList, Color.BLUE);

//        Optional<Shape> maxAreaShape = getMaxArea(shapeList);
//        System.out.println(maxAreaShape);

        Map<Color, List<Shape>> colorListMap = new HashMap<>();
        colorListMap.put(Color.BLUE, getShapesWithColor(shapeList, Color.BLUE));
        colorListMap.put(Color.RED, getShapesWithColor(shapeList, Color.RED));
        colorListMap.put(Color.GREEN, getShapesWithColor(shapeList, Color.GREEN));

        for(Color color: colorListMap.keySet()){
            System.out.println(colorListMap.get(color));
        }



    }

    public static List<Shape> getCircles(List<Shape> shapes){
        return shapes.stream()
                .filter(s -> s instanceof Circle)
                .toList();
    }

    public static double getSumArea(List<Shape> shapes){
        return shapes.stream()
                .mapToDouble(Shape::getArea)
                .sum();
    }

    public static List<Shape> getShapesWithColor(List<Shape> shapes, Color color){
        return shapes.stream()
                .filter(shape -> shape.getColor().equals(color))
                .toList();
    }

    public static Optional<Shape> getMaxArea(List<Shape> shapes){
        return shapes.stream()
                .max(Comparator.comparingDouble(Shape::getArea));
    }
}
