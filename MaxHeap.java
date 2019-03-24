public class MaxHeap
 { 
     Integer[] Heap; 
    Integer size; 
    Integer maxsize; 

    public MaxHeap(Integer maxsize) 
    { 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new Integer[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    } 
  

  Integer parent(Integer pos) 
    { 
        return pos / 2; 
    } 
   
     Integer leftChild(Integer pos) 
    { 
        return (2 * pos); 
    } 
     Integer rightChild(Integer pos) 
    { 
        return (2 * pos) + 1; 
    } 

     boolean isLeaf(Integer pos) 
    { 
        if (pos >= (size / 2) && pos <= size) { 
            return true; 
        } 
        return false; 
    } 
  
    void swap(Integer fpos, Integer spos) 
    { 
        Integer tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
 
   void maxHeapify(Integer pos) 
    { 
        if (isLeaf(pos)) 
            return; 
  
        if (Heap[pos] < Heap[leftChild(pos)] ||  Heap[pos] < Heap[rightChild(pos)]) { 
  
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else 
            { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    } 
  
 
    public void insert(Integer element) 
    { 
        Heap[++size] = element; 
  
        
        Integer current = size; 
        while (Heap[current] > Heap[parent(current)]) { 
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    public void print() 
    { 
        for (Integer i = 1; i <= size / 2; i++) { 
            System.out.print("parent " + Heap[i] + " left child : " + 
                      Heap[2 * i] + " right child :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
   
    public Integer extractMax() 
    { 
        Integer popped = Heap[1]; 
        Heap[1] = Heap[size--]; 
        maxHeapify(1); 
        return popped; 
    } 
  
    public static void main(String[] args) 
    { 
        
        MaxHeap maxHeap = new MaxHeap(10); 
        maxHeap.insert(1); 
        maxHeap.insert(4); 
        maxHeap.insert(17); 
        maxHeap.insert(38);  
        maxHeap.insert(100); 
  
        maxHeap.print();
        System.out.println("After adding element "); 
   
          maxHeap.insert(10);
          
        maxHeap.print();
         
        System.out.println("The max val is " + maxHeap.extractMax()); 
    } 
} 
