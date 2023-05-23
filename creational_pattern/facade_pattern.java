package creational_pattern;

import java.util.Scanner;

interface shape{
    public void draw();
}

class circle implements shape{

    @Override
    public void draw() {
        System.out.println("circle");
    }
}

class rectangle implements shape{

    @Override
    public void draw() {
        System.out.println("rectangle");
    }
}

class square implements shape{

    @Override
    public void draw() {
        System.out.println("square");
    }
}

class shapemaker{
    circle c1 = new circle();
    rectangle r1 = new rectangle();
    square s1 = new square();

    public void shape_maker(String shape_name) {
          if(shape_name.equalsIgnoreCase("circle")){
              c1.draw();
          }
          else if(shape_name.equalsIgnoreCase("rectangle")){
              r1.draw();
          }
          else if(shape_name.equalsIgnoreCase("square")){
              s1.draw();
          }
          else{
              System.out.println("shape not available to draw");
          }
    }

//    public void drawcircle(){
//
//    }
//    public void drawsquare(){
//
//    }
//    public void drawrectangle(){
//
//    }
}

public class facade_pattern {
    public static void main(String[] args) {
        shapemaker sm1 = new shapemaker();
        Scanner sc = new Scanner(System.in);

        System.out.println("enter circle to draw circle,");
        System.out.println("square to draw square,");
        System.out.println("rectangle to draw rectangle: ");
        String shape = sc.nextLine();
        sm1.shape_maker(shape);

    }
}
