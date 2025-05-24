class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        if(A[0][0]==0)return -1;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,0,0));
        boolean v[][]=new boolean[N][M];
        v[0][0]=true;
        int dx[]={0,0,-1,1},dy[]={-1,1,0,0};
        while(!q.isEmpty())
        {
            pair p=q.poll();
            if(p.a==X && p.b==Y)return p.c;
            for(int i=0;i<4;i++){
                int na=p.a+dx[i],nb=p.b+dy[i];
                if(na>=0 && na<N && nb>=0 && nb<M && !v[na][nb] && A[na][nb]==1){
                    q.add(new pair(na,nb,p.c+1));
                    v[na][nb]=true;
                }
            }
        }
        return -1;
    }
}
class pair
{
    int a,b,c;
    public pair(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
}