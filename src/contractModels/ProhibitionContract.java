package contractModels;

public class ProhibitionContract extends Contract {
	private final Event event;
	private final long n_milliSeconds;
	
	public ProhibitionContract(Event event, long n_seconds) {
		this.event = event;
		this.n_milliSeconds = n_seconds;
	}
	
	@Override
	public Contract timestep(long n_milliSeconds) {
		return new ProhibitionContract(event, 
				this.n_milliSeconds - n_milliSeconds).syntacticalEq();
	}
	
	@Override
	public Contract step(Event event) {
		if(event.equals(this.event)) {
			return new FalseContract();
		} else {
			return this;
		}
	}
	
	@Override
	public Contract syntacticalEq() {
		if(n_milliSeconds <= 0) {
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
