
public class ReparationContract extends CompositionContract {
	public ReparationContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override 
	public void timestep(int n_seconds) {
		if(!lContract.isViolated()) {
			lContract.timestep(n_seconds);
			this.setFulfilled(lContract.isFulfilled());
		} else {
			rContract.timestep(n_seconds);
			this.setViolated(rContract.isViolated());
			this.setFulfilled(rContract.isFulfilled());
		}
	}
	
	@Override
	public void step(Event e) {
		if(!lContract.isViolated()) {
			lContract.step(e);
			this.setFulfilled(lContract.isFulfilled());
		} else {
			rContract.step(e);
			this.setViolated(rContract.isViolated());
			this.setFulfilled(rContract.isFulfilled());
		}
	}
}
