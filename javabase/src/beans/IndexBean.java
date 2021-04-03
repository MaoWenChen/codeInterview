package beans;

public class IndexBean {

	public int[] getIndexs() {
		return indexs;
	}

	public void setIndexs(int[] indexs) {
		this.indexs = indexs;
	}

	public void setIndexs(int index, int value) {
		this.indexs[index] = value;
	}

	public int getIndexs(int index) {
		return indexs[index];
	}

	private int[] indexs;
}
