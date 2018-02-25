
public class ConjuctionContract extends CompositionContract {
	public ConjuctionContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	} 
	
	@Override
	public void timestep(int elapsed_seconds) {
		lContract.timestep(elapsed_seconds);
		rContract.timestep(elapsed_seconds);
		this.setViolated(lContract.isViolated() || rContract.isViolated());
		this.setFulfilled(lContract.isFulfilled() && rContract.isFulfilled());
	}
	
	@Override
	public void step(Event e) {
		lContract.step(e);
		rContract.step(e);
		this.setViolated(lContract.isViolated() || rContract.isViolated());
		this.setFulfilled(lContract.isFulfilled() && rContract.isFulfilled());
	}
}
