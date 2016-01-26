
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;


public class NewClass {
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.print("Please enter some text: ");
      String text = scanner.nextLine();
      text = text.toUpperCase();
      List<String> keysList = new ArrayList<String>((createMap(text)).keySet());
      Map<String, Integer> myMap = sortMapByValue(createMap(text), keysList);
      int counter = 0;
      int counterOfDs = 0;
      
    for (Map.Entry<String, Integer> entry : myMap.entrySet())
    {
        if(counter == 0){
           counterOfDs = 20 / entry.getValue();
        }
        System.out.print(keysList.get(counter) + ": " + entry.getValue());
        for(int i = 0; i < counterOfDs * entry.getValue(); i++){
            System.out.print(" #");
        }
        System.out.println();
        counter++;
    }
      
    }

    
    public static Map<String, Integer> createMap(String text){
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        
        for(int i = 0; i < text.length(); i++){
            int counter = 0;
            Boolean checkIfItIsLetter = false;
            for(int o = 0; o < text.length(); o++){
                if((text.charAt(i)) == text.charAt(o)){
                    if(text.charAt(i) > 64 && text.charAt(i) < 91){
                        counter++;
                        checkIfItIsLetter = true;
                    }
                }
            }
            if(!myMap.containsKey(Character.toString(text.charAt(i))) && checkIfItIsLetter){
                myMap.put(Character.toString(text.charAt(i)), counter);
            }
        }
        
        return myMap;
    }
    
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> myMap, List<String> keysList){
        Map<String, Integer> sortedMap = new HashMap<String, Integer>();
        
        int counter = 0;
        
        for(Map.Entry<String,Integer> entry : myMap.entrySet()){
            
            int temp = 0;
            String tempKey = "";
            int tempIndex = 0;
            
            for(Map.Entry<String, Integer> entry2 : myMap.entrySet()){
                if(entry.getValue() > entry2.getValue()){ 
                    temp = entry.getValue();
                    tempKey = keysList.get(counter);
                    
                    entry.setValue(entry2.getValue());
                    keysList.set(counter, keysList.get(tempIndex));
                    
                    entry2.setValue(temp);
                    keysList.set(tempIndex, tempKey);
                }
                 tempIndex++;
            }
            
            counter++;
        }
        
        List<Integer> check = new ArrayList<Integer>(myMap.values());
        List<String> subList = new ArrayList<String>();
        List<String> keysList2 = new ArrayList<String>();
        
        for(int i = 1; i < check.size(); i++){
            
            int previous = check.get(i - 1);
            int current = check.get(i);
            
            subList.add(keysList.get(i - 1));
            
            if(previous != current){
                Collections.sort(subList);
                for(int o = 0; o < subList.size(); o++){
                    keysList2.add(subList.get(o));
                }
                subList.clear();
            }
            
            if(i == check.size() - 1){
                subList.add(keysList.get(i));
                Collections.sort(subList);
                for(int o = 0; o < subList.size(); o++){
                    keysList2.add(subList.get(o));
                }
            }
        }
        
        for(int p = 0; p < keysList2.size(); p++){
            keysList.set(p, keysList2.get(p));
        }
        
        sortedMap = myMap;
        
        return sortedMap;
    }

}
