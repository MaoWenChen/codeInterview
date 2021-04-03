package chain;

/**
 * 责任链设计模式 1.抽象的处理者 2.具体的处理链
 * 
 * 应用
 * 		1.Servlet的Filter
 * 		2.springmvc中的HandlerChain
 * 		3.aop中的Intercepterchain	
 */
public class ResChain {

}

abstract class Handler {

	protected Handler nextHandler; // 下一个责任链成员

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	// 处理传递过来的时间
	public abstract void handleMessge(int type);

}

class ConcreteHandler1 extends Handler {

	@Override
	public void handleMessge(int type) {
		if (type == 2 || type == 0) {
			// 自己解决
			System.out.println("ConcreteHandler1解决了问题");
		} else {
			System.out.println("ConcreteHandler1解决不了问题");
			if (nextHandler != null) {
				// 传给下一个人去解决
				nextHandler.handleMessge(type);
			} else {
				System.out.println("没有人能解决");
			}
		}

	}

}

class ConcreteHandler2 extends Handler {

	@Override
	public void handleMessge(int type) {
		if (type == 4 || type == 0) {
			// 自己解决
			System.out.println("ConcreteHandler2解决了问题");
		} else {
			System.out.println("ConcreteHandler2解决不了问题");
			if (nextHandler != null) {
				// 传给下一个人去解决
				nextHandler.handleMessge(type);
			} else {
				System.out.println("没有人能解决");
			}
		}

	}

}
