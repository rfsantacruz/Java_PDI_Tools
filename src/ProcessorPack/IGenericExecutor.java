package ProcessorPack;

import GenericClass.GenericFilter;
import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;

public interface IGenericExecutor {

	EFilterKey getFilterIdentity();
	EFilterType getTypeFilter();
	void setFilter(GenericFilter filter);
	GenericFilter getFilter();
}
