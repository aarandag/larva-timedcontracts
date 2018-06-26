package contractModels;

public class RecursiveContract extends Contract {
	private final Contract original_contract;
	private Contract current_contract;
	
	public RecursiveContract(Contract c) {
		this.original_contract = c;
		this.current_contract = c;
	}
	
	@Override
	public Contract timestep(long elapsed_milliSeconds) {
		current_contract = current_contract.timestep(elapsed_milliSeconds);
		if(current_contract instanceof FalseContract) {
			return new FalseContract();
		} else if(current_contract instanceof TrueContract) {
		        current_contract = original_contract;
		}
		return this;
	}
	
	@Override
	public Contract step(Event e) {
		current_contract = current_contract.step(e);
		if(current_contract instanceof FalseContract) {
			return new FalseContract();
		} else if(current_contract instanceof TrueContract) {
		        current_contract = original_contract;
		}
		return this;
	}
	
	@Override
	public long timeout() {
		return current_contract.timeout();
	}
}
