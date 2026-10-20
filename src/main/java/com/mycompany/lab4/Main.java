import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
         long startTime = System.nanoTime();
       
        long endTime = System.nanoTime();
        long elapsedTime = (endTime - startTime);
    
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);
      
      startTime = System.nanoTime();
      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(integerList);
      Lab4.outputList(bubbleSortedList);
      endTime = System.nanoTime();
      elapsedTime = endTime - startTime;
      System.out.println("\nTime: " + elapsedTime + " nanoseconds");
      
      startTime = System.nanoTime();
      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = Lab4.insertionSort(integerList);  
      Lab4.outputList(insertionSortedList);
      endTime = System.nanoTime();
      elapsedTime = endTime - startTime;
      System.out.println("\nTime: " + elapsedTime + " nanoseconds");
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here

    for (int i = 1; i < integerList.size(); i++){
        int temp = integerList.get(i);
        int k;
        for (k = i - 1; k >= 0 && integerList.get(k) > temp; k--){
            integerList.set(k+1, integerList.get(k));
        }
        integerList.set(k+1, temp);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    boolean keepGoing = true;
    for (int i = 1; i < integerList.size() && keepGoing; i++){
        keepGoing = false;
        for (int j = 0; j < integerList.size() - i; j++){
            if (integerList.get(j) > integerList.get(j+1)){
                int temp = integerList.get(j);
                integerList.set(j, integerList.get(j+1));
                integerList.set(j+1, temp);
                keepGoing = true;
            }
        }
    }
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}