import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<ar.length;i++){
            if(map.containsKey(ar[i])){
                map.put(ar[i],(map.get(ar[i]))+1);
            }else{
                map.put(ar[i],1);
            }
        }
        int count=0;
        for (Map.Entry mapElement : map.entrySet()) { 
            
            count=count+(((int)mapElement.getValue())/2);
        } 
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] str=br.readLine().split("\\s+");
        int[] ar=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=Integer.parseInt(str[i]);
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);
    }
}
