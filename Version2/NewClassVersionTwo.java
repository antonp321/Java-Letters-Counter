package SecondVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class NewClassVersionTwo {
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.print("Please enter some text: ");
      String text = scanner.nextLine();
      text = text.toUpperCase();
      HashMap<String, Integer> myMap = createMap(text);
      TreeMap<String, Integer> mySortedMap = SortByValue(myMap);
      List<String> sortedKeys = sortTheKeys(new ArrayList(mySortedMap.values()), new ArrayList(mySortedMap.keySet()));
      
      int counter = 0;
      int counterOfDs = 0;
      
    for (Map.Entry<String, Integer> entry : mySortedMap.entrySet())
    {
        if(counter == 0){
           counterOfDs = (int) Math.round(20.00 / entry.getValue());
        }
        System.out.print(sortedKeys.get(counter) + ": " + entry.getValue());
        for(int i = 0; i < counterOfDs * entry.getValue(); i++){
            System.out.print(" #");
        }
        System.out.println();
        counter++;
    }
      
    }

    
    public static HashMap<String, Integer> createMap(String text){
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        
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
    
    public static TreeMap<String, Integer> SortByValue (HashMap<String, Integer> map) {
		ValueComparator vc = new ValueComparator(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}
    
    public static List<String> sortTheKeys(List<Integer> mapValues, List<String> keysList){
        
        List<String> subList = new ArrayList<String>();
        List<String> keysList2 = new ArrayList<String>();
        
        for(int i = 1; i < mapValues.size(); i++){
            
            int previous = mapValues.get(i - 1);
            int current = mapValues.get(i);
            
            subList.add(keysList.get(i - 1));
            
            if(previous != current){
                Collections.sort(subList);
                for(int o = 0; o < subList.size(); o++){
                    keysList2.add(subList.get(o));
                }
                subList.clear();
            }
            
            if(i == mapValues.size() - 1){
                subList.add(keysList.get(i));
                Collections.sort(subList);
                for(int o = 0; o < subList.size(); o++){
                    keysList2.add(subList.get(o));
                }
            }
        }
        
        return keysList2;
    }

}
