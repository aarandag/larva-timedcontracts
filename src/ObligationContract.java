
public class ObligationContract extends Contract {
	private final Event event;
	private final int n_seconds;
	
	public ObligationContract(Event event, int n_seconds) {
		this.event = event;
		this.n_seconds = n_seconds;
	}
	
	@Override
	public Contract timestep(int n_seconds) {
		return new ObligationContract(event, 
				this.n_seconds - n_seconds).syntacticalEq();
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
		if(n_seconds <= 0) { // Rule 13
			return new FalseContract();
		} else {
			return this;
		}
	}
}
