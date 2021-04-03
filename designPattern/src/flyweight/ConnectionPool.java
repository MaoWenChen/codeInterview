package flyweight;
/**
 * 数据库连接池
 * @author mchen
 *
 */

import java.util.LinkedList;

public class ConnectionPool {

	private LinkedList<Connection> pool = new LinkedList<>();

	public ConnectionPool(int size) {
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				pool.add(new Connection());
			}
		}
	}

	public void releaseConnection(Connection con) {
		if (con != null) {
			synchronized (pool) {
				pool.addLast(con);
				pool.notify();
			}
		}
	}

	// 在millis毫秒内无法获取连接返回null
	public Connection fetchConnection(long millis) throws InterruptedException {
		synchronized (pool) {
			if (millis <= 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.remove();
			} else {
				long future = System.currentTimeMillis();
				long remaining = millis;
				while (pool.isEmpty() && remaining > 0) {
					pool.wait(remaining);
					remaining = System.currentTimeMillis() - future;
				}
				Connection res = null;
				if (!pool.isEmpty()) {
					res = pool.remove();
				}
				return res;
			}

		}

	}

}
