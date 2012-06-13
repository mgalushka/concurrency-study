package com.maximgalushka.concurrency.backery;

/**
 * <p></p>
 *
 * @author Maxim Galushka
 * @since 12.06.12
 */
public class TimestampSystemImpl implements TimestampSystem {

    private Timestamp[] label;

    public TimestampSystemImpl(Integer count) {
        label = new Timestamp[count];
    }

    @Override
    public Timestamp[] scan() {
        return label;
    }

    @Override
    public void label(Timestamp timestamp, int i) {
        label[i] = timestamp;
    }
}
