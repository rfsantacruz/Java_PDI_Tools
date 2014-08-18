package SetOperationsPack;

import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;
import constraintsPack.IBinaryContant;
import GenericClass.GenericFilter;

public abstract class GenericSetOperation extends GenericFilter {

	public GenericSetOperation(EFilterKey identity) {
		super(identity, EFilterType.SETOPERATIONS);
		// TODO Auto-generated constructor stub
	}

	public abstract int execute(int a , int b);
	
}
