//假设有这么一个类： 
//
// class ZeroEvenOdd {
//  public ZeroEvenOdd(int n) { ... }      // 构造函数
//  public void zero(printNumber) { ... }  // 仅打印出 0
//  public void even(printNumber) { ... }  // 仅打印出 偶数
//  public void odd(printNumber) { ... }   // 仅打印出 奇数
//}
// 
//
// 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程： 
//
// 
// 线程 A 将调用 zero()，它只输出 0 。 
// 线程 B 将调用 even()，它只输出偶数。 
// 线程 C 将调用 odd()，它只输出奇数。 
// 
//
// 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n
//。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出："0102"
//说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
// 
//
// 示例 2： 
//
// 输入：n = 5
//输出："0102030405"
// 
// 👍 72 👎 0


package leetcode.editor.cn;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {
    public static void main(String[] args) {
        ZeroEvenOdd solution = new ZeroEvenOdd(2);

    }

    static
            //leetcode submit region begin(Prohibit modification and deletion)
    class ZeroEvenOdd {
        private int n;
        private Semaphore semaphore1 = new Semaphore(1);
        private Semaphore semaphore2 = new Semaphore(0);
        private Semaphore semaphore3 = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                semaphore1.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    semaphore2.release();
                } else {
                    semaphore3.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                semaphore3.acquire();
                printNumber.accept(i);
                semaphore1.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <=n ; i+=2) {
                semaphore2.acquire();
                printNumber.accept(i);
                semaphore1.release();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}