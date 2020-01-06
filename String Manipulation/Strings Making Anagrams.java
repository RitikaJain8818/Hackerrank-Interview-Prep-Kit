import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<a.length();i++){
            if(map.containsKey(a.charAt(i))){
                map.put(a.charAt(i),map.get(a.charAt(i))+1);
            }else{
                map.put(a.charAt(i),1);
            }
        }
        int count=0;
        for(int i=0;i<b.length();i++){
            if(map.containsKey(b.charAt(i))&&map.get(b.charAt(i))>=1){
                map.put(b.charAt(i),map.get(b.charAt(i))-1);
            }else{
                count++;
            }
        }
        for(Map.Entry entry:map.entrySet()){
            int v=(int)entry.getValue();
            if(v!=0){
                count+=v;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
