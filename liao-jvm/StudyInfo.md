**1.java.lang.OutOfMemoryError: Java heap space** OOM  
    代码路径:com.liao.jvm.oom.HeapOOM
    要解决这个异常，需要分析 到底是内存泄露，还是内存溢出
    如果是内存泄露，需要查看GC Roots的引用链。
    —于是就能找到泄露对象是通过怎么样的路径与CG Roots相关联并导致垃圾收集器无法自动回收它们的。
    如果不存在泄露而是内存溢出，换话说就是对象还活着就应当检查虚拟机参数（-Xmx与-Xms） 检查代码某些对象的生命周期过长,
    持有状态时间过长的情况，尝试减少程序运行期的内存消耗。
    **StackOverflowError 异常**
    代码路径：com.liao.jvm.oom.JavaVMStackSOF
    在单个线程下，无论由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出都是StackOverflowError异常
**2.虚拟机栈和本地方法溢出**
    由于HotSport虚拟机中并不会区分虚拟机栈和本地方法栈，因此对于HotSport,虽然-Xoss参数(设置本地机栈和本地方法栈)
  但是实际上是无效的,栈容量只由-Xss参数设定。
 3.关于虚拟机和本地方法栈，在Java虚拟机规范中描述了两种异常
    1.如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。
    2.如果虚拟机在扩展栈时无法申请到足够空间，则抛出OutOfMemoryError异常。
 