package com.maximgalushka.concurrency.backery;

/**
 * <p></p>
 *
 * @author Maxim Galushka
 * @since 12.06.12
 */
public class TimestampImpl implements Timestamp{

    private Integer threadId;
    private Integer label;

    public TimestampImpl(Integer threadId, Integer label) {
        this.threadId = threadId;
        this.label = label;
    }

//    @Override
//    public Integer compare(Timestamp timestamp) {
//        if(!(timestamp instanceof TimestampImpl)) {
//            throw new RuntimeException("RE!");
//        }
//
//        TimestampImpl ti = (TimestampImpl) timestamp;
//        Integer result = label.compareTo(ti.label);
//        if(result == 0){
//            return threadId.compareTo(ti.threadId);
//        }
//        return result;
//    }

    @Override
    public int compareTo(Timestamp timestamp) {
        if(!(timestamp instanceof TimestampImpl)) {
            throw new RuntimeException("RE!");
        }

        TimestampImpl ti = (TimestampImpl) timestamp;
        Integer result = label.compareTo(ti.label);
        if(result == 0){
            return threadId.compareTo(ti.threadId);
        }
        return result;
    }

    public Integer getThreadId() {
        return threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }
}
