import java.util.LinkedList;

public class Myset{
	public LinkedList<Object> l = new LinkedList();
	public boolean IsEmpty(){
		return l.isEmpty();
	}
	public boolean IsMember(Object o){
		return l.contains(o);
	}
	public void Insert(Object o){
		l.addLast(o);
	}
	public void Delete(int i){
		if(i > l.size()-1) System.out.println("Not present there");
		else
		{
			l.remove(i);
		}
	}
	public Object getFirst(){
		return l.getFirst();
	}
	public Myset Union(Myset a){
		Myset m = new Myset();
		int i = 0;
		Object o = new Object();
		o = l.getFirst();
		while(o != null){
			m.Insert(o);
			o = l.get(++i);
		}
		o = a.l.getFirst();
		i = 0;
		while(o != null){
			if(m.IsMember(o) == false)
				m.Insert(o);
			o = a.l.get(++i);
		}
		return m;
	}
	public Myset Intersection(Myset a){
		Myset m = new Myset();
		Object o = new Object();
		for(int i = 0;i<a.l.size();i++)
		{
			o = a.l.get(i);
			if(l.contains(o))
				m.Insert(o);
		}
		return m;
	}
}
