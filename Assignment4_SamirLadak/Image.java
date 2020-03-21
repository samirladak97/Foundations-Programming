public class Image{
  private String metadata;
  private int maxRange;
  private Pixel[][] data;
  
  //constructor method
  public Image(String metadata, int maxRange, Pixel[][] data){
    if (maxRange < 0){
      throw new IllegalArgumentException();
    } 
    this.metadata = metadata;
    this.maxRange = maxRange;
    this.data = data;
    //create copy of original Pixel[][]
    Pixel[][] originaldata = new Pixel[this.data.length][this.data[0].length];
    for (int i=0; i < this.data.length; i++){
      for (int j=0; j < this.data[0].length; j++){
        originaldata[i][j] = this.data[i][j];
      }
    }
  }
  
  //get methods for each part of Image type
  
  public String getMetadata(){
    return this.metadata;
  }
  
  public int getMaxRange(){
    return this.maxRange;
  }
  
  public int getWidth(){
    int width = this.data[0].length;
    return width;
  }
  
  public int getHeight(){
    int height = this.data.length;
    return height;
  }
  
  public Pixel getPixel(int i, int j){
    return this.data[i][j];
  }
  
  //flip method
  public void flip(boolean horizontal){
    Pixel[][] dataflip = new Pixel[this.data.length][this.data[0].length];
    if (horizontal == true){
      for (int i=0; i < this.data.length; i++){
        for (int j=0; j < this.data[i].length; j++){
          dataflip[i][this.data[i].length-j-1] = this.data[i][j];
        }
      }
    }      
    else{
      for (int i=0; i < this.data.length; i++){
        for (int j=0; j < this.data[i].length; j++){
          dataflip[this.data.length-i-1][j] = this.data[i][j];
        }
      }
    }
    this.data = dataflip;
  }
  
  //grey scale method
  public void toGrey(){
    Pixel greyData[][] = new Pixel[this.data.length][this.data[0].length];
    for (int i = 0; i < this.data.length; i++){
      for (int j = 0; j < this.data[i].length; j++){
        greyData[i][j] = new Pixel(this.data[i][j].grey()); 
      }
    }
    this.data = greyData;
  } 
  
  //crop method
  public void crop(int startX, int startY, int endX, int endY){
    if ((startY>endY)||(startX>endX)||(startX<0)||(startY<0)||(startX>this.data[0].length)||(endX>this.data[0].length)||(startY>this.data.length)||(endY>this.data.length)){
      throw new IllegalArgumentException();
    }
    Pixel[][] cropped = new Pixel[endY-startY][endX-startX];
    for (int i = startY; i < endY; i++){
      for (int j = startX; j < endX; j++){
        cropped[i-startY][j-startX] = this.data[startY+i][startX+j];
      }
    }
    this.data = cropped;
  }
  
  
}