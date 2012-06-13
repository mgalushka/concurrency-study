package com.maximgalushka.concurrency.backery;

/**
 * <p></p>
 *
 * @author Maxim Galushka
 * @since 12.06.12
 */
public interface Timestamp extends Comparable<Timestamp> {

    boolean compare(Timestamp timestamp);

    Integer getLabel();

}
