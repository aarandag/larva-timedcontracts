package contractModels;

public class SequentialContract extends CompositionContract {
	public SequentialContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override 
	public Contract timestep(long n_milliSeconds) {
		return new SequentialContract(lContract.timestep(n_milliSeconds),
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
	public long timeout() {
		return lContract.timeout();
	}
}
