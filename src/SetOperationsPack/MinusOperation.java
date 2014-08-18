package SetOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.IBinaryContant;

public class MinusOperation extends GenericSetOperation {

	public MinusOperation() {
		super(EFilterKey.MINUS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute(int a, int b) {
		return a==IBinaryContant.ONE && b==IBinaryContant.ZERO ? IBinaryContant.ONE : IBinaryContant.ZERO;
	}

}
