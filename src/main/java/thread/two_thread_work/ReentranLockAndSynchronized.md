`ReentrantLock` 是 Java 并发包 `java.util.concurrent.locks` 中的一个核心类，它提供了比内置锁（`synchronized`）更强大、更灵活的线程同步机制。

---

## 🔍 一、什么是 ReentrantLock？

`ReentrantLock` 实现了 `Lock` 接口，是一个**可重入的互斥锁**。

- **可重入（Reentrant）**：同一个线程可以多次获取同一把锁。
- **互斥（Mutual Exclusion）**：同一时刻只有一个线程能持有锁。

---

## ✅ 二、基本使用方式

### 1. 基本结构（必须成对使用 `lock()` 和 `unlock()`）

```java
import java.util.concurrent.locks.ReentrantLock;

ReentrantLock lock = new ReentrantLock();

lock.lock();  // 获取锁
try {
    // 临界区代码（线程安全操作）
} finally {
    lock.unlock();  // 必须在 finally 中释放锁
}
```

> ⚠️ **重要**：`unlock()` 必须放在 `finally` 块中，确保即使发生异常也能释放锁，避免死锁。

---

## 🆚 三、ReentrantLock vs synchronized

| 特性 | `synchronized` | `ReentrantLock` |
|------|------------------|------------------|
| **语法简洁性** | 简单（自动获取/释放） | 需手动 `lock/unlock` |
| **可中断** | ❌ 不可中断等待 | ✅ 可中断（`lockInterruptibly()`） |
| **超时获取锁** | ❌ 不支持 | ✅ 支持（`tryLock(timeout)`） |
| **公平锁** | ❌ 非公平 | ✅ 可选择公平或非公平 |
| **条件变量** | `wait()/notify()/notifyAll()` | `Condition`（更灵活） |
| **多个条件等待** | ❌ 只能一个 `wait set` | ✅ 支持多个 `Condition` |
| **锁获取状态检查** | ❌ 不支持 | ✅ 支持（如 `isLocked()`, `getHoldCount()`） |

---

## ✅ 四、核心功能详解

### 1. **可重入性**

同一个线程可以多次获取同一把锁：

```java
ReentrantLock lock = new ReentrantLock();

lock.lock(); // 第一次获取
lock.lock(); // 同一线程再次获取，不会死锁
lock.lock();

// ... 操作

lock.unlock(); // 必须 unlock 三次
lock.unlock();
lock.unlock();
```

> 🔁 每次 `lock()` 都会增加持有计数，每次 `unlock()` 减少计数，计数为 0 时释放锁。

---

### 2. **可中断锁获取（lockInterruptibly）**

线程在等待锁时可以响应中断：

```java
ReentrantLock lock = new ReentrantLock();

try {
    lock.lockInterruptibly(); // 等待锁时可被中断
    try {
        // 临界区
    } finally {
        lock.unlock();
    }
} catch (InterruptedException e) {
    System.out.println("线程被中断，放弃获取锁");
    Thread.currentThread().interrupt(); // 恢复中断状态
}
```

> ✅ 适用于需要支持取消操作的场景（如任务超时、用户取消）。

---

### 3. **尝试获取锁（tryLock）**

非阻塞或限时获取锁：

#### ✅ 非阻塞尝试
```java
if (lock.tryLock()) {
    try {
        // 成功获取锁
    } finally {
        lock.unlock();
    }
} else {
    // 获取失败，执行其他逻辑
}
```

#### ✅ 带超时尝试
```java
try {
    if (lock.tryLock(3, TimeUnit.SECONDS)) {
        try {
            // 在3秒内成功获取锁
        } finally {
            lock.unlock();
        }
    } else {
        System.out.println("获取锁超时");
    }
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

> ✅ 适用于避免死锁、实现超时控制。

---

### 4. **公平锁 vs 非公平锁**

```java
// 非公平锁（默认）
ReentrantLock unfairLock = new ReentrantLock();

// 公平锁（先来先得）
ReentrantLock fairLock = new ReentrantLock(true);
```

- **非公平**：线程可能“插队”，性能更高。
- **公平**：严格按照等待顺序获取锁，避免线程饥饿，但性能略低。

> ⚠️ 公平锁不保证线程调度完全公平，且性能开销大，**一般不推荐**，除非有特殊需求。

---

### 5. **Condition（条件变量）**

`ReentrantLock` 可以结合 `Condition` 实现更精细的线程通信：

```java
ReentrantLock lock = new ReentrantLock();
Condition notFull  = lock.newCondition();
Condition notEmpty = lock.newCondition();

// 生产者
lock.lock();
try {
    while (queue.size() == MAX) {
        notFull.await(); // 等待队列不满
    }
    queue.add(item);
    notEmpty.signal(); // 通知消费者
} finally {
    lock.unlock();
}

// 消费者
lock.lock();
try {
    while (queue.isEmpty()) {
        notEmpty.await(); // 等待队列不空
    }
    queue.remove();
    notFull.signal(); // 通知生产者
} finally {
    lock.unlock();
}
```

> ✅ `Condition` 比 `synchronized` 的 `wait/notify` 更灵活，支持多个等待队列。

---

## ✅ 五、常用方法一览

| 方法 | 说明 |
|------|------|
| `lock()` | 获取锁，阻塞直到成功 |
| `unlock()` | 释放锁 |
| `lockInterruptibly()` | 获取锁，可响应中断 |
| `tryLock()` | 尝试获取锁，立即返回 true/false |
| `tryLock(long, TimeUnit)` | 尝试获取锁，带超时 |
| `newCondition()` | 创建一个条件变量 |
| `isHeldByCurrentThread()` | 当前线程是否持有锁 |
| `getHoldCount()` | 当前线程持有锁的次数 |
| `isLocked()` | 锁是否被任意线程持有 |

---

## ✅ 六、使用场景建议

| 场景 | 推荐使用 |
|------|----------|
| 简单同步 | ✅ `synchronized`（更简洁） |
| 需要超时控制 | ✅ `ReentrantLock.tryLock()` |
| 需要响应中断 | ✅ `ReentrantLock.lockInterruptibly()` |
| 复杂线程协作（如生产者-消费者） | ✅ `ReentrantLock + Condition` |
| 高性能并发容器 | ✅ `ReentrantLock`（如 `ThreadPoolExecutor` 内部使用） |

---

## ✅ 七、注意事项

1. **必须手动释放锁**：务必在 `finally` 块中调用 `unlock()`。
2. **不要在 `lock()` 前加 `try`**：`lock()` 本身不会抛出 `InterruptedException`（除非用 `lockInterruptibly()`）。
3. **避免死锁**：多个锁时注意获取顺序。
4. **公平锁慎用**：性能较低，可能导致吞吐量下降。

---

## ✅ 八、总结

`ReentrantLock` 是 `synchronized` 的增强版，提供了：

- ✅ 更灵活的锁获取方式（可中断、可超时）
- ✅ 更强大的线程协作机制（Condition）
- ✅ 更丰富的状态查询
- ✅ 可配置公平性

> 📌 **建议**：
> - 日常开发优先使用 `synchronized`（简单、安全）
> - 在需要**高级功能**（如超时、中断、多条件）时，使用 `ReentrantLock`

---

如果你正在实现线程安全的类、并发容器、或复杂同步逻辑，`ReentrantLock` 是一个非常强大且值得掌握的工具。