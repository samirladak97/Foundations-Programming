import java.util.Scanner;
import java.io.*;
public class ImageFileUtilities{
  
  //method to read the Image 
  public static Image read(String filename) throws IOException{
      Scanner reader = new Scanner(new File(filename));
      String pictureFormat = reader.nextLine();
      String comment = reader.nextLine();
      while (reader.hasNext("#")){
        comment = comment + reader.nextLine();
      }
      int width = reader.nextInt();
      int height = reader.nextInt();
      int rangeMax = reader.nextInt();
      Pixel[][] picInfo = new Pixel[height][width];
      Image picture = new Image(comment, rangeMax, picInfo);
      if (pictureFormat == "P2"){
        for (int i=0; i < height; i++){
          for (int j=0; j < width; j++){
            int x = reader.nextInt();
            picInfo[i][j] = new Pixel(x);
          }
        }
      }
      else if (pictureFormat == "P3"){
        for (int i=0; i < height; i++){
          for (int j=0; j < width; j++){
            int red = reader.nextInt();
            int green = reader.nextInt();
            int blue = reader.nextInt();
            picInfo[i][j] = new Pixel(red, green, blue);
          }
        }
      }
      else{
        throw new FileNotFoundException("Wrong file format");
      }
  return picture;
  }

  //method to write a new picture of type pnm
  public static void writePnm(Image picture, String filename) throws IOException{
    FileWriter fw = new FileWriter(filename);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("P3");
    bw.newLine();
    bw.write("# this is a P3 file written using input of type Image called " + filename);
    bw.newLine();
    bw.write("#" + picture.getMetadata());
    bw.write(picture.getWidth() + " " + picture.getHeight());
    bw.newLine();
    bw.write(picture.getMaxRange());
    bw.newLine();
    for (int i = 0; i < picture.getHeight(); i++) {
      for (int j = 0; j < picture.getWidth(); j++) {
        bw.write(picture.getPixel(i, j) + " "); 
      }
      bw.newLine();
    }
    bw.close();
    fw.close();
  }
  
  //method to write a new picture of type pgm
  public static void writePgm(Image picture, String filename) throws IOException{
    FileWriter fw = new FileWriter(filename);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.write("P2");
    bw.newLine();
    bw.write("# this is a P2 file written using input of type Image called " + filename);
    bw.newLine();
    bw.write("#" + picture.getMaxRange());
    Pixel[][] turnGrey = new Pixel[picture.getHeight()][picture.getWidth()];
    for (int i=0; i < turnGrey.length; i++){
      for (int j=0; j < turnGrey[i].length; j++){
        turnGrey[i][j] = picture.getPixel(i, j);
      }
    }
    //create new image using turnGrey as Pixel array then use method from Image class to turn turnGrey into a grey Pixel[][]
    Image newPic = new Image(picture.getMetadata(), picture.getMaxRange(), turnGrey);
    newPic.toGrey();
    for (int i=0; i < turnGrey.length; i++){
      for (int j=0; j < turnGrey[i].length; j++){
        bw.write(turnGrey[i][j] + " ");
      }
      bw.newLine();
    }
    bw.close();
    fw.close();
  }
}