package contractModels;

public class ProhibitionContract extends Contract {
	private final Event event;
	private final int n_seconds;
	
	public ProhibitionContract(Event event, int n_seconds) {
		this.event = event;
		this.n_seconds = n_seconds;
	}
	
	@Override
	public Contract timestep(int n_seconds) {
		return new ProhibitionContract(event, 
				this.n_seconds - n_seconds).syntacticalEq();
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
		if(n_seconds <= 0) {
			return new TrueContract();
		} else {
			return this;
		}
	}
	
	@Override
	public int timeout() {
		return n_seconds;
	}
}
