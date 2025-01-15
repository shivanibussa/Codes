//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] words = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(sc.nextLine());
            int n = words.length;
            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, k);
            if (order.length() == 0) {
                System.out.println("false");
                System.out.println("~");
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                System.out.println("~");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2) {
                        return Integer.compare(a.length(), b.length());
                    }

                    return Integer.compare(index1, index2);
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution 
{
    public String findOrder(String[] dict, int k) 
    {
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i=0;i<k;i++)
       {
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<dict.length-1;i++)
       {
           String s1 = dict[i];
           String s2 = dict[i+1];
           int len=Math.min(s1.length(),s2.length());
           for(int ptr=0;ptr<len;ptr++)
           {
               if(s1.charAt(ptr)!=s2.charAt(ptr))
               {
                   adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                   break;
               }
           }
        }
        List<Integer> topo = topoSort(adj,k);
        String ans = "";
        for(int it:topo)
        {
            ans+=(char)(it+(int)'a');
        }
        if(ans.length()!=k)
            return "";
        return ans;
    }
    public List<Integer> topoSort(ArrayList<ArrayList<Integer>> adj,int K)
    {
        int indegree[] = new int[K];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<K;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        
        for(int i=0;i<K;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int pop = q.poll();
            arr.add(pop);
            
            for(int it:adj.get(pop))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.offer(it);
                }
            }
        }
        return arr;
    }
    
    
}

