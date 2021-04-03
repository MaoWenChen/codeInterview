package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BundleBean {

	private String ourString = "Hello";
	private PropertyChangeSupport changes = new PropertyChangeSupport(this);


	public String getOurString() {
		return ourString;
	}

	public void setOurString(String ourString) {
		String old = this.ourString;
		this.ourString = ourString;
		changes.firePropertyChange("ourString", old, ourString);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}
}

class Type<V> {

	public void test(V v) throws InstantiationException, IllegalAccessException {
		System.out.println(v.getClass());
		System.out.println(v.getClass().newInstance() + "666");
	}
}

