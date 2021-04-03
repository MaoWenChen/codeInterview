package base;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class ExceptionTest {

	public static void main(String[] args) {

		try {
			LoggingException exception = new LoggingException();
			exception.initCause(new NullPointerException());
			throw exception;
		}catch (LoggingException e) {
			// System.err.println("Caught " + e);
			e.printStackTrace(System.out);
		}

		try {
			throw new LoggingException();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
			for (StackTraceElement el : e.getStackTrace()) {
				System.out.println(el.getMethodName());
			}
			e.printStackTrace();
		}
	}
}

class LoggingException extends Exception {
	
	private static Logger logger = Logger.getLogger("LoggingException");

	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());

	}
}

class SubLoggingException extends LoggingException {

}

interface IException {
	public void event() throws Exception;
}

abstract class SuperExceptionTest {
	public SuperExceptionTest() throws LoggingException {
	}

	abstract void f() throws LoggingException;

	public void event() throws IOException {
	}
}

class SubExceptionTest extends SuperExceptionTest implements IException {
	/*
	 * SubExceptionTest() { 继承的异常声明不能丢失 }
	 */
	SubExceptionTest(int i) throws IOException, RuntimeException, Exception {
		// 子类异常可以多于父类异常
	}

	@Override
	public void event() {
		// 重写的方法的异常声明可以去掉
	}

	/*
	 * SubExceptionTest(String s)throws SubLoggingException{} 继承的异常声明不能变小
	 */
	@Override
	void f() throws SubLoggingException {

	}

	/*
	 * @Override void f() throws Exception,LoggingException {
	 * 重写的异常说明不能变多，也不能变小，只能是父类声明的异常或其子类 }
	 */
}