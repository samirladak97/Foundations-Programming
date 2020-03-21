import java.util.Scanner;
import java.io.*;

//photoshop class
public class Comp202Photoshop{
  public static void main(String[] args){
    //kind exception that inputs are not valid
    if (args.length < 4){
      System.out.println("Not enough information to run photoshop picture");
      return;
    }
    String inputFile = args[0];
    String outputFile = args[1];
    String outputFormat = args[2];
    String operation = args[3];
    try{
      Image picture = ImageFileUtilities.read(inputFile);
      if (outputFormat == "pgm"){
        //horizontal flip
        if (operation == "-fh"){
          picture.flip(true);
        }
        //vertical flip
        else if (operation == "-fv"){
          picture.flip(false);
        }
        //grey scale
        else if (operation == "-gs"){
          picture.toGrey();
        }
        //crop
        else if (operation == "-cr"){
          int startX =Integer.parseInt(args[4]);
          int startY = Integer.parseInt(args[5]);
          int endX = Integer.parseInt(args[6]);
          int endY = Integer.parseInt(args[7]);
          if (args.length != 8){
            System.out.println("arguments to crop picture are invalid");
            return;
          }
          picture.crop(startX, startY, endX, endY);
        }
        ImageFileUtilities.writePgm(picture, outputFile);
      }
      else if (outputFormat == "pnm"){
        //horizontal flip
        if (operation == "-fh"){
          picture.flip(true);
        }
        //vertical flip
        else if (operation == "-fv"){
          picture.flip(false);
        }
        //grey scale
        else if (operation == "-gs"){
          picture.toGrey();
        }
        //crop
        else if (operation == "-cr"){
          int startX = Integer.parseInt(args[4]);
          int startY = Integer.parseInt(args[5]);
          int endX = Integer.parseInt(args[6]);
          int endY = Integer.parseInt(args[7]);
          picture.crop(startX, startY, endX, endY);
        }
        ImageFileUtilities.writePnm(picture, outputFile);
      }
        
    }
    catch(FileNotFoundException e){
      System.out.println("Could not find file");
    }
    catch(IOException f){
      System.out.println("Could not write new file");
    }
  }

}