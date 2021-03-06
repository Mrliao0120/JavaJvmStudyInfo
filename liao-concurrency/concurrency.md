# 并发编程记录
## 线程基础
   JVM内存结构
    1.程序计数器
    字节码命令循环,跳转,异常处理等等，线程上下文切换。都需要一个独立的程序计数器
    2.JVM虚拟机栈
    jvm虚拟机栈是线程私有的，方法的执行都会创建一个栈帧的数据结构，主要用于存放局部变量表，操作栈，动态链接
    方法出口等信息。
    3.本地方法栈
    JVM为被本地方法所划分的区域便是本地方法栈。
    4.堆内存
    堆内存被所有线程共享，Java在运行期间创建的所有对象几乎都存放在该区域。JVM运行期间创建的所有对象都在本区域。
    该内存区域是CG回收的重点区域。也被区分为新生代,老年代
    5.方法区
    被多个线程共享的内存区域，他主要是存储已经被虚拟机加载的类信息，常量。静态变量。
    6.元空间(java8)
    元空间替换了Java8之前的永久代，GC回收时候可以直接回收元空间，节省内存空间碎片
    
    
    
   1.存在竞态条件时线程不安全  比如 ++i   较好的处理方式是:将所有可变状态都封装为内部类，通过对象的内置锁进行


## 一.锁
   1.0 内置锁
   内置锁又称互斥锁，意味着只有一个线程能持有这种锁
   1.1 内置锁是可以锁重入的  锁重入的实现方式是:为每一个锁关联一个获得计数值和一个所有线程，当锁计数为0时,
    这个锁会被认为没有被任何线程持有。当线程请求一个未被持有的锁时，JVM将记下锁的持有者，并将其获取的位置记录为1
   如果同一线程再次获取这个锁，计数值将递增，而当线程退出同步代码块时将同步递减，当计数值为0时，这个锁将被释放。
   2.0 Volatile
   当声明变量为Volatile时，编译器与运行时都会注意到这个变量是共享的，因此不会将该变量的操作与其内存够重新排序。
  volatile不会被缓存在寄存器或者处理器不可见的地方。因此读取volatile总是会读取到最新写入的值。
    注意: Volatile 自增时 是线程不安全的
  调试小提示: 启动jvm时一定要指定:-server
 ## 1.1.显式锁
   1.Lock和ReentrantLock
   lock提供了无条件的，可轮询的，定时的以及可中断的锁获取操作所有加锁和解锁的方式都是显示的。
   ReentrantLock实现了Lock接口，与synchronized相同的互斥性和内存可见性,在公平性上ReentrantLock按照锁的请求顺序来。
   ps: 大多数情况下非公平锁性能不如公平锁
   2.轮询锁和定时锁
   定时锁轮询锁可以避免死锁的发生。
    lock.tryLock();
   3.可中断获取锁
     lock.lockInterruptibly();
 ## 1.2 读写锁
   读写锁允许线程并发访问，但是写锁只能被单独持有。当访问为只读时性能会获得提升。   
   
   
   
   
   
   
    
    
    
## 二.并发编程基础

###  1.无状态类是线程安全的  因为他们没有具体状态   线程数据不共享 每个对象都是单独的实例  所以是线程安全的。

###​	2.线程中 保持原子性不太可能++i   i++操作都不会是原子性操作，因为其中操作分为读取——修改——写入。凡是存在竞态条件都不具备线程安全可行性

###	 3. BlockingQueue扩展了Queue，增加了可阻塞队列的插入和获取等操作。如果队列为空，那么获取元素的操作将一直阻塞，
直到队列中出现一个可用元素。如果队列已满那么将一直阻塞，直到有多余空间。非常适合用于作为数据共享的通道。

