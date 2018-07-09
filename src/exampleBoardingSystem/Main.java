package exampleBoardingSystem;
import java.util.Random;

public class Main implements Runnable {

	public void run() 
	{
	    Passenger p = new Passenger();

	    try {
		Thread.sleep(600);
		p.GBCh();
		Thread.sleep(400);
		p.ShP();
		Thread.sleep(1000);
		p.dliq();
		System.out.println("[Main] Finished!");
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    }

	}
	
	
	public void initialize()
	{}
	
	public static void main(String [] args)
	{
		Main m = new Main();
		m.initialize();
		new Thread(m).start();
	}
}
