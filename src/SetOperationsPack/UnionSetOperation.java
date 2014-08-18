package SetOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.IBinaryContant;

public class UnionSetOperation extends GenericSetOperation {

	public UnionSetOperation() {
		super(EFilterKey.UNION);
	}

	@Override
	public int execute(int a, int b) {
		return a == IBinaryContant.ONE || b == IBinaryContant.ONE ? IBinaryContant.ONE : IBinaryContant.ZERO;
	}

}