###	  4.ConcurrentHashMap也是一个基于散列的Map,但它使用了一种完全不同的加锁机制。它采用的是一种分段锁。数据结构采用数组+链表/红黑二叉树
   1.7版本JDK采用分段锁， 1.8版本还存在分段锁数据只是为了兼容版本  采用 CAS 和 synchronized 来保证并发安全。
   synchronized 只锁定当前链表或红黑二叉树的首节点，这样只要 hash 不冲突，就不会产生并发，效率又提升 N 倍。
   ![avatar](src/main/resources/concurrentHashMapSynchronized.png)
   并发下ConcurrentHashMap size()，isEmpty()只是估计预算可能并不是当前map的真正值.
    在并发场景下如果要保证一种可行的方式是使用 Collections.synchronizedMap() 方法来包装我们的 HashMap。
    但这是通过使用一个全局的锁来同步不同线程间的并发访问，因此会带来不可忽视的性能问题。
    
    
   
###   5.CopyOnWriteArrayList用来替代同步ArrayList，在某些情况下它提供了更好的并发性能，并且在迭代期间不需要枷锁或复制，
  在进行修改操作时，对List复制个副本进行操作。读取是完全不用加锁的，并且更厉害的是：写入也不会阻塞读取操作。
    只有写入和写入之间需要进行同步等待。这样一来，读操作的性能就会大幅度提升。
    读取操作没有任何同步控制和锁操作，理由就是内部数组 array 不会发生修改，只会被另外一个 array 替换，因此可以保证数据安全。
        
        /** The array, accessed only via getArray/setArray. */
            private transient volatile Object[] array;
            public E get(int index) {
                return get(getArray(), index);
            }
            @SuppressWarnings("unchecked")
            private E get(Object[] a, int index) {
                return (E) a[index];
            }
            final Object[] getArray() {
                return array;
            }
    
####   5.1CopyOnWriteArrayList 写入操作的实现:
  CopyOnWriteArrayList 写入操作 add() 方法在添加集合的时候加了锁，保证了同步，避免了多线程写的时候会 copy 出多个副本出来。
    
    /**
         * Appends the specified element to the end of this list.
         *
         * @param e element to be appended to this list
         * @return {@code true} (as specified by {@link Collection#add})
         */
        public boolean add(E e) {
            final ReentrantLock lock = this.lock;
            lock.lock();//加锁
            try {
                Object[] elements = getArray();
                int len = elements.length;
                Object[] newElements = Arrays.copyOf(elements, len + 1);//拷贝新数组
                newElements[len] = e;
                setArray(newElements);
                return true;
            } finally {
                lock.unlock();//释放锁
            }
        }
   
   
   
###   6.Deque和BlockingDeque 分别对Queue和BlockingQueue进行了扩展。 
###    7.BlockingDeque这是一个接口，JDK 内部通过链表、数组等方式实现了这个接口。表示阻塞队列，
  ####      7.1 ArrayBlockingQueue
  ArrayBlockingQueue有界缓存:不能从一个空缓存中获取缓存，也不能将元素放入缓存中。
ArrayBlockingQueue 是 BlockingQueue 接口的有界队列实现类，底层采用数组来实现。ArrayBlockingQueue 一旦创建，
            容量不能改变。其并发控制采用可重入锁来控制，不管是插入操作还是读取操作，都需要获取到锁才能进行操作。
            当队列容量满时，尝试将元素放入队列将导致操作阻塞;尝试从一个空队列中取一个元素也会同样阻塞。
            ArrayBlockingQueue 默认情况下不能保证线程访问队列的公平性，所谓公平性是指严格按照线程等待的绝对时间顺序，
            即最先等待的线程能够最先访问到 ArrayBlockingQueue。而非公平性则是指访问 ArrayBlockingQueue 
            的顺序不是遵守严格的时间顺序，有可能存在，当 ArrayBlockingQueue 可以被访问时，长时间阻塞的线程依然无法访问到
             ArrayBlockingQueue。如果保证公平性，通常会降低吞吐量。如果需要获得公平性的 ArrayBlockingQueue，
             可采用如下代码：
             
             private static ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10,true);
             
        
        
