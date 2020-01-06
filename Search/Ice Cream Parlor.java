import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        if(money%2==0){
            int count=0;
            for(int i=0;i<cost.length;i++){
                if(cost[i]==money/2)
                    count++;
            }
            if(count>=2){
                int flag=0;
                for(int i=0;i<cost.length;i++){
                    if((cost[i]==money/2)&&flag<2){
                        int k=i+1;
                        System.out.print(k+" ");
                        flag++;
                    }
                }
                System.out.println();
                return;
            }else{
                int[] arr=new int[cost.length];
                HashMap<Integer,Integer> map=new HashMap<>();
                for(int i=0;i<cost.length;i++){
                    map.put(cost[i],i);
                    arr[i]=cost[i];
                }
                Arrays.sort(arr);
                for(int i=0;i<cost.length-1;i++){
                    if(arr[i]<money){
                        int res=binarySearch(arr,i+1,cost.length-1,money-arr[i]);
                        if(res!=-1){
                            int p=map.get(arr[i])+1;
                            int q=map.get(money-arr[i])+1;
                            int m=Math.max(p,q);
                            int n=Math.min(p,q);
                            System.out.println(n+" "+m);
                            return;
                        }
                    }
                }
            }
        }else{
            int[] arr=new int[cost.length];
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<cost.length;i++){
                map.put(cost[i],i);
                arr[i]=cost[i];
            }
            Arrays.sort(arr);
            for(int i=0;i<cost.length-1;i++){
                if(arr[i]<money){
                    int res=binarySearch(arr,i+1,cost.length-1,money-arr[i]);
                    if(res!=-1){
                        int p=map.get(arr[i])+1;
                        int q=map.get(money-arr[i])+1;
                        int m=Math.max(p,q);
                        int n=Math.min(p,q);
                        System.out.println(n+" "+m);
                        return;
                    }
                }
            }
        }
    }
    static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
  

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
