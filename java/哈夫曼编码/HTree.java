import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Node{
	Node parent;
	Node rChild;
	Node lChild;
	int value;
	char c;
	String code;
	public Node(char c,int value)
	{
		this.c=c;
		this.value=value;
		code="";
	}
}

public class HTree{
	Node root;
	ArrayList<Node> timetable;
	Map<String,Node> table;
	
	public HTree() {
		timetable=new ArrayList<Node>();
	}
	
	public void getTableFromStr(String str)
	{
		char[] strc=str.toCharArray();
		table=new HashMap<>();
		for(int i=0;i<strc.length;i++)
		{
			if(table.get(""+strc[i])==null)
			{
				
				table.put(""+strc[i], new Node(strc[i],1));
				//System.out.println(strc[i]);
			}else {
				table.get(""+strc[i]).value++;
			}	
		}
		
//		for (Entry<String, Node> entry : table.entrySet()) { 
//			 timetable.add(entry.getValue());
//			}
//		for (Node value : table.values()) { 
//			  timetable.add(value);
//			}
		
		for (String key : table.keySet()) {
		       //System.out.println("key= "+ key + " and value= " + table.get(key));
		       timetable.add(table.get(key));
		}
	}
	
	public void genertable()
	{
		//System.out.println(timetable.size());
		
		
		timetable.sort(new Comparator<Node>(){
			public int compare(Node arg0, Node arg1) {
				if(arg0.value<arg0.value)
				{
					return 1;
				}
				if(arg0.value>arg0.value)
				{
					return -1;
				}
				if(arg0.value==arg0.value)
				{
					return 0;
				}
				return 0;
			}	
		});
		
		Node root=new Node('#',timetable.get(0).value+timetable.get(1).value);
		timetable.add(root);
		timetable.get(0).parent=root;
		timetable.get(1).parent=root;
		root.lChild=timetable.get(0);
		//timetable.get(0).code="0"+timetable.get(0).code;
		root.rChild=timetable.get(1);
		//timetable.get(1).code="1"+timetable.get(1).code;
		
		timetable.remove(0);
		timetable.remove(0);
		
		if(timetable.size()==1)
		{
			this.root=timetable.get(0);
			return;
		}
		genertable();
	}
	
	public void setCode(Node cur,String hcode)
	{
		if(cur.lChild!=null)
		{
			cur.lChild.code=hcode+"0";
			setCode(cur.lChild,hcode+"0");
		}
		if(cur.rChild!=null)
		{
			cur.rChild.code=hcode+"1";
			setCode(cur.rChild,hcode+"1");
		}
		
		
		
	}
	
	public String encode(String str)
	{
		String code="";
		char[] strc=str.toCharArray();
		for(int i=0;i<strc.length;i++)
		{
			//System.out.println(table.get(""+strc[i]).code);
			code=code+table.get(""+strc[i]).code;
		}
		return code;
	}
	
	public void decode(String str)
	{
		char[] strc=str.toCharArray();
		Node cur=root;
		for(int i=0;i<strc.length;i++)
		{
			if(strc[i]=='0')
			{
				cur=cur.lChild;
				if(cur.c!='#')
				{
					System.out.print(cur.c);
					cur=root;
				}
			}
			if(strc[i]=='1')
			{
				cur=cur.rChild;
				if(cur.c!='#')
				{
					System.out.print(cur.c);
					cur=root;
				}
			}
		}
	}
	
	
	public static void main(String[] args)
	{
		String teststr="gggggrasdasddddddtttttr";
		HTree htree=new HTree();
		System.out.println("test");
		htree.getTableFromStr(teststr);
		htree.genertable();
		htree.setCode(htree.root, "");
		System.out.println(htree.encode(teststr));
		String jiema=htree.encode(teststr);
		htree.decode(jiema);
		
	}
	
	
}