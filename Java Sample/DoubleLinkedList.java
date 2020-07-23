/**
Creates a class that will be a list of connected nodes
*/
public class DoubleLinkedList
{
   /**
   The two attributes will hold reference to the first node in the
   list and the last node
   */
   private Node root;
   private Node last;
   /**
   The next two values are constructors
   */
   public DoubleLinkedList()
   {
      root = null;
      last = null;
   }
   public DoubleLinkedList(String data)
   {
      root = new Node(data);
      last = root;
   }
   /**
   Returns the last node in the list
   */
   public Node getLastNode()
   {
      return last;
   }
   
   /**
   Appends a value to the end of a list
   */
   public boolean append(String data)
   {
      if(root == null)
      {
         root = new Node(data);
         last = root;
         return true;
      }
      else
      {
         Node newNode = new Node(data,last);
         last.setNextNode(newNode);
         last = newNode;
         return true;
      }
   }
   
   /**
   Adds a value at a certain index in the list
   */
   public boolean appendIndex(String data,int index)
   {
      if(index > this.length() || index < 0)
      {
         return false;
      }
      Node newNode = new Node(data);
      if(index == this.length())
      {
         this.append(data);
         return true;
      }
      else if(index == 0)
      {
         Node next = root;
         root.setPreviousNode(newNode);
         newNode.setNextNode(root);
         root = newNode;
         return true;
      }
      else
      {
         Node currNode = root;
         int ind = 0;
         while (currNode != null)
         {
            if(ind == index)
            {
               Node prev = currNode.getPreviousNode();
               currNode.setPreviousNode(newNode);
               newNode.setNextNode(currNode);
               prev.setNextNode(newNode);
               newNode.setPreviousNode(prev);
               return true;
            }
            currNode = currNode.getNextNode();
            ind+=1;
         }
      }
      return false;
   }
   
   /**
   Removes a given data point from the list
   */
   public boolean remove(String data)
   {
      if(this.isEmpty())
      {
         return false;
      }
      Node currNode = root;
      while (currNode != null)
      {
         if((currNode.getData()).equals(data))
         {
            if(currNode == null & currNode.getNextNode() != null)
            {
               root = currNode.getNextNode();
               last = root;
            }
            else if(currNode.getPreviousNode() == null & currNode.getNextNode() == null)
            {
               root = null;
               last = null;
            }
            else if(currNode.getNextNode() == null)
            {
               last = currNode.getPreviousNode();
               currNode.getPreviousNode().setNextNode(null);
            }
            else
            {
               Node prev = currNode.getPreviousNode();
               Node next = currNode.getNextNode();
               prev.setNextNode(next);
               next.setPreviousNode(prev);
            }
            return true;
         }
         currNode = currNode.getNextNode();
      }
      return false;
   }
   /**
   Removes a given index from the list
   */
   public boolean removeIndex(int index)
   {
      if(index >= this.length() || index < 0)
      {
         return false;
      }
      else if(index == 0)
      {
         root = root.getNextNode();
         return true;
      }
      else if(this.isEmpty())
      {
         return false;
      }
      else
      {
         String val = null;
         Node currNode = root;
         int ind = 0;
         while (currNode != null)
         {
            if(ind == index)
            {
               this.remove(currNode.getData());
               return true;
            }
            currNode = currNode.getNextNode();
            ind +=1;
         }
         return false;
      }
   }
   
   /**
   Retrieves the first index of a given data point in a list
   */
   public int getIndex(String data)
   {
      if(this.isEmpty())
      {
         return -1;
      }
      int count = 0;
      Node currNode = root;
      while (currNode != null)
      {
         if(currNode.getData().equals(data))
         {
            return count;
         }
         currNode = currNode.getNextNode();
         count+=1;
      }
      return -1;
   }
   
   /**
   Returns whether the list is empty or not
   */
   public boolean isEmpty()
   {
      return (root==null);
   }
   
   /**
   Prints the list
   */
   public boolean printList()
   {
      if(this.isEmpty())
      {
         System.out.print("| |");
         return false;
      }
      Node currNode = root;
      String concat = new String("|");
      while (currNode != null)
      {
         concat+=" " +currNode.getData()+" |";
         currNode = currNode.getNextNode();
      }
      System.out.print(concat);
      return true;
   }
   
   /**
   Retrieves the length of the list
   */
   public int length()
   {
      if(this.isEmpty())
      {
         return 0;
      }
      int count = 0;
      Node currNode = root;
      while (currNode != null)
      {
         currNode = currNode.getNextNode();
         count+=1;
      }
      return count;
   }
}