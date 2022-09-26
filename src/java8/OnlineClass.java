package java8;

import java8.optional.Progress;

import java.util.Optional;

public class OnlineClass {

    private Integer id;
    private String title;
    private boolean closed;
    public Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     * Optional의 사용에 딱히 제약이 있는 것은 아니지만,
     * return 타입에만 쓰는 것이 권장사항이다.
     */
    public Optional<Progress> getProgress() {
        /**
         * of와 ofNullable의 차이.
         * of는 안에 null값이 들어오면 NPE가 발생한다.
         * ofNullable은 null값이 들어올 수도 있다는 뜻
         */
        // return Optional.of(progress);
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
