
public class DisjuctionContract extends CompositionContract {
	public DisjuctionContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override
	public Contract timestep(int elapsed_seconds) {
		return new DisjuctionContract(lContract.timestep(elapsed_seconds),
				rContract.timestep(elapsed_seconds)).syntacticalEq();
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
}
