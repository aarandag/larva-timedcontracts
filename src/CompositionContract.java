
public abstract class CompositionContract extends Contract {
	protected final Contract lContract;
	protected final Contract rContract;
	
	public CompositionContract(Contract lContract, Contract rContract) {
		this.lContract = lContract;
		this.rContract = rContract;
	}
}