####   7.2 LinkedBlockingQueue
   LinkedBlockingQueue 底层基于单向链表实现的阻塞队列，可以当做无界队列也可以当做有界队列来使用，同样满足 FIFO 的特性，
   与 ArrayBlockingQueue 相比起来具有更高的吞吐量，为了防止 LinkedBlockingQueue 容量迅速增，损耗大量内存。
   通常在创建 LinkedBlockingQueue 对象时，会指定其大小，如果未指定，容量等于 Integer.MAX_VALUE。
            
            /**
                 *某种意义上的无界队列
                 * Creates a {@code LinkedBlockingQueue} with a capacity of
                 * {@link Integer#MAX_VALUE}.
                 */
                public LinkedBlockingQueue() {
                    this(Integer.MAX_VALUE);
                }
            
                /**
                 *有界队列
                 * Creates a {@code LinkedBlockingQueue} with the given (fixed) capacity.
                 *
                 * @param capacity the capacity of this queue
                 * @throws IllegalArgumentException if {@code capacity} is not greater
                 *         than zero
                 */
                public LinkedBlockingQueue(int capacity) {
                    if (capacity <= 0) throw new IllegalArgumentException();
                    this.capacity = capacity;
                    last = head = new Node<E>(null);
                }
   
####   7.3 PriorityBlockingQueue
   PriorityBlockingQueue 是一个支持优先级的无界阻塞队列。默认情况下元素采用自然顺序进行排序，
     也可以通过自定义类实现 compareTo() 方法来指定元素排序规则，或者初始化时通过构造器参数 Comparator 来指定排序规则。
     PriorityBlockingQueue 并发控制采用的是 ReentrantLock，队列为无界队列（ArrayBlockingQueue 是有界队列，
     LinkedBlockingQueue 也可以通过在构造函数中传入 capacity 指定队列最大的容量，但是 PriorityBlockingQueue 
     只能指定初始的队列大小，后面插入元素的时候，如果空间不够的话会自动扩容）。
     简单地说，它就是 PriorityQueue 的线程安全版本。不可以插入 null 值，同时，
     插入队列的对象必须是可比较大小的（comparable），否则报 ClassCastException 异常。它的插入操作 put 方法不会 block，
     因为它是无界队列（take 方法在队列为空的时候会阻塞）。
     
####   8.ConcurrentSkipListMap 跳表的实现。这是一个 Map，使用跳表的数据结构进行快速查找。


####    9.ConcurrentLinkedQueue  应该算是在高并发环境中性能最好的队列了。它之所有能有很好的性能，是因为其内部复杂的实现。
  主要使用 CAS 非阻塞算法来实现线程安全就好了。适合在对性能要求相对较高，同时对队列的读写存在多个线程同时进行的场景，
     即如果对队列加锁的成本较高则适合使用无锁的 ConcurrentLinkedQueue 来替代
        

   是一个双向队列，实现了在队列头和队列尾高效插入和移除，具体实现ArrayDeque和LinkedBlockingDeque。

#### 7.闭锁    相当于一扇门  闭锁状态结束前  所有线程都需要等待 CountDownLatch  await()等待线程结束

countDown()减去一个计数

#### 8.FutureTask  获取未来结果  可以在多个线程中的结果  获取到一个线程中，Executor框架中表示异步任务，此外还可以用来表示一些时间较长的计算。Future.get()来获取线程结果   在获取结果前一直阻塞。

#### 9.信号量  用来控制访问某个特定资源的操作数量，或者同时执行某个指定操作的数量，或者对容器加边界Semaphore  

​	.acquire()获取许可。

​	.release()释放许可。

#### 10.侧栏  侧栏类似于闭锁，它能阻塞一组线程直到某个事件发生。侧栏和闭锁的关键在于，所有线程必须同时到达侧栏位置，才能继续执行，简单来说就是等待其他线程一起到达侧栏位置  才能继续执行下一步操作。类似于公司团建  必须等待某个领导线程到齐了 才能开始下一步操作。

CyclicBarrier可以使一定数量的参与方反复地在侧栏位置汇集。当有线程到达时会调用await方法 直到所有线程到达侧栏。

 #### 11.线程池策略

