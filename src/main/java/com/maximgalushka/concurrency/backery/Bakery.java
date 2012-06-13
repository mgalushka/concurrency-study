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

        Timestamp max = Collections.max(Arrays.asList(system.scan()));
        Timestamp next = new TimestampImpl(i, ((TimestampImpl) max).getLabel() + 1);
        system.label(next, i);

        while (check(flag, system, next, i)) {};
    }

    private static boolean check(boolean[] flag,
                                 TimestampSystem system,
                                 Timestamp timestamp,
                                 int current){

        for(int i=0; i<= flag.length; i++){
            if (i == current) continue;
            if(flag[i] && system.scan()[i].compareTo(timestamp) > 0)
                return true;
        }
        return false;
    }

    @Override
    public void unlock() {
        flag[threadId.get()] = false;
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
