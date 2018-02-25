
public class ReparationContract extends CompositionContract {
	public ReparationContract(Contract lContract, Contract rContract) {
		super(lContract, rContract);
	}
	
	@Override 
	public Contract timestep(int n_seconds) {
		return new ReparationContract(lContract.timestep(n_seconds),
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
	public int timeout() {
		return lContract.timeout();
	}
}
