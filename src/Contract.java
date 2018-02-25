
public abstract class Contract implements Cloneable {
	private boolean isViolated = false;
	private boolean isFulfilled = false;
	
	public void timestep(int elapsed_seconds) {};
	public void step(Event event) {};
	
	public boolean isViolated() { return isViolated; }
	public boolean isFulfilled() { return isFulfilled; }
	protected void setViolated(boolean isViolated) {
		if(!this.isViolated) {
			this.isViolated = isViolated;
			if(isViolated) {
				this.isFulfilled = false;
			}
		}
	}
	protected void setFulfilled(boolean isFulfilled) { 
		if(!this.isViolated) {
			this.isFulfilled = isFulfilled; 
			if(isFulfilled) {
				this.isViolated = false;
			}
		}
	}
	
	@Override
	protected Contract clone() {
		try {
			return (Contract) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
