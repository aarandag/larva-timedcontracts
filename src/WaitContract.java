
public class WaitContract extends Contract {
	private int n_seconds;
	
	public WaitContract(int n_seconds) {
		this.n_seconds = n_seconds;
	}
	
	@Override
	public void timestep(int elapsed_seconds) {
		n_seconds -= elapsed_seconds;
		if(n_seconds <= 0) {
			this.setFulfilled(true);
		}
	}
}