​	newFixedThreadPool. 将创建一个固定长度的线程池，每当提交一个任务时就创建一个线程，直到达到线程池的最大数量，这时线程池的规模将不再变化（如果某个线程由于发生未知Exception而结束，那么线程池会补充一个新线程）

   newSingleThreadExecutor。是一个单独的线程Executor，它将创建单个工作者线程来执行任务，如果这个线程异常结束，会创建另一个线程来替代。newSingleThreadExecutor能确保任务在队列顺序来串行执行

​	newCachedThreadPool。将创建一个缓存池，如果线程池的当前规模超过了处理需求时，那么将回收空闲线程，而当需求增加时，则可以添加新线程，线程池的规模不存在任何限制。

​	newScheduledThread。创建固定长度线程池，而且以延迟或定时的方式来执行任务，类似Timer

​	newFixedThreadPool和newCachedThreadPool两个工厂方法返回通用ThreadPool-Executor实例

#### 12.Executor

   Executor实现还提供了对生命周期的支持，以及信息统计，应用程序管理和性能检测机制

   代码位置com.liao.concurrency.threadClass02.ExecutorThreads
   
   12.1位于java.util.concurrent下的Executor只有一个方法execute(Runnable command).
   
   12.2Executor基于生产者-消费者模式
   
   12.3 同时Executor还扩展了ExecutorService 来管理Executor的状态
​	

## 三.**携带任务结果的Callable与Future**
 1.**Runnable**有一定局限性，它本身是无法返回一个返回值或者抛出异常.
 
 2.**Executor**执行任务的四个阶段:创建，提交，开始，完成.—但是有的任务时间过长,希望提前结束任务。
 
 3.在**Executor**中已提交的任务可以提前取消，但对于那些已经开始执行的任务，只有它们能响应中断，才能取消。取消一个已经完成的任务是不被影响的。
 
 4.**Future**表示一个任务的生命周期，并提供了相应的方法来判断是否已经完成或取消.Future的生命周期只能前进，不能后退。
 就像ExecutorService的生命周期一样。当某个任务完成后它就永远留在“完成”状态下。
 
   1.get方法的行为取决于任务的状态（尚未开始，正在运行，已经完成），如果已经完成那么get会立即返回或者抛出一个Exception，
       如果没有完成，那么get将会一直阻塞到完成。
       
   1.1如果任务抛出异常，那么get将该异常封装为ExecutionException并重新抛出。 
            
   1.2如果任务被取消,则抛出CancellationException。
            
   1.3如果get抛出ExecutionException那么可以通过getCause来获得被封装的初始异常。
            
  ps:从某些方面异步现场操作可能达不到想要的效果,例如:一个HTML渲染,一个负责文字,一个负责图片,文字渲染早已完成,
  但是图片渲染一直未完成 这种方式的效率和串行执行没什么差别。
  
  5.CompletionService:Executor与BlockingQueue 
  
  代码位置:com.liao.concurrency.threadClass02.CompletionServiceThread
  
   5.1如果要提交一组任务给线程获取结果  如果使用Future的话  就要在每个Future中get 有多少任务就需要get几个，所以为了解决
   这个问题 Java提供了**CompletionService将Executor和BlockingQueue结合在了一起**  
   
## 四.线程中断
   通常中断是取消线程的最合理方式
   中断必须处理异常InterruptedException
   1.采用标志中断
       如果是BlockingQueue  阻塞队列，当队列满时，可能get不到标志，线程可能一直不会结束。  尽量不要使用阻塞队列
    
