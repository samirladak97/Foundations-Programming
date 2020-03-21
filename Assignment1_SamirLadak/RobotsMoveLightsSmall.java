import java.awt.Color;
import becker.robots.*;
public class RobotsMoveLightsSmall {
  
  public static void main(String[] args) {
   Robot robot = makeSmallCity();
   // Add your robot code for the small city directly below here.
   robot.move();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.move();
   robot.pickThing();
   // Light is picked up and now robot will perform victory dance
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   // The robot is free!!!!
  }
  
//Ignore everything in this method and below.
public static Robot makeSmallCity(){
  final int SIZE = 4;
  final int LIGHT_STREET = 1;
  final int LIGHT_AVENUE = 1;
  
  City ottawa = new City(12,12);
  
  //box
  for (int i = 0; i < SIZE-1; i++) {
   new Wall(ottawa, LIGHT_STREET, LIGHT_AVENUE + i,
    Direction.NORTH);
  } 
  
  for (int i = SIZE-1; i < SIZE+1; i++) {
   new Wall(ottawa, LIGHT_STREET+2, LIGHT_AVENUE + i,
    Direction.NORTH);
  }
  
  for (int i = 0; i < SIZE+1; i++) {
   new Wall(ottawa, LIGHT_STREET+SIZE, LIGHT_AVENUE + i,
    Direction.SOUTH);
  }  
  for (int i = -1; i < SIZE; i++) {
   new Wall(ottawa, LIGHT_STREET+i+1, LIGHT_AVENUE,
    Direction.WEST);
  }
  for (int i = -1; i < SIZE; i++) {
    if(LIGHT_STREET+i == 0 || LIGHT_STREET+i ==1)
      new Wall(ottawa, LIGHT_STREET+i+1, LIGHT_AVENUE+2, Direction.EAST);
    else if(LIGHT_STREET+i != 4)
      new Wall(ottawa, LIGHT_STREET+i+1, LIGHT_AVENUE+4, Direction.EAST);
  } 
  Robot asimo = new Robot(ottawa, LIGHT_STREET,
   LIGHT_AVENUE, Direction.EAST);
  new Flasher(ottawa, 4, 2, true);
  return asimo;
}

}