import java.util.LinkedList;

class NonExistentExchangeException extends Exception{  
	 NonExistentExchangeException(String s){  
	  super(s);  
	 }  
	}
class ChildOutOfBoundException extends Exception{  
	 ChildOutOfBoundException(String s){  
	  super(s);  
	 }  
	}
class InputFormatException extends Exception{  
	 InputFormatException(String s){  
	  super(s);  
	 }  
	}
class NotBaseException extends Exception{  
	 NotBaseException(String s){  
	  super(s);  
	 }  
	}
class PhoneNonExistentException extends Exception{
	public PhoneNonExistentException(String s) {
		super(s);
	}
}

public class RoutingMapTree extends Thread{
	public static MobilePhoneSet plist;
	public static ExchangeList elist;
	public Exchange root;
	public Exchange node;
	public static long init;
	public String actionMessage;
	public int flag;
	public Thread tr;
	public void run(){
		while(true)
		{
			if(actionMessage != null)
			if(actionMessage.equals("end")) break;
			String A , B , T0 , Texp;
			int a = 0 , b = 0 , texp = 0;
//			if(flag == 1)
//			System.out.println(flag + actionMessage);
			try {
				sleep(100);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			if(flag != 0 && actionMessage != null && actionMessage.equals("end") == false )
			{
				String actions[] = actionMessage.split("\\s");
				String action = actions[1];
//				System.out.println(action);
				switch(action){
				case "addExchange":
//					System.out.println(action);
					if(actions.length == 5){
						T0 = actions[0];
						A = actions[2];
						B = actions[3];
						Texp = actions[4];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						try{
							b = Integer.parseInt(B);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						addExchange(a,b);
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					try {
						sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					actionMessage = null;
					flag = 0;
					break;
				case "switchOnMobile":
					if(actions.length == 5){
						A = actions[2];
						B = actions[3];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						try{
							b = Integer.parseInt(B);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						switchOnMobile(a,b);
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					actionMessage = null;
					flag = 0;
					break;
				case "switchOffMobile":
					if(actions.length == 4){
						A = actions[2];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						switchOffMobile(a);
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					actionMessage = null;
					flag = 0;
					break;
				case "queryNthChild":
					if(actions.length == 5){
						A = actions[2];
						B = actions[3];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						try{
							b = Integer.parseInt(B);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						System.out.println(": " + queryNthChild(a,b));
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					actionMessage = null;
					flag = 0;
					break;
				case "queryMobilePhoneSet":
					if(actions.length == 4){
						String sssss;
						A = actions[2];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						sssss = queryMobilePhoneSet(a);
						System.out.println(sssss);
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					actionMessage = null;
					flag = 0;
					break;
				case "findPhone":
					if(actions.length == 4){
						A = actions[2];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						int ant = findPhone(a);
						if(ant == -1){
							try {
								throw new PhoneNonExistentException("");
							} catch (PhoneNonExistentException e) {
								System.out.println(" Phone Doesn't Exist !!");
//								e.printStackTrace();
							}
						}else{
							System.out.println(" : " + ant);
						}
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					actionMessage = null;
					flag = 0;
					break;
				case "lowestRouter":
					if(actions.length == 5){
						A = actions[2];
						B = actions[3];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						try{
							b = Integer.parseInt(B);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						Exchange ea = findNode(a);
						Exchange eb = findNode(b);
						
						if(ea == null || eb == null){
							System.out.println("Exchange doesn't exist");
						}
						
						Exchange ex = lowestRouter(ea,eb);
						System.out.println(": " + ex.id);
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					try {
						sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					actionMessage = null;
					flag = 0;
					break;
				case "findCallPath":
					if(actions.length == 5){
						A = actions[2];
						B = actions[3];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						try{
							b = Integer.parseInt(B);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						MobilePhone pj = root.mps.retPhone(a);
						MobilePhone div = root.mps.retPhone(b);
//						System.out.println(pj.state + " " + div.state);
						if(pj.state == true && div.state == true)
						{
							ExchangeList sushi = routeCall(pj,div);
							Exchange tt = new Exchange(0);
//							System.out.println(sushi.l.size());
							System.out.print(": ");
							for(int i = 0; i< sushi.l.size() - 1 ; i++){
								tt = (Exchange)sushi.getI(i);
								System.out.print(tt.id + ", ");
							}
							tt = (Exchange)sushi.getI(sushi.l.size()-1);
							System.out.print(tt.id);
//							System.out.println('\b');
							System.out.println();
						}else System.out.println(" Phone is off");
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							// TODO Auto-generated catch block
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					actionMessage = null;
					flag = 0;
					break;
				case "routeCall":
					if(actions.length == 5){
						int c = 0;
						String C;
						System.out.println();
						A = actions[2];
						B = actions[3];
						C = actions[4];
						try{
							a = Integer.parseInt(A);
							c = Integer.parseInt(C);
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						try{
							b = Integer.parseInt(B);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						MobilePhone bam = root.mps.retPhone(a);
						MobilePhone mbo = root.mps.retPhone(b);
						if(bam.busy == false && mbo.busy == false && bam.state == true && mbo.state == true)
						{
							bam.busy = true;
							mbo.busy = true;
							while(true)
							{
								if(System.currentTimeMillis() - init > c*1000)
									break;
							}
							bam.busy = false; 
							mbo.busy = false;
						}else
						{
							System.out.println("Phone busy or off");
						}
					}
					break;
				case "movePhone":
					if(actions.length == 5){
						System.out.println();
						A = actions[2];
						B = actions[3];
						try{
							a = Integer.parseInt(A);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						try{
							b = Integer.parseInt(B);	
						}catch(NumberFormatException e){System.out.println(" Number Format Exception");}
						MobilePhone m = root.mps.retPhone(a);
						Exchange exx = findNode(b);
						if(m != null && exx != null)
						{
							
							Exchange temp1 = m.e;
// 		 	 				System.out.println(m.e.id));
							temp1.mps.retPhone(a).setLocation(exx);
							while(temp1 != null)
							{
//								if(temp1.mps.isMember(a));
//								System.out.println(temp1.id);
								temp1.mps.DeleteMP(m.uid);
								temp1 = temp1.parent;
							}
							
							temp1 = exx;
							while(temp1 != null)
							{
								temp1.mps.InsertMP(m);
								temp1.mps.retPhone(a).setLocation(exx);
								temp1 = temp1.parent;
							}
							
						}else
						{
							if(m == null)
							System.out.println(a + " doesn't exist");
							else if(exx == null)
							System.out.println(b + " doesn't exist");
							else
							System.out.println("Both doesn't exist");
						}
						
					}else{
						try {
							throw new InputFormatException("");
						} catch (InputFormatException e) {
							// TODO Auto-generated catch block
							System.out.println(" Input Format is Wrong");
//							e.printStackTrace();
						}
					}
					actionMessage = null;
					flag = 0;
					break;
					default:try {
						throw new InputFormatException("");
					} catch (InputFormatException e) {
						// TODO Auto-generated catch block
						System.out.println(" Input Format is Wrong");
//						e.printStackTrace();
					}
					actionMessage = null;
					flag = 0;
				}
			}
		}
		
		
	}
	public void updatelist(Exchange e1){
		if(e1 == null) return;
		if(e1.child == null)
		{
			RoutingMapTree.elist.Insert(e1);
			updatelist(e1.left);
			return;
		}
		updatelist(e1.child);
		updatelist(e1.left);
	}
	public Exchange getRoot(){
		return root;
	}
	public RoutingMapTree() {
		Exchange e = new Exchange(0);
		elist = new ExchangeList();
		plist = new MobilePhoneSet();
		root = e;
		init = System.currentTimeMillis();
		actionMessage = null;
		start();
	}
	public boolean containsNode(int a){
		int f = 1;
		f = f*fin(root,a,f);
		if(f == 0)
			return true;
		else
			return false;
	}
	
	public int fin(Exchange exch , int a,int f){
		if(f == 0)
			return f;
		if(exch != null){
			if(exch.id == a)
				return 0;
			f = f*fin(exch.child,a,f);
			if(f == 0) return 0;
			f = f*fin(exch.left,a,f);
		}
		return f;
	}

	public Exchange findNode(int a){
		int f = 0;
		node = null;
		func(a,root,f);
		return node;
	}
	
	public void func(int a, Exchange e , int f){
		if(f == 1) return;
		if(e != null){
			if(e.id == a){
				node = e;
				f = 1;
				return;
			}
			func(a,e.child,f);
			func(a,e.left,f);
		}
		return;
	}
	
	public void addExchange(int a , int b){
		System.out.print("\n");
		Exchange naya = new Exchange(b);
		Exchange baap = new Exchange(0);
		if(containsNode(a) == true){
			baap = findNode(a);
			naya.parent = baap;
			if(baap.child == null){
				baap.child = naya;
				return;
			}else{
				if(baap.child.siblings.l.size() == 0){
					baap.child.siblings.l.addLast(naya);
//					System.out.println(baap.child.id);
					baap.child.left = naya;
				}else{
					baap.child.siblings.l.get(baap.child.siblings.l.size()-1).left = naya;
//					System.out.println(baap.child.siblings.l.get(baap.child.siblings.l.size()-1).id);
					baap.child.siblings.Insert(naya);
				}
			}
		}else{
			try {
				throw new NonExistentExchangeException("Exchange " + a + " doesn't exist!");
			} catch (NonExistentExchangeException e) {
				// TODO Auto-generated catch block
				System.out.println("Exchange " + a + " doesn't exist!");
//				e.printStackTrace();
			}
		}
	}
	
	public int queryNthChild(int a , int b){
		Exchange dhoond = new Exchange(0);
		dhoond = findNode(a);
		if(dhoond.child != null){
			if(b == 0){
				return dhoond.child.id;
			}
			if(dhoond.child.siblings.l.size() >= b){
				return dhoond.child.siblings.l.get(b-1).id;
			}else{
				try {
					throw new ChildOutOfBoundException("");
				} catch (ChildOutOfBoundException e) {
					// TODO Auto-generated catch block
					System.out.println(" Not this many children");
//					e.printStackTrace();
				}
			}
		}else{
			try {
				throw new ChildOutOfBoundException("");
			} catch (ChildOutOfBoundException e) {
				// TODO Auto-generated catch block
				System.out.println(" Not this many children");
//				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public String queryMobilePhoneSet(int a){
//		System.out.print(" : ");
		String sss = ": ";
		Exchange surya = new Exchange(69);
		MobilePhone zode = new MobilePhone(0);
		surya = findNode(a);
		int lim = surya.mps.m.l.size();
		for(int i = 0 ; i < lim ; i++){
			zode = (MobilePhone)surya.mps.m.l.get(i);
			if(zode.state == true)
			sss =  sss + zode.uid + " ";//System.out.print(zode.uid + " ");
		}
//		System.out.print("\n");
		return sss;
	}
	
	public void switchOnMobile(int a , int b){
		System.out.println();
		if(containsNode(b) == true){
			Exchange pal = new Exchange(69);
			pal = findNode(b);
			if(pal.mps.isMember(a) == true){
				plist.retPhone(a).switchOn();
				while(pal != null){
//					pal.mps.retPhone(a).todo = "switchOnMobile";
//					pal.mps.retPhone(a).notify();
					pal.mps.retPhone(a).switchOn();
					pal = pal.parent();
				}
			}else{
				if(pal.child == null){
					Exchange eee = new Exchange(0);
					eee = pal;
					while(pal != null){
						pal.mps.InsertMP(a);
						pal.mps.retPhone(a).R = root;
//						pal.mps.retPhone(a).todo = "switchOnMobile";
//						pal.mps.retPhone(a).notify();
						pal.mps.retPhone(a).switchOn();
						pal.mps.retPhone(a).setLocation(eee);
//						System.out.println(pal.mps.retPhone(a).location().id);
						pal = pal.parent();
					}
					tr = new Thread(eee.mps.retPhone(a),String.valueOf(eee.mps.retPhone(a).uid));
					tr.start();
				}else{
					try {
						throw new NotBaseException(" ");
					} catch (NotBaseException e) {
						// TODO Auto-generated catch block
						System.out.println("Not a Base Station");
//						e.printStackTrace();
					}
				}
			}
		}else{
			try {
				throw new NonExistentExchangeException("Exchange " + a + " doesn't exist!");
			} catch (NonExistentExchangeException e) {
				// TODO Auto-generated catch block
				System.out.println("Exchange " + a + " doesn't exist!");
//				e.printStackTrace();
			}
		}
	}
	public void updpl(){
		MobilePhone sau ;
		for(int i = 0 ; i < root.mps.m.l.size() ; i++)
		{
			sau = (MobilePhone)root.mps.m.l.get(i);
			plist.InsertMP(sau);
		}
/*		for(int i = 0 ; i < plist.m.l.size() ; i++)
		{
			sau = (MobilePhone)plist.m.l.get(i);
			System.out.println(sau.uid);
		}
*/	}
	
	public void switchOffMobile(int a){
		System.out.println();
		int f = 1;
		fk(a,root,f);
		if(f == 0) System.out.println(" Phone Doesn't Exist");
	}
	public void fk(int a , Exchange e, int f){
		if(e != null){
			if(e.mps.isMember(a) == true){
				f = 0;
//				e.mps.retPhone(a).todo = "switchOffMobile";
//				e.mps.retPhone(a).notify();
				e.mps.retPhone(a).switchOff();
			}
			fk(a,e.child,f);
			fk(a,e.left,f);
		}
		
	}

	public int findPhone(int m){
		Exchange val = new Exchange(0);
		MobilePhone mallu = new MobilePhone(0);
		mallu = root.mps.retPhone(m);
		if(mallu != null){
			val = mallu.location();
//			System.out.println(val.mps.isMember(m));
			return val.id;
		}
		else{
			return -1;
		}
	}
	
	public Exchange lowestRouter(Exchange a , Exchange b){
		Exchange temp1 = a;
		Exchange temp2 = b;
//		System.out.println(temp1.id + " " + temp2.id);
		while(temp1 != null){
			temp2 = b;
			while(temp2 != null){
				if(temp1.id == temp2.id) return temp1;
				temp2 = temp2.parent;
			}
			temp1 = temp1.parent;
		}
		return root;
	}
	
	public ExchangeList routeCall(MobilePhone a , MobilePhone b)
	{
		ExchangeList el = new ExchangeList();
		ExchangeList ll = new ExchangeList();
		Exchange suyash = a.location();
		Exchange yash = b.location();
		Exchange bambo = lowestRouter(a.location() , b.location());
		while(suyash.id != bambo.id && suyash!= null)
		{
			el.Insert(suyash);
			suyash = suyash.parent;
		}
		el.Insert(suyash);
		while(yash.id != suyash.id && yash != null){
			ll.Insert(yash);
			yash = yash.parent;
		}
//		System.out.println(ll.l.size());
		for(int i = ll.l.size()-1 ; i>=0 ; i-- ){
			bambo = (Exchange)ll.getI(i);
			el.Insert(bambo);
		}
		return el;
	}
	
	public void performAction(String some) {
		flag = 1;
		if(some.equals("end")) System.exit(0);
		if(some.equals("end") == false)
		System.out.print(some);
		String somethings[] = some.split("\\s");
		long tf = 0;
		int t0 = 0;
		try{
			t0 = Integer.parseInt(somethings[0]);
		}catch(NumberFormatException e){
			System.out.println("Number Format Exception!!");
		}
		tf = System.currentTimeMillis();
		while((tf-init) < t0*1000){
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				System.out.println("Interrupted");
			}
			tf = System.currentTimeMillis();
		}
		actionMessage = some;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
