public class RaceTrack {
  public static void main(String[] args){
    //asphalt is sold at $7.49 / square meter
    //args[0] is the large radius of the track
    //args[1] is the number of lanes
    //each lane is 2.8 meters wide
    //area of a circle is pir^2
    //10.5-2.8*2 = small radius that does not get paved =4.9meters
    double radius = Double.parseDouble(args[0]);
    int numLanes = Integer.parseInt(args[1]);
    double totArea = (Math.PI*radius*radius - Math.PI*(radius-numLanes*2.8)*(radius-numLanes*2.8));
    System.out.println("Total Area: " + totArea);
    double subtotal = ((totArea)*7.49);
    System.out.println("Subtotal: " + subtotal + "$");
    System.out.println("Sales Tax (15%): " + subtotal*0.15 + "$");
    double tax = (subtotal*0.15);
    double total = (Math.ceil(tax + subtotal));
    int finalTotal = (int)total;
    System.out.println("Total: " + finalTotal + "$");
  }
}