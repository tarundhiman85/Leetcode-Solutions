class Solution {
       static class DisjointSet{
        int[] parent;
        DisjointSet(int n)
        {
            parent = new int[n+1];
            for(int i=0; i<=n; i++)
            {
                parent[i]=i;
            }
        }
        public int findUPar(int u)
        {
            if(parent[u]==u)
            {
                return u;
            }
            int findUParent = findUPar(parent[u]);
            //path compression
            return parent[u] = findUParent;
        }
        public void unionBySize(int u, int v)
        {
            //find for u,v who is the ultimate parent
            int pu = findUPar(u);
            int pv = findUPar(v);
            //they belong to same component
            if(pv==pu) return;
            if(pv<pu) {
                parent[pu] = pv;
            }
            else if(pv>pu)
            {
                parent[pv] = pu;
            }
            else{
                parent[pu] = pv;
            }
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr)
    {
        DisjointSet ds = new DisjointSet(27);
        int n = s1.length();
        for(int i=0; i<n; i++)
        {
            ds.unionBySize(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }
        String res="";
        for(int i=0; i<baseStr.length(); i++)
        {
            char ch = baseStr.charAt(i);
            char up = (char)(ds.findUPar(ch-'a')+'a');
            res+=up;
        }
        return res;
    }
}

/*
abc
cde
a==c  , c==e,   a==e,  b==d
eed
aab


hello
world
           size[2,1]              size[2,1]        size[2,1]       size[2,1]     size[3,1]
         parent[h,h]            parent[d,e]      parent[l,l]     parent[e,d]   parent[k,s]    
                h w                    e,o              l,r             o,d           r,s           
            h/w    h<-w          e/o   e<-o       l/r     l<-r       e/i  d<-e           r/s    k<-s
             0                    1                2                  3                4

parser
makkek
makkek

store each equivalent char two times
now for each char of bsStr 
  check the smaller ch
     once find check smaller till now entry find in map
                
*/