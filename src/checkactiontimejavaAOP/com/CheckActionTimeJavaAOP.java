package checkactiontimejavaAOP.com;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CheckActionTimeJavaAOP {
	
	
	public Object checkActionTime(Object obj) {
		
		Object proxy = Proxy.newProxyInstance
				(obj.getClass().getClassLoader(),new Class[] {obj.getClass().getInterfaces()[0]}, 
				 new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						long start = System.currentTimeMillis();
						
						Object ActionTime = method.invoke(obj, args);
						
						long end = System.currentTimeMillis();
						
						System.out.println((end - start) + "ms 시간이 걸렸습니다. ");
						
						return ActionTime;
					}
				});
		
		return proxy;

	}
}
