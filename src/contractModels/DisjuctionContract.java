package contractModels;

public class DisjuctionContract extends CompositionContract {
	public DisjuctionContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override
	public Contract timestep(long elapsed_milliSeconds) {
		return new DisjuctionContract(lContract.timestep(elapsed_milliSeconds),
				rContract.timestep(elapsed_milliSeconds)).syntacticalEq();
	}
	
	@Override
	public Contract step(Event e) {
		return new DisjuctionContract(lContract.step(e),
				rContract.step(e)).syntacticalEq();
	}
	
	@Override
	public Contract syntacticalEq() {
		if(rContract instanceof TrueContract) { // Rule 5
			return new TrueContract();
		} else if (lContract instanceof TrueContract) { // Rule 6
			return new TrueContract();
		} else if (rContract instanceof FalseContract) { // Rule 7
			return lContract;
		} else if (lContract instanceof FalseContract) { // Rule 8
			return rContract;
		} else {
			return this;
		}
	}
	
	@Override
	public long timeout() {
		return Math.min(lContract.timeout(), rContract.timeout());
	}
}
