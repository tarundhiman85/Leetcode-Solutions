class Solution {
    public int evalExp(int first, int second, char exp)
    {
        switch(exp)
        {
            case '*':
                return first*second;
            case '-':
                return first-second;
            case '+':
                return first+second;
        }
        return (int)Math.floor(first/second);
    }

    public int evalRPN(String[] tokens)
    {
        Stack<Integer> st = new Stack<>();
        int i=1;
        int ans=0;
        st.push(Integer.parseInt(tokens[0]));
        while(i<tokens.length && !st.isEmpty())
        {
            //we are not able to handle digits
            if(tokens[i].length()==1 && Character.isDigit(tokens[i].charAt(0)))
            {
                int dgt = Integer.parseInt(tokens[i]);
                st.push(dgt);
            }
            else if(tokens[i].length()>1)
            {
                int dgt = Integer.parseInt(tokens[i]);
                st.push(dgt);
            }
            else
            {
                if(st.size()>1)
                {
                    int s1 = st.pop();
                    int s2 = st.pop();
                    char currExp = tokens[i].charAt(0);
                    int result = evalExp(s2, s1, currExp);
                    st.push(result);
                }
                else{
                   ans=st.pop();
                }
            }
            i++;
        }
        return ans==0?st.pop():ans;
    }
}