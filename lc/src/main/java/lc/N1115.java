package lc;

import java.util.stream.Stream;

/**
 * 1115. 交替打印FooBar(2)
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 * @author Terry
 *
 */
public class N1115 {

	private static boolean fooPrinted = false;
	
	public static void main(String[] args) {
		Solution s = new N1115().new Solution();
		
		s.runFooBar(9);
	}
    
    class Solution {
    	public void runFooBar(int n) {
    		FooBar fooBar = new FooBar(n);
    		Stream.of(new Integer[]{0,1}).parallel().forEach(i -> {
    			try {
    				if (i == 0) {
    					fooBar.foo(new Runnable() {
    						@Override
    						public void run() {
    							System.out.print("foo");
    						}
    					});
    				} else {
    					fooBar.bar(new Runnable() {
    						@Override
    						public void run() {
    							System.out.print("bar");
    						}
    					});
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		});
    		try {
    			Thread.sleep(1000L);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

    	public void foo(Runnable printFoo) throws InterruptedException {

    		for (int i = 0; i < n; i++) {
    			while (true) {
    				if (!fooPrinted) {
    					// printFoo.run() outputs "foo". Do not change or remove this line.
    					printFoo.run();
    					fooPrinted = true;
    					break;
    				}
    				Thread.yield();
    			}
    		}
    	}

    	public void bar(Runnable printBar) throws InterruptedException {

    		for (int i = 0; i < n; i++) {
    			while (true) {
    				if (fooPrinted) {
    					// printBar.run() outputs "bar". Do not change or remove this line.
    					printBar.run();
    					fooPrinted = false;
    					break;
    				}
    				Thread.yield();
    			}
    		}
    	}
    }
}
