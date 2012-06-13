package com.maximgalushka.concurrency.backery;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * <p></p>
 *
 * @author Maxim Galushka
 * @since 12.06.12
 */
public class Bakery implements Lock {

    private boolean[] flag;

    private TimestampSystem system;
    private ThreadLocal<Integer> threadId = new ThreadLocal<Integer>();

    public Bakery(Integer threads) {
        system = new TimestampSystemImpl(threads);
    }

    @Override
    public void lock() {
        int i = threadId.get();
        flag[i] = true;

        Timestamp t = new TimestampImpl(Collections.max(Arrays.asList(system.scan())).getLabel() + 1);


        //while ((∃k != i)(flag[k] && (label[k],k) << (label[i],i))) {};
    }

    @Override
    public void unlock() {

    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }
}
