public class MobilePhoneSet {
	public Myset m = new Myset();
	
	public void InsertMP(int a){
		MobilePhone pal = new MobilePhone(a);
		m.Insert(pal);
	}
	public void InsertMP(MobilePhone a){
		m.Insert(a);
	}
	public void DeleteMP(int a){
		MobilePhone topa = new MobilePhone(0);
		for(int i = 0 ; i < m.l.size() ; i++){
			topa = (MobilePhone)m.l.get(i);
			if(topa.number() == a)
			{
				m.Delete(i);
				return;
			}
		}
	}
	public boolean isMember(int a){
		MobilePhone pal = new MobilePhone(0);
		for(int i = 0 ; i < m.l.size() ; i++){
			pal = (MobilePhone)m.l.get(i);
			if(pal.number() == a)
				return true;
		}
		return false;
	}
	public MobilePhone retPhone(int a){
		MobilePhone pal = new MobilePhone(0);
		for(int i = 0 ; i < m.l.size() ; i++){
			pal = (MobilePhone)m.l.get(i);
			if(pal.number() == a) return pal;
		}
		return null;
	}
	public boolean isEmpty(){
		return m.IsEmpty();
	}
}
