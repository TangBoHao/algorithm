package algorithm;

public class LinkList {
	Node head;
	int length;
	
	LinkList(){
		head=new Node();
		length=1;
	}
	
	public void add(int num)
	{
		Node cur=head;
		Node newnode=new Node();
		newnode.data=num;
		for(int i=0;i<length-1;i++)
		{
			cur=cur.next;
		}
		cur.next=newnode;
		
		length++;
	}
	
	public void  insert(int n,int num)
	{
		Node cur=head;
		Node newnode=new Node(num);
		for(int i=0;i<n;i++)
		{
			cur=cur.next;
		}
		newnode.next=cur.next;
		cur.next=newnode;
	}
	
	public void visit()
	{
		Node cur=head;
		for(int i=0;i<length;i++)
		{
			System.out.print(cur.data);
			System.out.print(" ");
			cur=cur.next;
		}
		System.out.println();
	}
}


 class Node{
	 int data;
	 Node next;
	 Node()
	 {
		 
		 next=null;
	 }
	 Node(int n)
	 {
		 data=n;
	 }
}
