
public class ObligationContract extends Contract {
	private Event event;
	private int n_seconds;
	
	public ObligationContract(Event event, int n_seconds) {
		this.event = event;
		this.n_seconds = n_seconds;
	}
	
		@Override
		public void timestep(int n_seconds) {
			this.n_seconds -= n_seconds;
			if(this.n_seconds <= 0) {
				setViolated(true);
			}
		}
		
		@Override
		public void step(Event event) {
			if(event.equals(this.event)) {
				setFulfilled(true);
			}
		}
}
