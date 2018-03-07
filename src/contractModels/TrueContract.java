package contractModels;

public class TrueContract extends Contract {
	@Override
	public int timeout() {
		return Constants.pInf;
	}
}
