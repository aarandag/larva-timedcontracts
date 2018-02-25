
public class RecursiveContract extends Contract {
	private Contract original_contract;
	private Contract current_contract;
	private int rec_time;
	private int current_time;
	
	public RecursiveContract(Contract c, int rec_time) {
		this.original_contract = c.clone();
		this.current_contract = c;
		this.rec_time = rec_time;
		this.current_time = rec_time;
	}
	
	@Override
	public void timestep(int elapsed_seconds) {
		current_contract.timestep(elapsed_seconds);
		this.setViolated(current_contract.isViolated());
		current_time -= elapsed_seconds;
		if(current_time <= 0) {
			current_time += rec_time;
			current_contract = original_contract.clone();
		}
	}
	
	@Override
	public void step(Event e) {
		current_contract.step(e);
		this.setViolated(current_contract.isViolated());
	}
}
