package com.operr.challenge.app;

import java.util.Scanner;

/*Class Node*/
class Node
{
    protected int data;
    protected Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        data = 0;
    }    
    /*  Constructor  */
    public Node(int d,Node n)
    {
        data = d;
        link = n;
    }    
    /*  Method to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Method to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}
 
/* Class linkedList */
class linkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
 
    /*  Constructor  */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Method to get size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Method to insert an element at begining  */
    public void appendAtStart(int val)
    {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            nptr.setLink(start);
            start = nptr;
        }
    }
    /*  Method to insert an element at end  */
    public void appendAtEnd(int val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
    /*  Function to insert an element at position  */
    public void appendAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getLink() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size++ ;
    }
    /*  Method to delete an element at position  */
    public void removeTail()
    {        
        if (size == 1) 
        {
            start = null;
            size = 0;
            end =null;
            return ;
        }
        else
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        
    }    
    
    /*Method to remove greater elements*/
    public void removeGreater(int target)
    {
    	if (size == 1) 
        {
    		if(start.getData() > target)
    		{
    			start = null;
                size = 0;
                end =null;
    		}
        }
    	else
    	{
    		Node ptr = start;
    		int initialSize= size;
    		for(int i=1;i<=initialSize;i++)
    		{
    			if(ptr.getData()>target)
    			{
    				if(ptr == start)
    				{
    					Node tmp =start.getLink();
    					start = null;
    					start = tmp;
    					size--;
    				}
    				else if (ptr == end)
    				{
    					removeTail();
    				}
    				else
    				{
    					Node s = start;
    					Node t = start;
    					
    					while(s != end)
    					{
    						if(s == ptr)
    						{
    							break;
    						}
    						else
    						{
    							t = s;
    							s = s.getLink();
    						}
    					}
    					
    					t.setLink(s.getLink());
    					s = null;
    					size--;
    					
    				}
    			}
    			ptr= ptr.getLink();
    		}
    	}
    }
    
    /*  Method to display elements  */
    public void display()
    {
        System.out.print("\nCurrent List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
public class SinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        linkedList list = new linkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. append at beginning");
            System.out.println("2. append at end");
            System.out.println("3. append at position");
            System.out.println("4. remove at tail");
            System.out.println("5. remove elements greater than target value");
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.appendAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.appendAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.appendAtPos(num, pos);
                break;                                          
            case 4 : 
            	if(list.getSize()>0)
                    list.removeTail();
                else
                    System.out.println("No elements in the list to remove");
                 break;
            case 5 :
            	System.out.println("Enter the target value");
           	 	int target = scan.nextInt();
           	 	if(list.getSize()>0)
           	 		list.removeGreater(target);
           	 	else
           	 		System.out.println("No elements in the list to remove");
           	 	break;
             
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    
	}

}
