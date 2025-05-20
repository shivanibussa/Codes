class MedianFinder 
{
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public MedianFinder() 
    {
        min = new PriorityQueue<>(Collections.reverseOrder());
        max = new PriorityQueue<>();
    }
    
    public void addNum(int num) 
    {
        min.add(num);
        if(min.size()-max.size()>1 || !max.isEmpty() && min.peek()>max.peek())
        {
            max.add(min.poll());
        }
        if(max.size()-min.size()>1)
        {
            min.add(max.poll());
        }
    }
    
    public double findMedian() 
    {
        if(min.size()==max.size())
        {
            return (double)(min.peek()+max.peek())/2;
        }
        else if(min.size()>max.size())
            return (double)min.peek();
        else
            return (double)max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */