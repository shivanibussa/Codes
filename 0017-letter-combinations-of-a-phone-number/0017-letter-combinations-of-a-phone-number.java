class Solution 
{
    public List<String> letterCombinations(String digits) 
    {
        List<String> ans = new ArrayList<>();
        if(digits.equals(""))
        {
            System.out.println("HIII");
            return ans;
        }
        String charMap[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        f(digits,charMap,0,"",ans);
        return ans;
    }
    public void f(String digits,String charMap[],int ind,String path,List<String> ans)
    {
        if(digits.length()==path.length())
        {
            ans.add(path);
            return;
        }
        String word = charMap[digits.charAt(ind)-'0'];
        for(char ch:word.toCharArray())
        {
            f(digits,charMap,ind+1,path+ch,ans);
        }
    }
}