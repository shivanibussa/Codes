class Pair
{
    int val,weight;
    
    public Pair(int val,int weight)
    {
        this.val = val;
        this.weight = weight;
    }
}
class Solution 
{
    double fractionalKnapsack(int[] values, int[] weights, int weight) 
    {
        int n = values.length;
      Pair p[] = new Pair[values.length];
      double total=0;
      for(int i=0;i<n;i++)
      {
          p[i] = new Pair(values[i],weights[i]);
      }
      Arrays.sort(p,(a,b)->Double.compare((double)b.val/b.weight,(double)a.val/a.weight));
      
      for(int i=0;i<n;i++)
      {
          if(weight>=p[i].weight)
          {
              weight -= p[i].weight;
              total+=p[i].val;
          }
          else
          {
              total+=((double)p[i].val)/((double)p[i].weight)*weight;
              break;
          }
      }
        return total;
    }
}