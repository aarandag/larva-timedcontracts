package contractModels;

public class FalseContract extends Contract {
	@Override
	public long timeout() {
		return Constants.pInf;
	}
}
