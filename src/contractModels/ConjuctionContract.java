package contractModels;

public class ConjuctionContract extends CompositionContract {
	public ConjuctionContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	} 
	
	@Override
	public Contract timestep(long elapsed_milliSeconds) {
		return new ConjuctionContract(lContract.timestep(elapsed_milliSeconds),
				rContract.timestep(elapsed_milliSeconds)).syntacticalEq();
	}
	
	@Override
	public Contract step(Event e) {
		return new ConjuctionContract(lContract.step(e), 
				rContract.step(e)).syntacticalEq();
	}
	
	@Override
	public Contract syntacticalEq() {
		if(rContract instanceof TrueContract) { // Rule 1
			return lContract;
		} else if (lContract instanceof TrueContract) { // Rule 2
			return rContract;
		} else if (lContract instanceof FalseContract) { // Rule 3
			return new FalseContract();
		} else if (rContract instanceof FalseContract) { // Rule 4
			return new FalseContract();
		} else {
			return this;
		}
	}
	
	@Override
	public long timeout() {
		return Math.min(lContract.timeout(), rContract.timeout());
	}
}
