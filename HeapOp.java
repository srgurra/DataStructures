import java.io.File;
import java.util.Scanner;

public class HeapOp {
    public static String new_line;
    static int[] ArrHeap;
    public int Arr_size;
    public static int heapSize;
    public HeapOp(int k)
    {
        Arr_size=k;
       
        ArrHeap= new int[Arr_size];
    }
    int left_child(int j) { return (2*j + 1); }
    int right_child(int j) { return (2*j + 2); }
    int getMin() { return ArrHeap[0]; }
    public void in_Display(int j) {
        // TODO Auto-generated method stub
        if (j >= heapSize) {
            return;
        }
        in_Display(left_child(j));
        System.out.print(ArrHeap[j] + " ");
        in_Display(right_child(j));
       
    }
   
    private void post_Display(int i) {
        // TODO Auto-generated method stub
       
           if (i >= heapSize) {
                return;
            }
           post_Display(left_child(i));
           post_Display(right_child(i));
            System.out.print(ArrHeap[i] + " ");
       
    }

    private void pre_Display(int i) {
        // TODO Auto-generated method stub
          if (i >= heapSize) {
                return;
            }
            System.out.print(ArrHeap[i] + " ");
            pre_Display(left_child(i));
            pre_Display(right_child(i));
       
    }
    int parent(int i) { return (i-1)/2; }
    private void insertElementHeap(int value) {
        heapSize++;

        ArrHeap[heapSize - 1] = value;
      
        moveUp(heapSize - 1);
        // TODO Auto-generated method stub
       
    }
    private void moveUp(int ind) {

        int parentIndex, tmp;

        if (ind != 0) {

              parentIndex = parent(ind);

              if (ArrHeap[parentIndex] < ArrHeap[ind]) {

                    tmp = ArrHeap[parentIndex];

                    ArrHeap[parentIndex] = ArrHeap[ind];

                    ArrHeap[ind] = tmp;

                    moveUp(parentIndex);

              }

        }

  }
    private static String search(int n) {
        for (int i = 0; i < heapSize; i++) {
            if (ArrHeap[i] == n) {
                return "Found";
            }
        }
        return "Not found";
    }
    private void deleteElementHeap() {
        // TODO Auto-generated method stub
        ArrHeap[0] = ArrHeap[--heapSize];
        moveDown(0);
       
    }
     public void moveDown(int ind)
     {
     int maxEle;
     int root = ArrHeap[ind];      
     while(ind < heapSize/2)      
        {                              
       
                                       
        if(right_child(ind) < heapSize && 
                ArrHeap[left_child(ind)] <
                ArrHeap[right_child(ind)])
           maxEle = right_child(ind);
        else
            maxEle = left_child(ind);
                                       
        if( root >= ArrHeap[maxEle])
           break;
                                       
        ArrHeap[ind] = ArrHeap[maxEle];
        ind = maxEle;           
        } 
     ArrHeap[ind] = root;           
     }

    public static void main(String[] args) {

        try{
        System.out.println("Enter file name: ");
        Scanner inpt = new Scanner(System.in);

        File inpt_fil = new File(inpt.nextLine());
        inpt = new Scanner(inpt_fil);
        while (inpt.hasNextLine()) {
            new_line = inpt.nextLine();
            System.out.println("List before operation:"+new_line);
           
        }
         inpt.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
         String[] splited = new_line.split("\\s+");
            //int n= Integer.parseInt(splited[0]);
            HeapOp hp= new HeapOp(splited.length-1);
            try{
               
            for(int i=1; i<splited.length;i++){
                if(splited[i].endsWith(".in")){
                    hp.insertElementHeap(Integer.parseInt(splited[i].substring(0,splited[i].indexOf("."))));
                }
                else if(splited[i].equals("del")){
                    hp.deleteElementHeap();
                }
                else if(splited[i].endsWith("sch")){
                    System.out.println(splited[i].substring(0,splited[i].indexOf("."))+" "+search(Integer.parseInt(splited[i].substring(0,splited[i].indexOf(".")))));
                }
            }
            if(splited[0].equalsIgnoreCase("pre")){
                hp.pre_Display(0);
               
            }
            else if(splited[0].equalsIgnoreCase("post")){
                 hp.post_Display(0);
            }
            else if(splited[0].equalsIgnoreCase("in")){
                 hp.in_Display(0);
               
            }
          
          
            }
            catch(Exception ex){
                System.out.println("Invalid Element");
            }


    }
   



}

