package SetOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.IBinaryContant;

public class ComplementOperation extends GenericSetOperation {

	public ComplementOperation() {
		super(EFilterKey.COMPLEMENT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute(int a, int b) {
		return a == IBinaryContant.ONE ? IBinaryContant.ZERO : IBinaryContant.ONE;
	}

}
