
public class RecursiveContract extends Contract {
	private final Contract original_contract;
	private Contract current_contract;
	private final int rec_time;
	private int current_time;
	
	public RecursiveContract(Contract c, int rec_time) {
		this.original_contract = c;
		this.current_contract = c;
		this.rec_time = rec_time;
		this.current_time = rec_time;
	}
	
	@Override
	public Contract timestep(int elapsed_seconds) {
		current_contract = current_contract.timestep(elapsed_seconds);
		if(current_contract instanceof FalseContract) {
			return new FalseContract();
		}
		current_time -= elapsed_seconds;
		if(current_time <= 0) {
			current_time += rec_time;
			current_contract = original_contract;
		}
		return this;
	}
	
	@Override
	public Contract step(Event e) {
		current_contract = current_contract.step(e);
		if(current_contract instanceof FalseContract) {
			return new FalseContract();
		} else {
			return this;
		}
	}
	
	@Override
	public int timeout() {
		return current_contract.timeout();
	}
}
