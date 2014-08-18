package GenericClass;

public class Tuple<T,R> {

    private T value1;
    private R value2;
    
    /**
     * @param value1 - o valor 1
     * @param value2 - o valor 2
     */
    public Tuple(T value1, R value2) {
            this.value1 = value1;
            this.value2 = value2;
    }

    /**
     * @return value1 - o primeiro valor
     */
    protected T getValue1() {
            return value1;
    }

    /**
     * @return value2 - o segundo valor
     */
    protected R getValue2() {
            return value2;
    }

	@Override
	public boolean equals(Object obj) {
		Tuple  t = (Tuple)obj; 
		if(t.value1 == this.value1 && t.value2 == this.value2)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {		
		return ("(" + this.value1 + ", " + this.value2 + ")");
	}
    
    
    
}
