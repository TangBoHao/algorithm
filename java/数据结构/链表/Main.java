package algorithm;

import java.util.Scanner;

public class Main{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		LinkList list=new LinkList();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.insert(3, 12);
		list.visit();
	}
	
	
	
	
}