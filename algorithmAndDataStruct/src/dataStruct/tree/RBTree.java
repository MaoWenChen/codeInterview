package dataStruct.tree;

import java.util.Map;


public class RBTree<K, V> {
	private Entry<K, V> root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	public static void  main(String[] args) throws Exception {
		RBTree<Integer, Integer> rbTree = new RBTree<>();
		for (int i = 0; i < 10; i++) {
			rbTree.put(i, i);
		}
		rbTree.remove(2);
		rbTree.remove(5);
		rbTree.dfs();
		
	}
	private void dfsPrivate(Entry<K, V> root) {
		if (root != null) {
			dfsPrivate(root.left);
			System.out.println(root.getKey());
			dfsPrivate(root.right);
		}
	}
	public void dfs() {
		dfsPrivate(this.root);
	}
	
	public V  put(K key, V value) throws Exception {
		Entry<K, V> current = root;
		if (current == null) {
			this.root = new Entry<>(key, value, null);
			return null;
		}
		Entry<K, V> parent ;
		if (key == null) {
			throw new Exception();
		}
		Comparable<? super K> k = (Comparable<? super K>)key;
		do{
			parent = current;
			if (k.compareTo(current.key) < 0) {
				current = current.left;
			}else if (k.compareTo(current.key) > 0) {
				current = current.right;
			}else{
				return current.setValue(value);
			}
		}while(current != null);
		Entry<K, V> entry = new Entry<>(key, value, parent);
		entry.Color = RED;
		if (k.compareTo(parent.key) < 0) {
			parent.left = entry;
		}else {
			parent.right = entry;
		}
		fixShiftEntry( entry);
		return null;
	}
	//删除节点
	public V remove(K key) {
		Entry<K, V> current = root;
		Comparable<K> k = (Comparable<K>) key;
		while(current != null && !key.equals(current.getKey())) {
			if (k.compareTo( current.getKey()) < 0 ) {
				current = current.left;
			}else if (k.compareTo(current.getKey()) > 0 ) {
				current = current.right;
			}else {
				break;
			}
		}
		if (current == null) {
			return null;
		}
		if (current.left != null && current.right != null) {
			Entry<K, V> tmp = afterNode(current);
			current.key = tmp.key;
			current = tmp;
		}
		Entry<K, V> temp = current.left != null ? current.left : current.right;
		if (temp != null) {
			if (current.parent == null) {
				this.root = temp;
			}else {
				temp.parent = current.parent;
				if (current.parent.left == current) {
					current.parent.left = temp;
				}else {
					current.parent.right = temp;
				}
			}
			afterDeleteFix_up(temp);
		}else if (current.parent == null) {
			this.root = null;
		}else {
			if (colorof(current) == BLACK) {
				afterDeleteFix_up(current);
			}
			
			if (current.parent.left == current) {
					current.parent.left = null;
			}else {
					current.parent.right = null;
			}
			
		}
		return current.value;
		
	}
	private boolean colorof(Entry<K, V> x) {
		return x == null ? BLACK : x.Color;
	}
	//删除调整
	private void afterDeleteFix_up(Entry<K, V> x) {
		while(x != root && colorof(x) == BLACK) {
			if (x.parent.left == x) {
				Entry<K, V> sid = x.parent.right;
				if (colorof(sid) == RED) {
					sid.Color = BLACK;
					x.parent.Color = RED;
					rightRotation(x.parent);
					sid = x.parent.right;
				}
				if (sid != null && colorof( sid.left) == BLACK && colorof(sid.right) == BLACK) {
					sid.Color = RED;
					x = x.parent;
				}else {
					if (colorof(sid.left) == RED) {
						sid.Color = RED;
						sid.left.Color = BLACK;
						rightRotation(sid);
						sid = x.parent.right;
					}
					sid.Color = x.parent.Color;
					x.parent.Color = BLACK;
					sid.right.Color = BLACK;
					leftRotation(x.parent);
					x = root;
				}
			}else {
				Entry<K, V> sid = x.parent.left;
				if (colorof(sid) == RED) {
					x.parent.Color = RED;
					sid.Color = BLACK;
					rightRotation(x.parent);
					sid = x.parent.left;
				}
				if (sid != null && colorof( sid.left) == BLACK && colorof(sid.right ) == BLACK) {
					sid.Color = RED;
					x = x.parent;
				}else {
					if (colorof(sid.right) == RED) {
						sid.Color = RED;
						sid.right.Color = BLACK;
						leftRotation(sid);
						sid = x.parent.left;
					}
					sid.Color = x.parent.Color;
					x.parent.Color = BLACK;
					sid.left.Color = BLACK;
					rightRotation(x.parent);
					x = root;
				}
				
			}
		}
		x.Color = BLACK;
		
	}
	//寻找后继节点
	private Entry<K, V> afterNode(Entry<K, V> p){
		Entry<K, V> e = p.left;
		while(e.right != null)e = e.right;
		return e;
	}
	
