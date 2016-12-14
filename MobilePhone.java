import java.util.Random;

public class MobilePhone implements Runnable{
	public Exchange R;
	public int uid;
	public boolean state;
	public Exchange e;
	public boolean busy;
	public static Exchange nw = null;
	public static MobilePhone m1;
	
	public void run(){
//		System.out.println(uid + " started running");
		if(assn2checker.randomsim = true)
		{
			Random rr = new Random();
			int j,w;
			while(true)
			{
//				System.out.println(assn2checker.sim);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(assn2checker.starting)
				{
					w = rr.nextInt(5000);
					try {
						Thread.sleep(w);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					j = rr.nextInt(4);
					switch(j){
					case 0:
//						System.out.println(this.state);
						if(this.state == false) continue;
						else
						{
							this.state = false;
							Exchange ran = this.e;
							while(ran != null)
							{
//								if(ran.mps.isMember(uid)) System.out.println(ran.id);
//								if(ran.mps.retPhone(uid) == null) System.out.println(ran.id +"haww");
//								System.out.println(ran.mps.isMember(this.uid) + " " + ran.id);
								ran.mps.retPhone(this.uid).switchOff();
								ran = ran.parent;
							}
							System.out.println(uid + " Switching off");
						}
						break;
					case 1:
						if(this.state == true) continue;
						else
						{
							this.state = true;
							Exchange ran = RoutingMapTree.plist.retPhone(uid).location();
							while(ran != null)
							{
								ran.mps.retPhone(uid).switchOn();
								ran = ran.parent;
							}
							System.out.println(uid + " Switching on");
						}
						break;
					case 2:
						int s;
						Exchange b;
						while(true)
						{
							s = rr.nextInt(RoutingMapTree.elist.l.size());
							b = (Exchange)RoutingMapTree.elist.getI(s);
							if(b.id != this.e.id) break;
						}
						System.out.println(uid + " moving from " + this.e.id + " to " + b.id);
						this.e = b;
						Exchange ae = this.e;
						while(ae != null)
						{
							ae.mps.DeleteMP(uid);
							ae = ae.parent;
						}
						ae = b;
						while(ae != null)
						{
							ae.mps.InsertMP(uid);
							ae.mps.retPhone(uid).setLocation(b);
							ae.mps.retPhone(uid).R = this.R;
							ae.mps.retPhone(uid).busy = this.busy;
							ae.mps.retPhone(uid).state = this.state;
							ae = ae.parent;
						}
//						System.out.println(uid + " moving from " + this.e.id + " to " + b.id);
						break;
					case 3:
						int dslr;
						MobilePhone prar ;
//						System.out.println(this.state);
/*						if(this.state == false && this.busy == true)
						{
							continue;
						}
						else */
						if(this.state == true && this.busy == false)
						{
							while(true){
								dslr = rr.nextInt(RoutingMapTree.plist.m.l.size());
								prar = (MobilePhone)RoutingMapTree.plist.m.l.get(dslr); 
								if(this.uid != prar.uid) break;
							}
							System.out.print(this.uid + " calling " + prar.uid);
							if(prar.state == false) System.out.println(" Phone Switched Off");
							else if(prar.busy == true) System.out.println(" Phone busy");
							else System.out.println();
							dslr = rr.nextInt(5);
							this.busy = true;
							prar.busy = true;
							long thana = System.currentTimeMillis();
							while(true)
							{
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								if(System.currentTimeMillis() - thana > dslr*1000) break;
							}
							this.busy = false;
							prar.busy = false;
						}
						break;
					}
				}
			}
		}
	}
	
	public MobilePhone(int number){
		uid = number;
		state = false;
	}
	public int number(){
		return uid;
	}
	public boolean status(){
		return state;
	}
	public void switchOn(){
		state = true;
	}
	public void switchOff(){
		state = false;
	}
	public Exchange location(){
		return e;
	}
	public void setLocation(Exchange ex){
		e = ex;
	}

}
