import java.util.LinkedList;

public class ExchangeList{
	
	LinkedList<Exchange> l = new LinkedList();
	
	public boolean IsEmpty(){
		return l.isEmpty();
	}
	public boolean IsMember(Exchange o){
		return l.contains(o);
	}
	public void Insert(Exchange o){
		l.addLast(o);
	}
	public void Delete(Exchange o){
		if(l.remove(o) == false )System.out.println("Not there");;
	}
	public Object getFirst(){
		return l.getFirst();
	}
	public Object getI(int i){
		return l.get(i);
	}
	public void khali(){
		l.clear();
	}
}
