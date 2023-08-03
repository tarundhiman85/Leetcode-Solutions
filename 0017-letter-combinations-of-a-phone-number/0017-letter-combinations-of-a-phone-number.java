class Solution {
    static String[] combinations = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> list;
    public void solve(String digits,int index, String word)
    {
        if(index==digits.length()){
            list.add(word);
            return;
        }    
        int curDigit = digits.charAt(index)-'0';
        String map = combinations[curDigit];
        for(int i=0; i<map.length(); i++)
        {
         solve(digits,index+1,word+map.charAt(i));   
        }
    }
    public List<String> letterCombinations(String digits) 
    {
      list = new ArrayList<>();
      if(digits.length()==0){
          return list;
      }    
      else{
          List<String> s = new ArrayList<>();
          solve(digits,0,"");
      }
        return list;
    }
}
/*
create a digit to string array
[abc, def, ghi, jkl, mno, pqrs, tuv, wxyz]

23
what will happen when 2 click
    we have 3 letters 
        abc
        for each 3 letters we have 3 click which will have 3 letters more
          def
      
f(arr,i)      
   if(i==n)
   {
     res.add(str);
     str = new String();
     return
   }
    for i in range(arr[i]):
      //we can take it
      str.add(arr[i])
      f(arr, i+1, str);
      //we cannot take it
      str.remove(str.length-1);
*/