public class Pixel{
  private int red;
  private int green;
  private int blue;
  
  //constructor method 1
  public Pixel(int red, int green, int blue){
    if ((red < 0) || (red > 255) || (green < 0) || (green > 255) || (blue < 0) || (blue > 255)){
      throw new IllegalArgumentException();
    }  
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  
  //constructor method 2
  public Pixel(int intensity){
    if ((intensity < 0) || (intensity > 255)){
      throw new IllegalArgumentException();
    }
    this.red = intensity;
    this.green = intensity;
    this.blue = intensity;
  }
  
  //get methods for each part of Pixel type
  
  public int getRed(){
    return this.red;
  }
  
  public int getGreen(){
    return this.green;
  }
  
  public int getBlue(){
    return this.blue;
  }
  
  //method to make a coloured "pixel" into grey scale
  public int grey(){
    double average = ((0.3*this.red)+(0.59*this.green)+(0.11*this.blue));
    return (int)average;
  }
}