package lc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

/**
 * 1195. 交替打印字符串(2)
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/
 * @author Terry
 *
 */
public class N1195 {

	public static void main(String[] args) {
		try {
			int n = 50;
			FizzBuzz f = new FizzBuzz(n);
			Runnable a = new Runnable() {
				@Override
				public void run() {
					try {
						f.fizz(new Runnable() {
							public void run() {
								System.out.println("fizz");
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
			Runnable b = new Runnable() {
				@Override
				public void run() {
					try {
						f.buzz(new Runnable() {
							public void run() {
								System.out.println("buzz");
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
			Runnable c = new Runnable() {
				@Override
				public void run() {
					try {
						f.fizzbuzz(new Runnable() {
							public void run() {
								System.out.println("fizzbuzz");
							}
						});
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			
			Runnable d = new Runnable() {
				@Override
				public void run() {
					try {
						f.number(x -> System.out.println(x));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
			

			ExecutorService executorService = Executors.newFixedThreadPool(4);
			executorService.submit(a);
			executorService.submit(b);
			executorService.submit(c);
			executorService.submit(d);

			TimeUnit.SECONDS.sleep(2L);
			executorService.shutdown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class FizzBuzz {
	private volatile int i = 1;
    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
		while (i <= n) {
			if (i % 3 == 0 && i % 5 != 0) {
				printFizz.run();
				i++;
			}
	        Thread.yield();
		}
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
		while (i <= n) {
			if (i % 3 != 0 && i % 5 == 0) {
				printBuzz.run();
				i++;
			}
	        Thread.yield();
		}
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (i <= n) {
			if (i % 3 == 0 && i % 5 == 0) {
				printFizzBuzz.run();
				i++;
			}
	        Thread.yield();
		}
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	while (i <= n) {
	        if (i % 3 != 0 && i % 5 != 0) {
	        	printNumber.accept(i);
	        	i++;
	        }
	        Thread.yield();
    	}
    }
}