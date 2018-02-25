
public class WaitContract extends Contract {
	private final int n_seconds;
	
	public WaitContract(int n_seconds) {
		this.n_seconds = n_seconds;
	}
	
	@Override
	public Contract timestep(int n_seconds) {
		return new WaitContract(this.n_seconds - n_seconds).syntacticalEq();
	}
	
	@Override
	public Contract syntacticalEq() {
		if(n_seconds <= 0) { // Rule 16
			return new TrueContract();
		} else {
			return this;
		}
	}
}
