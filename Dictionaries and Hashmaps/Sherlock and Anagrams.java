import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                String ss=s.substring(i,j);
                if(map.containsKey(ss)){
                    map.put(ss,map.get(ss)+1);
                }else{
                    int count=0;
                    for(Map.Entry entry:map.entrySet()){
                        String p=(String)entry.getKey();
                        if(p.length()==ss.length()){
                            if(areAnagram(p.toCharArray(),ss.toCharArray())){
                                map.put(p,map.get(p)+1);
                                count++;
                                break;
                            }   
                        }
                        if(count==1)
                            break;
                    }
                    if(count==0)
                        map.put(ss,1);
                }
            }
        }
        System.out.println(map);
        int count=0;
        for(Map.Entry entry:map.entrySet()){
            int v=(int)entry.getValue();
            int t=(v*(v-1))/2;
            if(t>=0)
                count=count+t;
        }
        return count;
    }
    static boolean areAnagram(char str1[], char str2[]) 
    { 
        int NO_OF_CHARS = 256;
        // Create 2 count arrays and initialize 
        // all values as 0 
        int count1[] = new int[NO_OF_CHARS]; 
        Arrays.fill(count1, 0); 
        int count2[] = new int[NO_OF_CHARS]; 
        Arrays.fill(count2, 0); 
        int i; 
  
        // For each character in input strings, 
        // increment count in the corresponding 
        // count array 
        for (i = 0; i < str1.length && i < str2.length; 
             i++) { 
            count1[str1[i]]++; 
            count2[str2[i]]++; 
        } 
  
        // If both strings are of different length. 
        // Removing this condition will make the program 
        // fail for strings like "aaca" and "aca" 
        if (str1.length != str2.length) 
            return false; 
  
        // Compare count arrays 
        for (i = 0; i < NO_OF_CHARS; i++) 
            if (count1[i] != count2[i]) 
                return false; 
  
        return true; 
    } 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
