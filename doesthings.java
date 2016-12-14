public class doesthings extends Thread{
	public static int t;
	public doesthings(int yep)
	{
		t = yep;
		start();
	}
	public void run(){
		while(true)
		{
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(System.currentTimeMillis() - assn2checker.sim > t*1000)
				{
				System.out.println("Simulation Ends!!!");
				System.exit(0);
				}
		}
	}
}
