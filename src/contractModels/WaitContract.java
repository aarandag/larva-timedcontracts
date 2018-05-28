package contractModels;

public class WaitContract extends Contract {
	private final long n_milliSeconds;
	
	public WaitContract(long n_milliSeconds) {
		this.n_milliSeconds = n_milliSeconds;
	}
	
	@Override
	public Contract timestep(long n_milliSeconds) {
		return new WaitContract(this.n_milliSeconds - n_milliSeconds).syntacticalEq();
	}
	
	@Override
	public Contract syntacticalEq() {
		if(n_milliSeconds <= 0) { // Rule 16
			return new TrueContract();
		} else {
			return this;
		}
	}
	
	@Override
	public long timeout() {
		return n_milliSeconds;
	}
}
