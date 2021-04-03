package strategy;
/**
 * 策略设计模式
 * 
 * 	定义一系列的算法，把它们一个个封装起来，并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
 * 	根据不同的场景切换不同的算法 
 * 	3要素
 * 	1.抽象策略(Strategy)：通常由接口或抽象类实现。定义了多个具体策略的公共接口，具体策略类中各种不同的算法以不同的方式实现这个接口；Context使用这些接口调用不同实现的算法。
　　2.具体策略(ConcreteStrategy)：实现Strategy接口或继承于抽象类Strategy，封装了具体的算法和行为。
　　3.环境类(Contex)：持有一个公共策略接口的引用，直接给客户端调用。
 * @author 
 *spring中在实例化对象的时候用到Strategy模式 InstantiationStrategy
 */
public class StrategyTest {
	public static void main(String[] args) {
		//创建执行上下文
		PayStrategyContext context = new PayStrategyContext();
		IPayStrategy payStrategy = null;
		//支付宝支付
		payStrategy = new AliPayStrategy();
		context.setPayStrategy(payStrategy);
		context.excutePay();
		//微信支付
		payStrategy = new WenxinPayStrategy();
		context.setPayStrategy(payStrategy);
		context.excutePay();
		//银联支付
		payStrategy = new EBankPayStrategy();
		context.setPayStrategy(payStrategy);
		context.excutePay();
	}
}

////////////////////////////支付策略//////////////////////////////////////////////

/**
 * 定义一个支付策略
 */
interface IPayStrategy{
	void pay();
}
/**
 * 定义微信支付的策略
 */
class WenxinPayStrategy implements IPayStrategy{

	@Override
	public void pay() {
		System.out.println("微信支付策略");
		
	}
	
}
/**
 * 定义支付宝支付的策略
 */
class AliPayStrategy implements IPayStrategy{

	@Override
	public void pay() {
		System.out.println("阿里支付策略");
		
	}
	
}
/**
 * 定义银联支付的策略
 */
class EBankPayStrategy implements IPayStrategy{

	@Override
	public void pay() {
		System.out.println("银联支付策略");
		
	}
	
}
/**
 * 定义负责调度执行策略的上下文
 */
class PayStrategyContext{
	private IPayStrategy payStrategy;
	
	public void excutePay() {
		if (null == payStrategy) {
			throw new NullPointerException();
		}
		payStrategy.pay();
	}

	public IPayStrategy getPayStrategy() {
		return payStrategy;
	}

	public void setPayStrategy(IPayStrategy payStrategy) {
		this.payStrategy = payStrategy;
	}

	
}