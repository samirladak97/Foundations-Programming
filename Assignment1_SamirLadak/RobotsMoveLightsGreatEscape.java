import java.awt.Color;
import becker.robots.*;
public class RobotsMoveLightsGreatEscape {
  
  public static void main(String[] args) {
    Robot robot = makeCity();
   // Add your robot code for the great escape directly below here.
   robot.move();
   robot.move();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.pickThing();
   // The robot has picked up the first light
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.move();
   robot.turnLeft();
   robot.move();
   robot.pickThing();
   // The robot has picked up the second light
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.pickThing();
   // The robot has picked up the last light
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.turnLeft();
   robot.move();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.turnLeft();
   robot.move();
   robot.move();
   robot.move();
   // The robot is has escaped and willl do a victory dance WOOOOOO!!!!!
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();
   robot.turnLeft();  
  }

//Ignore everything in this method.
 public static Robot makeCity(){
  final int LIGHT_STREET = 1;
  final int LIGHT_AVENUE = 0;
  final int HEIGHT = 6;
  final int WIDTH = 4;
  
  City montreal = new City(12,12);

  Robot asimo = new Robot(montreal, LIGHT_STREET,
   LIGHT_AVENUE, Direction.EAST);

  //box
  for (int i = 0; i < WIDTH+1; i++) {
   new Wall(montreal, LIGHT_STREET, LIGHT_AVENUE + i,
    Direction.NORTH);
  }  
  for (int i = 0; i < WIDTH+1; i++) {
   new Wall(montreal, LIGHT_STREET+HEIGHT+1, LIGHT_AVENUE + i,
    Direction.SOUTH);
  }  
  for (int i = -1; i < HEIGHT+1; i++) {
   new Wall(montreal, LIGHT_STREET+i+1, LIGHT_AVENUE,
    Direction.WEST);
  }
  for (int i = -1; i < HEIGHT+1; i++) {
    if(LIGHT_STREET+i != 4)
      new Wall(montreal, LIGHT_STREET+i+1, LIGHT_AVENUE+4, Direction.EAST);
  } 
  
  //obstacles
  for (int i = -1; i < HEIGHT; i++) {
   new Wall(montreal, LIGHT_STREET+i+1, LIGHT_AVENUE+2,
    Direction.EAST);
  } 

  //obstacles
  new Wall(montreal, 3,3, Direction.SOUTH);
  new Wall(montreal, 2,3, Direction.EAST);
  new Wall(montreal, 1,3, Direction.SOUTH);
  new Wall(montreal, 1, 4, Direction.EAST);
  
  //tall middle wall
  for (int i = 2; i < HEIGHT; i++) {
   new Wall(montreal, LIGHT_STREET+i+1, LIGHT_AVENUE+1,
    Direction.EAST);
  }
  for (int i = 0; i < 2; i++) {
   new Wall(montreal, LIGHT_STREET+3, LIGHT_AVENUE + i,
    Direction.NORTH);
  }  

  int x2 = 1; int y2 = 3;

  new Flasher(montreal, x2, y2, true);
  new Flasher(montreal, 2, 3, true);
  new Flasher(montreal, 8, 0, true);
  return asimo;
 }
}
