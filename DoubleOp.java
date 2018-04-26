import java.io.File;
import java.util.Scanner;
public class DoubleOp {
    public static String new_line;
    Node head;
    Node tail;
    class Node
    {
        int data;
        Node previous;
        Node next;
        Node(int dt){data=dt;}
    }
    public void insertAtHead(int inputElement)
    {
       
        Node node_New = new Node(inputElement);
       
            
       
        node_New.next = head;
        node_New.previous = null;
            
      
        if(head != null)
            head.previous = node_New;
     
      
        head = node_New;   
       
    }
    public boolean insertAfterElement(int key, int dd)
    {                              
    Node present = head;         
    while(present.data != key)   
       {
        present = present.next;     
       if(present == null)
          return false;            
       }
    Node newLink = new Node(dd);   

    if(present==tail)              
       {
       newLink.next = null;        
       tail = newLink;             
       }
    else                           
       {
       newLink.next = present.next; 
                                    
       present.next.previous = newLink;
       }
    newLink.previous = present;   
    present.next = newLink;        
    return true;                 
    }
    public Node deleteElement(int element)   
    {                              


   Node present = head;          
    while(present.data != element)    
       {
        present = present.next;     
       if(present == null)
          return null;             
       }
    if(present==head)             
       head = present.next;      
    else                           
                                   
        present.previous.next = present.next;

    if(present==tail)              
       tail = present.previous;   
    else                           
                                 
        present.next.previous = present.previous;
    return present;                
    }
     public String searchElement(int element){
         Node present = head;         
            while(present!= null)    
               {
              
               if(present.data == element)
          
                  return "found";
              
                   present = present.next;
              
               
               }
           
            return "not_found";
           
         
     }
        public void displayList(Node node)
         {
            
             System.out.println("List after Operations:");
             while(node != null)
             {
                 System.out.print(node.data + " ");
                 tail = node;
                 node = node.next;
             }
         }
            
   
   
    public static void main(String[] args){
        DoubleOp dn= new DoubleOp();
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
         String[] splited_line = new_line.split("\\s+");
         try{
                for(int i=0;i<splited_line.length; i++){
                    if(splited_line[i].endsWith(".in")){
                        if(dn.searchElement(Integer.parseInt(splited_line[i].substring(0,splited_line[i].indexOf(".")))).equals("not_found")){
                            dn.insertAtHead(Integer.parseInt(splited_line[i].substring(0,splited_line[i].indexOf("."))));
                           
                        }
                        else{
                            System.out.println("Duplicate key");
                        }
                   
                    }
                    else if(splited_line[i].matches("(.*)\\.in\\_(.*)")){
                       
                        if(dn.searchElement(Integer.parseInt(splited_line[i].substring(0,splited_line[i].indexOf(".")))).equals("not_found")){
                            dn.insertAfterElement(Integer.parseInt(splited_line[i].substring((splited_line[i].indexOf("_"))+1)),Integer.parseInt(splited_line[i].substring(0,splited_line[i].indexOf("."))));
                           
                           
                        }else{
                            System.out.println("Duplicate key");

                           
                        }
                       
                       
                       
                    }

                    else if(splited_line[i].endsWith(".del")){
                                               
                       
                        dn.deleteElement(Integer.parseInt(splited_line[i].substring(0,(splited_line[i].indexOf(".")))));
                    }
                    else if(splited_line[i].endsWith(".sch")){
                       
                        System.out.println(dn.searchElement(Integer.parseInt(splited_line[i].substring(0,(splited_line[i].indexOf("."))))));
                    }
                    else{
                        System.out.println("invalid key");
                    }
                                   
                }
                dn.displayList(dn.head); }
               catch(Exception ex){
                   System.out.println("invalid key");
                  
               }

       
       
       
    }

}