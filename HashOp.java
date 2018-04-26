import java.io.File;
import java.util.Scanner;

public class HashOp {
    public static String new_line;
    public static int size=0;
    public static int prim_size,insElements=0;
    public static int ArrHash[];

   
   
   

   

    public static int hashFun1(int element)
    {
    return element % size;
    }
    public static int hashFun2(int element)
    {

    return prim_size - element % prim_size;
    }
   



    private void insertElement(int element) {
        // TODO Auto-generated method stub
        if(insElements == ArrHash.length){
            System.out.println("Hash table is full, no more entry possible");
            return;
        }
        else{
            insElements++;
           
           
        }
          int val = hashFun1(element); // hash the key
         
         
         
            if (ArrHash[val] != -1) {
            
                int step_Size = hashFun2(element);
           
           
            int j=1;
            while(true){
                int temp= (val+j*step_Size)%size;
                if(ArrHash[temp]==-1){
                    ArrHash[temp]=element;
                    break;
                }
                j++;
            }
            }else{
                ArrHash[val]=element;
            }
       
       
       
        }
private static String search(int element) {
       
        int val = hashFun1(element);
        int step_Size = hashFun2(element);

        while (ArrHash[val] != -1) {
          if (ArrHash[val] == element)
            return "found";
          val += step_Size;
          val %= size;
        }
        return "not_found";
    }
    private void Display(){
        for (int i = 0; i < size; i++) {
            if (ArrHash[i] != -1) {
                System.out.println(i + ": " + ArrHash[i] + " ");
            } else {
                System.out.println(i + ": ");
            }
        }
    }
    private void deleteElement(int element) {
        // TODO Auto-generated method stub
        if(insElements==0){
            System.out.println("no more elements to delete");
        }
         
            int in1 = hashFun1(element);
            if (ArrHash[in1] == element) {
                ArrHash[in1] = -1;
                return;
            }
            int in2 = hashFun2(element);
            int j = 1;
            while (true) {
                int temp = (in1 + j * in2) % size;
                if (ArrHash[temp] == element) {
                    ArrHash[in1] = -1;
                  
                    break;
                }
                j++;
            }
            return;
       
    }
   




    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
                 HashOp hp= new HashOp();
                 size= Integer.parseInt(splited[0]);
                prim_size= Integer.parseInt(splited[1]);
                ArrHash = new int[size];
                for(int i=0; i<size;i++){
                    ArrHash[i]=-1;
                }
     
                try{
                    for(int i=2; i<splited.length;i++){
                    if(splited[i].endsWith(".in")){
                       
                        if(search(Integer.parseInt(splited[i].substring(0,splited[i].indexOf(".")))).equals("not_found")){
                           
                            hp.insertElement(Integer.parseInt(splited[i].substring(0,splited[i].indexOf("."))));
                           
                        }
                        else{
                            System.out.println("Duplicate key");
                        }
                    }
                   
                   
                    else if(splited[i].endsWith(".del")){
                        hp.deleteElement(Integer.parseInt(splited[i].substring(0,splited[i].indexOf("."))));
                    }
                    else if(splited[i].endsWith(".sch")){
                        System.out.println(splited[i].substring(0,splited[i].indexOf("."))+" "+search(Integer.parseInt(splited[i].substring(0,splited[i].indexOf(".")))));
                    }
                    else{
                        System.out.println("invalid key");
                    }
                                   
                }
                    hp.Display(); }
   
                   catch(Exception ex){
                       System.out.println("invalid key");
                   }
    }
                  
              
               
                   
              
   
              
              


}