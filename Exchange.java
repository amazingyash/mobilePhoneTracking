public class Exchange {
	
	public int id;
	public Exchange parent;
	public Exchange child;
	public ExchangeList siblings;
	public Exchange left;
	public MobilePhoneSet mps;
	
	public Exchange(int number){
		id = number;
		parent = child = left = null;
		siblings = null;
		mps = new MobilePhoneSet();
		siblings = new ExchangeList();
	}
	public Exchange parent(){
		return parent;
	}
	public int numChildren(){
		Exchange ex = new Exchange(0);
		ex = child;
		int i = 0;
		while(ex != null){
			i++;
			ex = ex.left;
		}
		return i;
	}
	public Exchange child(int i){
		Exchange ex = new Exchange(0);
		ex = child;
		for(int n = 1 ; n < i ; n++){
			ex = ex.left;
		}
		return ex;
	}
	public boolean isRoot(){
		if(parent == null)return true;
		else return false;
	}
/*	public RoutingMapTree subtree(int i){
		
	}*/
	public MobilePhoneSet residentSet(){
		return mps;
	}
}