	private void fixShiftEntry(Entry<K, V> p) {
		while(p != null && p.parent != null && p.parent.Color == RED) {
			if (p.parent == p.parent.parent.left) {
				Entry<K, V> y = p.parent.parent.right;
				if (y != null && y.Color == RED) {
					p.parent.Color = BLACK;
					y.Color = BLACK;
					p.parent.parent.Color = RED;
					p = p.parent.parent;
				}else {
					if (p == p.parent.right) {
						p = p.parent;
						leftRotation(p);
					}
					p.parent.Color = BLACK;
					p.parent.parent.Color = RED;
					rightRotation(p.parent.parent);
				}
			}else {
				Entry<K, V> y = p.parent.parent.left;
				if (y !=null && y.Color == RED) {
					p.parent.Color = BLACK;
					y.Color = BLACK;
					p = p.parent.parent;
					p.Color = RED;
				}else {
					if (p == p.parent.left) {
						p = p.parent;
						rightRotation(p);
					}
					p.parent.Color = BLACK;
					p.parent.parent.Color = RED;
					p = p.parent.parent;
					leftRotation(p);
				}
				
			}
			
		}
		this.root.Color = BLACK;
	}
	private void leftRotation(Entry<K, V> p) {
		Entry<K, V> pr = p.right;
		p.right = pr.left;
		if (pr.left != null) {
			pr.left.parent = p;
		}
		pr.parent = p.parent;
		if (p.parent != null) {
			if (p.parent.left == p) {
				p.parent.left = pr;
			}else {
				p.parent.right = pr;
			}
		}else {
			this.root = pr;
		}
		pr.left = p;
		p.parent = pr;
		
	}
	private void rightRotation(Entry<K, V> p) {
		Entry<K, V> pl = p.left;
		p.left = pl.right;
		if (pl.right != null) {
			pl.parent = p;
		}
		pl.parent = p.parent;
		if(p.parent != null) {
			if (p == p.parent.left) {
				p.parent.left = pl;
			}else {
				p.parent.right = pl;
			}
		}else {
			this.root = pl;
		}
		pl.right = p;
		p.parent = pl;
	}


	static final class Entry<K, V> implements Map.Entry<K, V>{
		K key;
		V value;
		Entry left;
		Entry right;
		Entry parent;
		
		boolean Color = BLACK;
		
		Entry(K key, V value, Entry<K, V> parent) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.value = value;
			this.parent = parent;
		}
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}

		@Override
		public V setValue(V value) {
			// TODO Auto-generated method stub
			 V oldValue = this.value;
	         this.value = value;
	         return oldValue;
		}
		@Override
		public boolean equals(Object o) {
			if(!(o instanceof Map.Entry))
				return false;
			Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
			return valueEquals(key, e.getKey()) && valueEquals( value, e.getValue());
		}
		@Override
		public int hashCode() {
			int keyHash = key == null ? 0 : key.hashCode();
			int valueHash = value == null ? 0 : value.hashCode();
			return keyHash ^ valueHash;
		}
	}
	
	private static boolean valueEquals(Object o1,Object o2) {
		return o1 == null ? o2 == null: o1.equals(o2);
	}
}
