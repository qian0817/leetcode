//编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是： 
//
// 
// 如果这个数字可以被 3 整除，输出 "fizz"。 
// 如果这个数字可以被 5 整除，输出 "buzz"。 
// 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。 
// 
//
// 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14
//, fizzbuzz。 
//
// 假设有这么一个类： 
//
// class FizzBuzz {
//  public FizzBuzz(int n) { ... }               // constructor
//  public void fizz(printFizz) { ... }          // only output "fizz"
//  public void buzz(printBuzz) { ... }          // only output "buzz"
//  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
//  public void number(printNumber) { ... }      // only output the numbers
//} 
//
// 请你实现一个有四个线程的多线程版 FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用： 
//
// 
// 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。 
// 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。 
// 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。 
// 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。 
// 
// 👍 30 👎 0


package leetcode.editor.cn;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {
    public static void main(String[] args) {
//          FizzBuzz solution = new FizzBuzz();
    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class FizzBuzz {
        private int n;

        public FizzBuzz(int n) {
            this.n = n;
        }

        private Semaphore fSemaphore = new Semaphore(0);
        private Semaphore bSemaphore = new Semaphore(0);
        private Semaphore fbSemaphore = new Semaphore(0);
        private Semaphore semaphore = new Semaphore(1);


        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i += 3) {
                if (i % 5 == 0) {
                    continue;
                }
                fSemaphore.acquire();
                printFizz.run();
                release(i + 1);
            }
        }


        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i += 5) {
                if (i % 3 == 0) {
                    continue;
                }
                bSemaphore.acquire();
                printBuzz.run();
                release(i + 1);
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i += 15) {
                fbSemaphore.acquire();
                printFizzBuzz.run();
                release(i + 1);
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 || i % 5 == 0) {
                    continue;
                }
                semaphore.acquire();
                printNumber.accept(i);
                release(i + 1);
            }
        }


        private void release(int n) {
            if (n % 15 == 0) {
                fbSemaphore.release();
            } else if (n % 5 == 0) {
                bSemaphore.release();
            } else if (n % 3 == 0) {
                fSemaphore.release();
            } else {
                semaphore.release();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}