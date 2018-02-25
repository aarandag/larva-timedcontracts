
public class SequentialContract extends CompositionContract {
	public SequentialContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override 
	public void timestep(int n_seconds) {
		if(!lContract.isFulfilled()) {
			lContract.timestep(n_seconds);
			this.setViolated(lContract.isViolated());
		} else {
			rContract.timestep(n_seconds);
			this.setViolated(rContract.isViolated());
			this.setFulfilled(rContract.isFulfilled());
		}
	}
	
	@Override
	public void step(Event e) {
		if(!lContract.isFulfilled()) {
			lContract.step(e);
			this.setViolated(lContract.isViolated());
		} else {
			rContract.step(e);
			this.setViolated(rContract.isViolated());
			this.setFulfilled(rContract.isFulfilled());
		}
	}

}
