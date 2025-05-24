// User function Template for Java

class Solution 
{
public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) 
                                                      
    {
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> usedOnLevel = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        int level =0;
        temp.add(startWord);
        q.add(temp);
        HashSet<String> hs = new HashSet<>();
        for(String w:wordList)
            hs.add(w);
            
        while(!q.isEmpty())
        {
            ArrayList<String> al = q.poll();
            if(al.size()>level)
            {
                level++;
                for(String w:usedOnLevel)
                {
                    hs.remove(w);
                }
                usedOnLevel.clear();
            }
            String w = al.get(al.size()-1);
            if(w.equals(targetWord))
            {
                if(res.size()==0)
                {
                    res.add(al);
                }
                else if(res.get(0).size()==al.size())
                {
                    res.add(al);
                }
            }
            for(int i=0;i<w.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char chars[] = w.toCharArray();
                    chars[i] = ch;
                    String newW = new String(chars);
                    
                    if(hs.contains(newW))
                    {
                        ArrayList<String> temps = new ArrayList<>(al);
                        temps.add(newW);
                        q.add(temps);
                        usedOnLevel.add(newW);
                    }
                }
            }
        }
            
        
        return res; 
    }
}