package 刘文杰homework_old.hmk_0620;

public class Pair<T> {
	
	private T first;
	private T second;

	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
	@Override
	public String toString() {
		return "Pair [Max=" + first + ", Min=" + second + "]";
	}
	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}
	public Pair() {
		super();

	}

	public static<T> void swap(T[] arr,int i , int j) {
		T temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

}
