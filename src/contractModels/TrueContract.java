package contractModels;

public class TrueContract extends Contract {
	@Override
	public long timeout() {
		return Constants.pInf;
	}
}
