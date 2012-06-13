package com.maximgalushka.concurrency.backery;

/**
 * <p></p>
 *
 * @author Maxim Galushka
 * @since 12.06.12
 */
public interface TimestampSystem {

    public Timestamp[] scan();

    public void label(Timestamp timestamp, int i);

}
