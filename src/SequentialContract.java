
public class SequentialContract extends CompositionContract {
	public SequentialContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override 
	public Contract timestep(int n_seconds) {
		return new SequentialContract(lContract.timestep(n_seconds),
				rContract).syntacticalEq();
	}
	
	@Override
	public Contract step(Event e) {
		return new SequentialContract(lContract.step(e),
				rContract).syntacticalEq();
	}
	
	@Override
	public Contract syntacticalEq() {
		if(lContract instanceof TrueContract) { // Rule 9
			return rContract;
		} else if (lContract instanceof FalseContract) { // Rule 10
			return new FalseContract();
		} else {
			return this;
		}
	}

	@Override
	public int timeout() {
		return lContract.timeout();
	}
}
