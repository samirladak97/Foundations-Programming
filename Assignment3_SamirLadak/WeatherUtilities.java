import java.util.Scanner;
public class WeatherUtilities{
  
  //method to count good days without calling methods from WeatherEntry
  public static int countGoodDays(double [] temperatures, boolean[] sunny){
    if (temperatures.length != sunny.length){
      throw new IllegalArgumentException("The length of the input arrays is not the same");
    }
    int goodDays = 0;
    for (int i=0; i<temperatures.length; i++){
      if ((temperatures[i] > (-30)) && (sunny[i] ==true)){
        goodDays++;
      }
    }
    return goodDays;
  }
  
  //method to count good days by calling method from WeatherEntry
  public static int countGoodDays(WeatherEntry[] weather){
    int goodDays = 0;
    for (int i=0; i<weather.length; i++){
      if (weather[i].isGoodWeather() == true){
        goodDays++;
      }  
    }
    
    return goodDays;
  }
  
  //main method to determine max temp, min temp, and number of good days
  public static void main(String[] args){
    int n = Integer.parseInt(args[0]);
    WeatherEntry[] weather = new WeatherEntry[n];
    Scanner temperature = new Scanner(System.in);
    Scanner sunYesNo = new Scanner(System.in);
    //set temp high to a temperature that is too low to be a max and vise versa with temp low
    int tempHigh = -100;
    int tempLow = 100;
    int nicedays = 0;
    //loop for scanner
    for (int i=0; i<n; i++){
      System.out.println("What was the temperature on day " + (i+1) + "?");
      int degrees = temperature.nextInt();
      System.out.println("Was it sunny on day " + (i+1) + "? : Enter 1 for yes and 2 for no");
      int sun = sunYesNo.nextInt();
      //if statements to count up good days and change max and min temps as they change through the scanner
      if (sun == 1){
        boolean b = true;
        weather[i] = new WeatherEntry((double)degrees, b);
      }
      else{
        boolean b = false;
        weather[i] = new WeatherEntry((double)degrees, b);
      }
      if (degrees > tempHigh){
        tempHigh = degrees;
      }
      if (degrees < tempLow){
        tempLow = degrees;
      }
      //put values into isGoodDay method to determine number of good days
      if (weather[i].isGoodWeather() == true){
        nicedays++;
      }
    }
    System.out.println("There were " + nicedays + " nice days");
    System.out.println("The highest temperature was " + tempHigh + " degrees Celsius and the lowest was " + tempLow);
  }
  
}