package GenericClass;
import constraintsPack.EFilterKey;
import constraintsPack.EFilterType;


public abstract class GenericFilter {

	private EFilterKey identity;
	private EFilterType type;
	
	
	public GenericFilter(EFilterKey identity, EFilterType type) {
		super();
		this.identity = identity;
		this.type = type;
	}
	public EFilterKey getIdentity() {
		return identity;
	}
	public void setIdentity(EFilterKey identity) {
		this.identity = identity;
	}
	public EFilterType getType() {
		return type;
	}
	public void setType(EFilterType type) {
		this.type = type;
	}
	
	
}
