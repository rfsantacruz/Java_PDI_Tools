package SetOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.IBinaryContant;

public class IntersectOperation extends GenericSetOperation {

	public IntersectOperation() {
		super(EFilterKey.INTERSECT);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute(int a, int b) {
		return a==IBinaryContant.ONE && b==IBinaryContant.ONE ? IBinaryContant.ONE : IBinaryContant.ZERO;
	}

}
