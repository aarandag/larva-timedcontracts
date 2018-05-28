package contractModels;

public class ObligationContract extends Contract {
	private final Event event;
	private final long n_milliSeconds;
	
	public ObligationContract(Event event, long n_seconds) {
		this.event = event;
		this.n_milliSeconds = n_seconds;
	}
	
	@Override
	public Contract timestep(long n_seconds) {
		return new ObligationContract(event, 
				this.n_milliSeconds - n_seconds).syntacticalEq();
	}
		
	@Override
	public Contract step(Event event) {
		if(event.equals(this.event)) {
			return new TrueContract();
		} else {
			return this;
		}
	}
		
	@Override 
	public Contract syntacticalEq() {
		if(n_milliSeconds <= 0) { // Rule 13
			return new FalseContract();
		} else {
			return this;
		}
	}
	
	@Override
	public long timeout() {
		return n_milliSeconds;
	}
}
