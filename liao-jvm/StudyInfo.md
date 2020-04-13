###**1.java.lang.OutOfMemoryError: Java heap space** OOM  
    代码路径: com.liao.jvm.oom.HeapOOM
    要解决这个异常，需要分析 到底是内存泄露，还是内存溢出
    如果是内存泄露，需要查看GC Roots的引用链。
    —于是就能找到泄露对象是通过怎么样的路径与CG Roots相关联并导致垃圾收集器无法自动回收它们的。
    如果不存在泄露而是内存溢出，换话说就是对象还活着就应当检查虚拟机参数（-Xmx与-Xms） 检查代码某些对象的生命周期过长,
    持有状态时间过长的情况，尝试减少程序运行期的内存消耗。
    **StackOverflowError 异常**
    代码路径：com.liao.jvm.oom.JavaVMStackSOF (单线程) com.liao.jvm.oom.JavaVMMulitiThering（多线程）
    在单个线程下，无论由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出都是StackOverflowError异常
    
###**2.虚拟机栈和本地方法溢出**
    由于HotSport虚拟机中并不会区分虚拟机栈和本地方法栈，因此对于HotSport,虽然-Xoss参数(设置本地机栈和本地方法栈)
  但是实际上是无效的,栈容量只由-Xss参数设定。
 3.关于虚拟机和本地方法栈，在Java虚拟机规范中描述了两种异常
    1.如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。
    2.如果虚拟机在扩展栈时无法申请到足够空间，则抛出OutOfMemoryError异常。
    
    
Java类加载：


**JVM类加载器:**
任意一个类，都由加载它的类加载器和这个类本身一同确立其在 Java 虚拟机中的唯一性，每一个类加载器，都有一个独立的类名称空间。
    **启动类加载器(Bootstrap ClassLoader)**:负责将存放在 <JAVA_HOME>\lib 目录中的，并且能被虚拟机识别的（仅按照文件名识别，
如 rt.jar， 名字不符合 的类库即使放在 lib 目录中也不会被加载）类库加载到虚拟机内存中。   c++编写   可能返回为空 比如String.class.getClassLoader()
    **扩展类加载器(Extension ClassLoader)**: 负责加载 <JAVA_HOME>\lib\ext 目录中的所有类库，开发者可以直接使用扩展类加载器。
    **应用程序类加载器（Application ClassLoader）**: 由于这个类加载器是 ClassLoader 中的 getSystemClassLoader() 方法的返回值，
所以一般也称它为“系统类加载器”。它负责加载用户类路径（classpath）上所指定的类库，开发者可以直接使用这个类加载器，
    如果应用程序中没有自定义过自己的类加载器，一般情况下这个就是程序中默认的类加载器。
   **双亲委派**
 双亲委派模型是描述类加载器之间的层次关系。它要求除了顶层的启动类加载器外，其余的类加载器都应当有自己的父类加载器。（父
 子关系一般不会以继承的关系实现，而是以组合关系来复用父加载器的代码）  类加载时 首先回去让其父类加载
为什么要用双亲委派模式:
    像 java.lang.Object 这些存放在 rt.jar 中的类，无论使用哪个类加载器加载，最终都会委派给最顶端的启动类加载器加载，
从而使得不同加载器加载的 Object 类都是同一个。相反，如果没有使用双亲委派模型，由各个类加载器自行去加载的话，如果用户自己
编写了一个称为 java.lang.Object的类，并放在 classpath 下，那么系统将会出现多个不同的 Object 类，Java 类型体系中最基础的
行为也就无法保证。
 
 
 ##JVM常用参数设置
  ####堆
    java -Xms20m -Xmx30m 
  我们使用 -Xms 设置堆的初始空间大小，使用 -Xmx 设置堆的最大空间大小。在上面的命令中，我们设置 JVM 的初始堆大小为 20M，
  最大堆空间为 30M。
  ####年轻代
    java -Xms20m -Xmn10M
  在 JDK1.8 中，堆分为年轻代和老年代。JVM 提供了参数 -Xmn 来设置年轻代内存的大小，但没有提供参数设置老年代的大小。但其实
  老年代的大小就等于堆大小减去年轻代大小。上面的命令中，我们设置 JVM 堆初始大小为20M。其中年轻代的大小为 10M，那么剩下
  的就是老年代的大小，有 10M了。 我们可以给上述命令加上-XX:+PrintGCDetails 参数来查看内存区域的分配信息。
  ####Eden区
    java -Xms20m -Xmn10M -XX:SurvivorRatio=2 -XX:+PrintGCDetails
  在年轻代中，分为三个区域，分别是：eden 空间、from 空间、to 空间。如果要设置这部分的大小，那么就使用 -XX:SurvivorRatio 
  这个参数，该参数设置 eden / from 空间的比例关系，该参数的公式如下：
    
    -XX:SurvivorRatio = eden/from = eden/to
  例如我们的年轻代有 10 M，而我们设置 -XX:SurvivorRatio 参数为 2。也就是说 eden / from = eden / to = 2。
  这里教一个快速计算的方法，我们假设 eden = 2，那么 from = 1，to = 1，那么 eden + from + to = 10M。
  这样就可以算出每一份大小是 10/4 = 2.5M。所以 Eden 区 = 2.5 * 2 = 5M，from 区是 2.5 M，to 区是 2.5 M。 
  ####元空间
  在 JDK 1.8 之前，所有加载的类信息都放在永久代中。但在 JDK1.8 之时，永久代被移除，取而代之的是元空间（Metaspace）。
  在元空间这块内存中，有两个参数很相似，它们是： -XX:MetaspaceSize 和 -XX:MaxMetaspaceSize。
  
     java -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=50m -XX:+PrintGCDetails GCDemo
     
  上面的命令中，我们设置 MetaspaceSize 为 10M，MaxMetaspaceSize 为 50M。但其实它们并不是设置初始大小和最大大小的。
  ##栈空间
  栈空间是每个线程各自有的一块区域，如果栈空间太小，也会导致 StackOverFlow 异常。而要设置栈空间大小，只需要使用 -Xss 参数就可以。
  
    java -Xss2m 
    
   上面的启动命令设置最大栈空间为 2M。
   ####直接内存
   在 JVM 中还有一块内存，它独立于 JVM 的堆内存，它就是：直接内存。我们可以使用 -XX:MaxDirectMemorySize 设置最大直接内存。
   如果不设置，默认为最大堆空间，即 -Xmx。
   
    java -XX:MaxDirectMemorySize=50m 
    
  上面的启动命令设置直接内存最大值为 50M。当直接内存使用达到设置值时，就会触发垃圾回收。如果不能有效释放足够空间，就会引发直接内存溢出导致系统的 OOM。
  
  参数	含义
  
  -Xms	初始堆大小
  
  -Xmx	最大堆空间
  
  -Xmn	设置新生代大小
  
  -XX:SurvivorRatio	设置新生代eden空间和from/to空间的比例关系
  
  -XX:PermSize	方法区初始大小
  
  -XX:MaxPermSize	方法区最大大小
  
  -XX:MetaspaceSize	元空间GC阈值（JDK1.8）
  
  -XX:MaxMetaspaceSize	最大元空间大小（JDK1.8）
  
  -Xss	栈大小
  
  -XX:MaxDirectMemorySize	直接内存大小，默认为最大堆空间
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  