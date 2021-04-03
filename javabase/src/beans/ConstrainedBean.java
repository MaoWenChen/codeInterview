package beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyEditorSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class ConstrainedBean {
	private String name;

	private PropertyChangeSupport changes = new PropertyChangeSupport(this);
	private VetoableChangeSupport vetoChanges = new VetoableChangeSupport(this);

	public String getName() {
		return name;
	}

	public void setName(String name) throws PropertyVetoException {

		String old = this.name;

		vetoChanges.fireVetoableChange("name", old, name);
		this.name = name;
		changes.firePropertyChange("name", old, name);
	}

	public void addChangeListener(PropertyChangeListener l) {
		changes.addPropertyChangeListener(l);
	}

	public void removeChangeListener(PropertyChangeListener l) {
		changes.removePropertyChangeListener(l);
	}

	public void addVetoChangeListener(VetoableChangeListener l) {
		vetoChanges.addVetoableChangeListener(l);
	}

	public void removeVetoChangeListener(VetoableChangeListener l) {
		vetoChanges.removeVetoableChangeListener(l);
	}

}