## 五.线程池的使用
   ThreadLocal 当线程本地值生命周期与线程生命周期相同时，在线程池中的线程中使用ThreadLocal才有意义。而在线程池中不应该使用该值来传递线程间的变量
   计算线程大小Runtime.availableProcessors 
    newFixedThreadPool  newSingleThreadExecutor  这两个线程池会默认使用LinkBlockingQueue无界阻塞队列。当时更为合理的资源管理策略是使用有界队列,
   例如ArrayBlockQueue，PriorityBlockQueue(根据优先级安排任务).
     对于非常大的无界线程池,可以通过使用SynchronousQueue来避免任务排队。只有当线程池是无界的或者可以拒绝的任务时,SynchronousQueue才有实际价值。newCachedThreadPool就是用的这个
   
   饱和策略: 当有界队列填满时,饱和策略才发挥作用。
   ThreadPoolExecutor的饱和策略可以通过调用setRejectedExecutionHandler来修改。
   AbortPolicy:中止,是默认的饱和策略,该策略将抛出未检查的RejectedExecution-Exception。调用者可以捕获这个异常，然后根据需求编写自己的处理代码。
   DiscardPolicy:会悄悄抛弃任务新的无法进行的任务。
   DiscardOldestPolicy:会抛弃下一个将执行的任务,提交新任务  如果有优先级别的队列 将抛弃最高最优先的任务。
   CallerRunsPolicy:不会抛弃任务,也不会抛出异常,但是会把任务回退到调用者。
   
   线程工厂:
    每个线程池都会通过线程工厂方法ThreadFactory接口创建新线程。
    可以通过set函数的方法来设置不让外界修改策略 unConfigurableExecutorService
    Executor exec=Executors.newCacheThreadPool();
    if(exec interface ThreadPoolExecutor){}
    
   ThreadPoolExecutor 类中提供的四个构造方法。我们来看最长的那个，其余三个都是在这个构造方法的基础上产生
   
    /**
        * 用给定的初始参数创建一个新的ThreadPoolExecutor。
        */
       public ThreadPoolExecutor(int corePoolSize,//线程池的核心线程数量 最低线程
                                 int maximumPoolSize,//线程池的最大线程数
                                 long keepAliveTime,//当线程数大于核心线程数时，多余的空闲线程存活的最长时间
                                 TimeUnit unit,//时间单位
                                 BlockingQueue<Runnable> workQueue,//任务队列，用来储存等待执行任务的队列
                                 ThreadFactory threadFactory,//线程工厂，用来创建线程，一般默认即可
                                 RejectedExecutionHandler handler//拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
                                  ) {
           if (corePoolSize < 0 ||
               maximumPoolSize <= 0 ||
               maximumPoolSize < corePoolSize ||
               keepAliveTime < 0)
               throw new IllegalArgumentException();
           if (workQueue == null || threadFactory == null || handler == null)
               throw new NullPointerException();
           this.corePoolSize = corePoolSize;
           this.maximumPoolSize = maximumPoolSize;
           this.workQueue = workQueue;
           this.keepAliveTime = unit.toNanos(keepAliveTime);
           this.threadFactory = threadFactory;
           this.handler = handler;
       }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 ## 六.活跃性、性能和测试
   哲学家问题:  5个哲学家  每个哲学家都只有一根筷子吃饭 必须拿到2根筷子才能吃饭,哲学家时而思考 时而进食，如果每个哲学家
都抓住当前的筷子不放弃 那么就是一个死锁。
 如果所有线程都以固定的顺序来获得锁。那么在程序中就不会出现锁顺序死锁的问题。
 
 ### 1.可以通过定义锁顺序来避免死锁
    System.identityHashCode(Object);
   如果采用顺序锁,那么锁就不会存在死锁的顺序。  
   如果持有锁调用某个外部方法，那么将出现活跃性问题。在这个外部方法中可能会获取其他锁（这可能会产生死锁），或者阻塞时间过长，
 导致其他线程无法及时获得当前被持有锁。
 
 ### 2.Jvm通过线程转储来帮助识别死锁的发生。
   线程转储包括各个运行中的线程栈追踪信息
###  3.通过支持定时的锁来解决
   显示锁可以指定定时器来还原 tryLock   当超过时间还未获取到锁 tryLock会返回一个信息
 
###  4.其他活跃性危险
   当线程由于访问它所需的资源不能继续执行时，就会发生饥饿
    活锁:不断重复执行任务,但是总是失败。例如消息机制，每次失败都会被事务回滚掉,然后又被拉到开头。
 
 
  ## 七.性能与可伸缩性
   
   1.性能与可伸缩性
     
  
 ## 七.构建自定义的同步工具
   
   
 
 
 
 
 
 
 
 
    
