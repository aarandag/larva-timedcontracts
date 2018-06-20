package exampleBoardingSystem;
import java.util.Random;

public class Main implements Runnable{

	public void run()
	{
	    Passenger p = new Passenger();
	    int count = 0;
	    while(count < 10) {
		try {
		Thread.sleep(100);
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
		System.out.println("[Main] Check in!");
		p.checkin();
		count++;
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
