
public abstract class Contract implements Cloneable {
	
	public Contract timestep(int elapsed_seconds) { return this; };
	public Contract step(Event event) { return this; };
	public Contract syntacticalEq() {return this; };
	public int timeout() { return Constants.pInf; };
	
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
