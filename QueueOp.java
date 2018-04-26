import java.io.File;
import java.util.Scanner;
public class QueueOp {
    public static String new_line;
    int[] ArrQueue;
    int frontElement, rearElement,Arr_size;
    public QueueOp(int k)
    {
        Arr_size=k;
        frontElement = rearElement = 0;
        ArrQueue= new int[Arr_size];
    }
    public void insertElement(int v)
    {
        if((rearElement+1) % Arr_size != frontElement)
        {
            rearElement = (rearElement+1)%Arr_size;
            ArrQueue[rearElement] = v;
        }
        else
            System.out.println("OverFlow");
    }
    public String deleteElement()
    {
        int v;
        if(frontElement!=rearElement)
        {
            frontElement = (frontElement+1)%Arr_size;
            v = ArrQueue[frontElement];
            return "true";
        }
        else{
            return "false";
        }

       
    }
    public void displayList()
    {
        int i;
        if(frontElement != rearElement)
        {
            i = (frontElement +1) %Arr_size;
            System.out.println("List after operation:");
            System.out.println(i);
            while(i!=rearElement)
            {
                //System.out.println(Q[i]);
                i = (i+1) % Arr_size;
                System.out.println(ArrQueue[i]);
            }
        }
        else
            System.out.println("");
    }

    public static void main(String[] args) {
       
       
        try {
            System.out.print("Enter the file name with extension : ");

            Scanner inp = new Scanner(System.in);

            File input_file = new File(inp.nextLine());

            inp = new Scanner(input_file);
           


            while (inp.hasNextLine()) {
                new_line = inp.nextLine();
                System.out.println("List before operation:"+new_line);
               
            }
             inp.close();
           
          

        } catch (Exception ex) {
            ex.printStackTrace();
        }

         String[] splited = new_line.split("\\s+");
            int n= Integer.parseInt(splited[0]);
            QueueOp qp= new QueueOp(n);
            try{
               
            for(int i=1; i<splited.length;i++){
                if(splited[i].endsWith(".in")){
                    qp.insertElement(Integer.parseInt(splited[i].substring(0,splited[i].indexOf("."))));
                }
                else if(splited[i].equals("del")){
                    qp.deleteElement();
                }
                else{
                    System.out.println("Invalid Element");
                }
            }
            qp.displayList(); }
            catch(Exception ex){
                System.out.println("Invalid Element");
            }

    }

}
