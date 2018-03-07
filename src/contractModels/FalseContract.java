package contractModels;

public class FalseContract extends Contract {
	@Override
	public int timeout() {
		return Constants.pInf;
	}
}
