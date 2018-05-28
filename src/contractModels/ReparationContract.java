package contractModels;

public class ReparationContract extends CompositionContract {
	public ReparationContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override 
	public Contract timestep(long n_milliSeconds) {
		return new ReparationContract(lContract.timestep(n_milliSeconds),
				rContract).syntacticalEq();
	}
	
	@Override
	public Contract step(Event e) {
		return new ReparationContract(lContract.step(e),
				rContract).syntacticalEq();
	}
	
	@Override 
	public Contract syntacticalEq() {
		if(lContract instanceof TrueContract) { // Rule 11
			return new TrueContract();
		} else if (lContract instanceof FalseContract) { // Rule 12
			return rContract;
		} else {
			return this;
		}
	}
	
	@Override
	public long timeout() {
		return lContract.timeout();
	}
}
