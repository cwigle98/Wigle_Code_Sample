/**
Creates a class that is a single data point in a list
*/
public class Node
{
   /**
   Attributes for the Node class which will be a 
   single container in the linked list
   
   -Node previous: is the reference to the previous node in the linked list
   -Node next: is the reference to the next node in the linked list
   -String data: this data type can be anything I just used string for this demo
   */
   private Node previous;
   private Node next;
   private String data;
   
   /**
   Next are two constructors used to create Node objects
   */
   public Node(String newdata)
   {
      previous = null;
      next = null;
      data = newdata;
   }
   public Node(String newdata,Node newprevious)
   {
      data = newdata;
      previous = newprevious;
   }
   
   /**
   The next three methods are retrieval methods to use on the Node objects
   */
   public String getData()
   {
      return data;
   }
   public Node getNextNode()
   {
      return next;
   }
   public Node getPreviousNode()
   {
      return previous;
   }
   /**
   The Last two methods are mutator methods for the Node object
   */
   public void setNextNode(Node newnext)
   {
      next = newnext;
   }
   public void setPreviousNode(Node newprev)
   {
      previous = newprev;
   }
}