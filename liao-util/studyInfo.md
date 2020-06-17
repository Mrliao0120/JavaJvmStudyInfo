1<<4
位运算符，是二进制操作，左移一位相当于原数乘2倍。
000001左移一位000010，左移4位010000

000001转十进制
= 0*2^5 + 0*2^4 + 0*2^3 + 0*2^2 + 0*2^1 + 1*2^0
= 0 + 0 + 0 + 0 + 0 + 1
= 1
010000转十进制
= 0*2^5 + 1*2^4 + 0*2^3 + 0*2^2 + 0*2^1 + 0*2^0
= 0 + 16 + 0 + 0 + 0 + 0
= 16



HashMap：
1.扩容
    在 HashMap 中，桶数组的长度均是2的幂，阈值大小为桶数组长度与负载因子的乘积。
     当 HashMap 中的键值对数量超过阈值时，进行扩容。
    HashMap 的扩容机制与其他变长集合的套路不太一样，HashMap 按当前桶数组长度的2倍进行扩容，阈值也变为原来的2倍（
    如果计算过程中，阈值溢出归零，则按阈值公式重新计算）。
     扩容之后，要重新计算键值对的位置，并把它们移动到合适的位置上去。
     
     
     1.计算新桶数组的容量 newCap 和新阈值 newThr
     2.根据计算出的 newCap 创建新的桶数组，桶数组 table 也是在这里进行初始化的
     3.将键值对节点重新映射到新的桶数组里。如果节点是 TreeNode 类型，则需要拆分红黑树。如果是普通节点，则节点按原顺序进行分组。
     
     final Node<K,V>[] resize() {
         Node<K,V>[] oldTab = table;
         int oldCap = (oldTab == null) ? 0 : oldTab.length;
         int oldThr = threshold;
         int newCap, newThr = 0;
         // 如果 table 不为空，表明已经初始化过了
         if (oldCap > 0) {
             // 当 table 容量超过容量最大值，则不再扩容
             if (oldCap >= MAXIMUM_CAPACITY) {
                 threshold = Integer.MAX_VALUE;
                 return oldTab;
             } 
             // 按旧容量和阈值的2倍计算新容量和阈值的大小
             else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                      oldCap >= DEFAULT_INITIAL_CAPACITY)
                 newThr = oldThr << 1; // double threshold
         } else if (oldThr > 0) // initial capacity was placed in threshold
             /*
              * 初始化时，将 threshold 的值赋值给 newCap，
              * HashMap 使用 threshold 变量暂时保存 initialCapacity 参数的值
              */ 
             newCap = oldThr;
         else {               // zero initial threshold signifies using defaults
             /*
              * 调用无参构造方法时，桶数组容量为默认容量，
              * 阈值为默认容量与默认负载因子乘积
              */
             newCap = DEFAULT_INITIAL_CAPACITY;
             newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
         }
         
         // newThr 为 0 时，按阈值计算公式进行计算
         if (newThr == 0) {
             float ft = (float)newCap * loadFactor;
             newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                       (int)ft : Integer.MAX_VALUE);
         }
         threshold = newThr;
         // 创建新的桶数组，桶数组的初始化也是在这里完成的
         Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
         table = newTab;
         if (oldTab != null) {
             // 如果旧的桶数组不为空，则遍历桶数组，并将键值对映射到新的桶数组中
             for (int j = 0; j < oldCap; ++j) {
                 Node<K,V> e;
                 if ((e = oldTab[j]) != null) {
                     oldTab[j] = null;
                     if (e.next == null)
                         newTab[e.hash & (newCap - 1)] = e;
                     else if (e instanceof TreeNode)
                         // 重新映射时，需要对红黑树进行拆分
                         ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                     else { // preserve order
                         Node<K,V> loHead = null, loTail = null;
                         Node<K,V> hiHead = null, hiTail = null;
                         Node<K,V> next;
                         // 遍历链表，并将链表节点按原顺序进行分组
                         do {
                             next = e.next;
                             if ((e.hash & oldCap) == 0) {
                                 if (loTail == null)
                                     loHead = e;
                                 else
                                     loTail.next = e;
                                 loTail = e;
                             }
                             else {
                                 if (hiTail == null)
                                     hiHead = e;
                                 else
                                     hiTail.next = e;
                                 hiTail = e;
                             }
                         } while ((e = next) != null);
                         // 将分组后的链表映射到新桶中
                         if (loTail != null) {
                             loTail.next = null;
                             newTab[j] = loHead;
                         }
                         if (hiTail != null) {
                             hiTail.next = null;
                             newTab[j + oldCap] = hiHead;
                         }
                     }
                 }
             }
         }
         return newTab;
     }

2.解决Hash冲突
    
   hash值冲突是发生在put()时，从源码可以看出，hash值是通过hash(key.hashCode())来获取的，当put的元素越来越多时，
    难免或出现不同的key产生相同的hash值问题，也即是hash冲突，当拿到一个hash值，
    通过indexFor(hash, table.length)获取数组下标，先查询是否存在该hash值，若不存在，则直接以Entry<V,V>的方式存放在数组中，
    若存在，则再对比key是否相同,若hash值和key都相同，则替换value，若hash值相同，key不相同，则形成一个单链表，将hash值相同，
    key不同的元素以Entry<V,V>的方式存放在链表中，这样就解决了hash冲突，这种方法叫做分离链表法，