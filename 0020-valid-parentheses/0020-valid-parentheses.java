class Solution {
    public boolean isValid(String s) {
             Stack<Character> st = new Stack<>();
        for(char value: s.toCharArray())
        {
            if(value == '(' || value == '{' || value == '[')
                st.push(value);
            else if(st.size() != 0)
            {
                if(value == ')' && st.pop() != '(')
                    return false;
                else if(value == '}' && st.pop() != '{' )
                    return false;
                else if(value == ']' && st.pop() != '[')
                    return false;
            }
            else
                return false;
                    
            
        }
        if(st.size() != 0)
            return false;
        
        return true;
    
    }
}