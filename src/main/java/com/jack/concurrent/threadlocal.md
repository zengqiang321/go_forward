ThreadLocal

	是JDK lang包中的一个类，可以保持每个线程的变量信息，做到线程隔离。在高并发场景下，可以隐式的传递一些参数。比如日志的traceId...

	类结构上 提供了， get/set/remove 核心方法。 

	在调用Set 方法时通过 CurrentThread的threadLocals 获取当前线程中的ThreadLocalMap（thread.threadLocals） 如果map=null 创建一个新的threadLocalMap
	thread.threadLocals = new ThreadLocalMap(this,value);

	Thread中的ThreadLocalMap 是由ThreadLocal通过get/set/remove方法来维护的，所以对不同的线程每次获取副本时都不可能获取到其它线程的的副本值

	ThreadLocalMap 是ThreadLocal的静态内部类, 没有实现Map接口，用独特的方式实现了Map的功能。
	存储结构是Entry[] 数组. Entry继承了WeakReference,他的key必须是ThreadLocal类型。初始数组大小是16, 增值方式*2
	WeakReference 弱引用它的生命周期只能活到下次GC前，但只有Key是弱引用，Value是强引用。 （为什么？）

	Hash寻址计算出数组位置: ThreadLocal.threadLocalHashCode & (len-1)

	ThreadLocalMap 采用线性探测的方式，所谓线性探测，就是根据初始key的hashcode值确定元素在table数组中的位置，如果发现这个位置上已经有其他key值的元素被占用，则利用固定的算法寻找一定步长的下个位置，依次判断，直至找到能够存放的位置。``````````
	1.Hash冲突解决方式
		ThreadLocalMap解决Hash冲突的方式就是简单的步长加1或减1，寻找下一个相邻的位置。显然ThreadLocalMap采用线性探测的方式解决Hash冲突的效率很低，如果有大量不同的ThreadLocal对象放入map中时发送冲突，或者发生二次冲突，则效率很低。所以这里引出的良好建议是：每个线程只存一个变量，这样的话所有的线程存放到map中的Key都是相同的ThreadLocal，如果一个线程要保存多个变量，就需要创建多个ThreadLocal，多个ThreadLocal放入Map中时会极大的增加Hash冲突的可能。

	2.ThreadLocalMap内存泄漏
		由于ThreadLocalMap的key是弱引用，而Value是强引用。这就导致了一个问题，ThreadLocal在没有外部对象强引用时，发生GC时弱引用Key会被回收，而Value不会回收，如果创建ThreadLocal的线程一直持续运行，那么这个Entry对象中的value就有可能一直得不到回收，发生内存泄露。

		既然Key是弱引用，那么我们要做的事，就是用完ThreadLocalMap中的变量后手动调用remove方法，将Entry节点和Map的引用关系移除，这样整个Entry对象在GC Roots分析后就变成不可达了，下次GC的时候就可以被回收。

		另外ThreadLocal中也做了一些防护措施，即在调用get/set方法时会遍历整个集合，将Key= null 的value设置为null, table[i]=null,移除队列
	3.集合的扩容
