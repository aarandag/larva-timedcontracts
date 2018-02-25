
public abstract class CompositionContract extends Contract {
	protected Contract lContract;
	protected Contract rContract;
	
	public CompositionContract(Contract lContract, Contract rContract) {
		this.lContract = lContract;
		this.rContract = rContract;
	}
}
