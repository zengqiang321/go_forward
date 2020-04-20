## 1.JAVA锁

**自旋锁、阻塞锁 概念**
    
     自旋锁:获取自旋锁通常比阻塞锁所需的时间更短，但是通常也会浪费CPU时钟周期，并且造成内存竞争
            
     阻塞锁:
       


    1.Synchronized 关键字
    2.基于AQS抽象类的实现。ReentrantLock、CountDownLatch、Semaphroe...
    
### 1.1 AQS 实现机制
    1. 设计与实现
            a) 获取锁(acquire): 获取同步状态，若同步状态不允许加入到阻塞队列，阻塞当前线程（循环询问是否可以获得锁）
            b) 释放锁(Release): 更新同步状态,  状态变为线程可允许的同步状态，唤醒一个或者多个阻塞的线程
            
     为了实现上述操作需要的组建:
            1. 同步状态原子性管理 . state 、对state 的cas操作
            2. 线程的阻塞与释放 (循环询问state是否可用) 
            3. 队列的管理 （链表）     
            
#### 1.1.0 CAS (compare and swape)   


#####   1.1.1 ReentrantLock 深入理解



#####  1.1.2 CountDownlatch 深入理解
