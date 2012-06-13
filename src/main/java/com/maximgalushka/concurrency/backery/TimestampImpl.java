package com.maximgalushka.concurrency.backery;

/**
 * <p></p>
 *
 * @author Maxim Galushka
 * @since 12.06.12
 */
public class TimestampImpl implements Timestamp {

    private Integer label;

    public TimestampImpl(Integer label) {
        this.label = label;
    }

    @Override
    public boolean compare(Timestamp timestamp) {
        // TODO: implement this properly
        return false;
    }

    @Override
    public Integer getLabel() {
        return label;
    }

    @Override
    public int compareTo(Timestamp o) {
        // TODO: implement this properly
        return 0;
    }
}
