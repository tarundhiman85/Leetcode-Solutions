class Solution:
    def interpret(self, command: str) -> str:
        n = len(command)
        res = ''
        i = 1
        while i < n:
            if command[i-1] == 'G':
                res = res + 'G'
            elif command[i-1] == '(' and command[i] == ')':
                res = res + 'o'
            elif command[i-1] == '(' and command[i] == 'a':
                res = res + 'al'
                i += 1
            i += 1
        # print(i == n)    
        if command[i-1] == 'G':
            res = res + 'G'
        return res    
                