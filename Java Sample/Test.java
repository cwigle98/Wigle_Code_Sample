/**
Class for testing the DoubleLinkedList object
*/
public class Test
{
   public static void main(String args[])
   {
      testAppend();
      testIsEmpty();
      testGetIndex();
      testLength();
      testRemove();
      testAppendIndex();
      testRemoveIndex();
   }
   public static void testAppend()
   {
      //Test a populated list
      DoubleLinkedList test1 = new DoubleLinkedList("One");
      assert test1.getLastNode().getData().equals("One");
      test1.append("Two");
      assert test1.getLastNode().getData().equals("Two");
      test1.append("Three");
      assert test1.getLastNode().getData().equals("Three");
      //Test an empty list
      DoubleLinkedList test2 = new DoubleLinkedList();
      assert test2.getLastNode()==null;
      test2.append("One");
      assert test2.getLastNode().getData().equals("One");
   }
   public static void testLength()
   {
      DoubleLinkedList test1 = new DoubleLinkedList("One");
      test1.append("Two");
      test1.append("Three");
      test1.append("Four");
      assert test1.length()==4;
      DoubleLinkedList test2 = new DoubleLinkedList();
      assert test2.length()==0;
   }
   public static void testIsEmpty()
   {
      DoubleLinkedList test1 = new DoubleLinkedList();
      assert test1.isEmpty();
      DoubleLinkedList test2 = new DoubleLinkedList("One");
      assert !test2.isEmpty();
   }
   public static void testGetIndex()
   {
      DoubleLinkedList test1 = new DoubleLinkedList("One");
      test1.append("Two");
      test1.append("Three");
      test1.append("Four");
      assert test1.getIndex("Three")==2;
      DoubleLinkedList test2 = new DoubleLinkedList();
      assert test2.getIndex("Three")==-1;
      DoubleLinkedList test3 = new DoubleLinkedList("One");
      test3.append("Two");
      test3.append("Four");
      assert test3.getIndex("Three")==-1;
   }
   public static void testRemove()
   {
      DoubleLinkedList test1 = new DoubleLinkedList("One");
      assert !test1.isEmpty();
      test1.remove("One");
      assert test1.isEmpty();
      DoubleLinkedList test2 = new DoubleLinkedList("One");
      test2.append("Two");
      test2.append("Three");
      test2.remove("Two");
      assert test2.getIndex("Two")==-1;
      DoubleLinkedList test3 = new DoubleLinkedList("One");
      test3.append("Two");
      test3.append("Three");
      test3.remove("Three");
      assert test3.getLastNode().getData().equals("Two");
   }
   public static void testAppendIndex()
   {
      DoubleLinkedList test1 = new DoubleLinkedList("One");
      test1.appendIndex("The real One",0);
      assert test1.getIndex("The real One")==0;
      DoubleLinkedList test2 = new DoubleLinkedList();
      test2.appendIndex("One",0);
      assert test2.getIndex("One")==0;
      DoubleLinkedList test3 = new DoubleLinkedList("One");
      test3.append("Two");
      test3.append("Three");
      test3.appendIndex("Hello",2);
      assert test3.getIndex("Hello")==2;
   }
   public static void testRemoveIndex()
   {
      DoubleLinkedList test1 = new DoubleLinkedList("One");
      test1.removeIndex(0);
      assert test1.isEmpty();
      DoubleLinkedList test2 = new DoubleLinkedList("One");
      test2.append("Two");
      test2.removeIndex(0);
      assert test2.getIndex("Two")==0;
      DoubleLinkedList test3 = new DoubleLinkedList("One");
      test3.append("Two");
      test3.removeIndex(1);
      assert test3.getIndex("Two")==-1;
      DoubleLinkedList test4 = new DoubleLinkedList("One");
      test4.append("Two");
      test4.append("Three");
      test4.removeIndex(1);
      assert test4.getIndex("Two")==-1;
   }
}