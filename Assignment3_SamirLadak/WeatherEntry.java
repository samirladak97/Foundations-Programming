
//class to create new type WeatherEntry
public class WeatherEntry{
  private double temperatureInCelsius;
  private boolean isSunny;
  
  //constructor method
  public WeatherEntry(double temperatureInCelsius, boolean isSunny){
    this.temperatureInCelsius = temperatureInCelsius;
    this.isSunny = isSunny;
  }

  //private method to convert from celsius to farenheit
  private double celsiusToFarenheit(){
    double temperatureInF = (temperatureInCelsius*1.8)+32;
    return temperatureInF;
  }
  //get temperature method
  public double getTemperatureCelsius(){
    return this.temperatureInCelsius;
  }
  
  //private set temperature method
  private void setTemperatureCelsius(double temperatureInCelcius){
    this.temperatureInCelsius = temperatureInCelsius;
  }
  
  //private set isSunny method
  private void setIsSunny(boolean isSunny){
    this.isSunny = isSunny;
  }
  
  //method to check if weather is good
  public boolean isGoodWeather(){
    boolean b = false;
    if (this.temperatureInCelsius > (-30) && (this.isSunny==true)){
      b = true;
    }
    return b;
  }
  
  //method to give temp in celsius or farenheit and print temp and if it is sunny 
  public void display(boolean isCelsius){
    if ((isCelsius == true) && (this.isSunny == true)){
      System.out.println("It is " + this.temperatureInCelsius + " degrees Celsius and it is Sunny");
    }
    else if ((isCelsius == true) && (this.isSunny == false)){
      System.out.println("It is " + this.temperatureInCelsius + " degrees Celsius and it is not Sunny");
    }
    else if ((isCelsius == false) && (isSunny == true)){
      System.out.println("It is " + this.celsiusToFarenheit() + " degrees Farenheit and it is Sunny");
    }
    else{
      System.out.println("It is " + this.celsiusToFarenheit() + " degrees Farenheit and it is not Sunny");
    }  
  }
  
  
}
  