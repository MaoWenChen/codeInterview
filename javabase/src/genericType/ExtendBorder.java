package genericType;

public class ExtendBorder {

}

interface HasColor {
	java.awt.Color getColor();
}

class Dimension {
	public int x, y, z;
}

class ColoredDimension<T extends Dimension & HasColor> {
	T item;

	public ColoredDimension(T t) {
		this.item = t;
	}

	T getItem() {
		return item;
	}

	java.awt.Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}
}