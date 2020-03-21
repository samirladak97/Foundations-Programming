public class BirthdayParadox{
  
  //method that takes input size and range, returns array of lenght size with random ints between 0 and range
  public static int[] generateArray(int size, int range){
    int[] a = new int[size];
    for (int i=0; i<size; i++){
      a[i] = ((int)(Math.random()*(range-1)));
    }
    return a;
  }
  
  //method to create create an array of size iterations with subarrays generates by generateArray method
  public static int[][] generateAllData(int iterations, int size, int range){
    int[][] b = new int[iterations][size];
    for (int i=0; i<iterations; i++){
      b[i] = generateArray(size, range);
    }
    return b;
  }
  
  //method to see how many times number element is found in a 2 dim array
  public static int countElement(int[][] b, int element){
    int sameNumber = 0;
    for (int i=0; i<b.length; i++){
      for (int j=0; j<b[i].length; j++){
        if (b[i][j] == element){
          sameNumber++;
        }
      }
    }
    return sameNumber;
  }
  
  //method that returns which element is most repeated in the 2 dim array
  public static int maxDay(int[][] d){
    int mode = 0;
    for (int element=0; element<365; element++){
      if ((countElement(d, element))>mode){
        mode = countElement(d, element);
      }
    }
    return mode;
  }
  
  //method to see if there are any duplicates in an array of ints
  public static boolean hasDuplicates(int[] c){
    boolean dup = false;
    for (int i=0;i<c.length; i++){
      for (int j=0; j<c.length; j++){
        // at j==i we already know the element is the same because it is the same array in the same spot
        if (j==i){
        continue;
        }
        else if (c[i] == c[j]){
          dup = true;
        }
      }
    }
  return dup;
  }
  
  //method that uses other methods to generate arrays returning the amount arrays that contain duplicate ints
  public static double runExperiment(int size){
    if (size<1){
      throw new IllegalArgumentException("size cannot be less than 1");
    }  
    int arraysWithDups = 0;
    int[][] b = generateAllData(200, size, 365);
    for (int i=0; i<200; i++){
      if ((hasDuplicates(b[i]))==true){
        arraysWithDups++;
      }
    }
    return (double)arraysWithDups/200;
  }
  
  //main method to print table of ratios of duplicate frequency using above methods
  public static void main(String[] args){
    for (int size=1; size<=100; size++){
      System.out.println(size + " " + runExperiment(size));
    }
  }
  
}