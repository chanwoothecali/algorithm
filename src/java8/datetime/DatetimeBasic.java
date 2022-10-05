package java8.datetime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DatetimeBasic {

    /**
     * JAVA 8 이전 쓰이던 Date API
     * Date 클래스의 문제점
     * 1.
     * 아래 예시처럼 setTime으로 날짜 변경이 가능
     * -> mutable한 객체. 멀티스레드 환경에서 쓰기 적합하지 못하다.
     * mutable 하기 때문에 thread safe 하지 않다.
     * 다른 스레드에서 참조할 경우 변경된 데이터를 참조할 가능성이 있다.
     *
     * 2.
     * 클래스 이름이 명확하지 못하다.
     * Date인데 시간까지 다룸
     *
     * 3.
     * 버그 발생의 여지가 많고, type safety 하지 못하다.
     */
    public static void date() throws InterruptedException {
        // 1. 문제점
        Date date = new Date();
        long time = date.getTime();
        System.out.println("date = " + date);
        System.out.println("time = " + time);

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println("after3Seconds = " + after3Seconds);
        after3Seconds.setTime(time);
        System.out.println("after3Seconds = " + after3Seconds);
        // after3Seconds = Mon Sep 26 16:36:35 KST 2022
        // after3Seconds = Mon Sep 26 16:36:32 KST 2022

        // 3. 문제점
        // 1994년 2월 25일이라고 생각하고 썼지만?
        GregorianCalendar chanwooBirthDay = new GregorianCalendar(1994, 2, 25);
        System.out.println("chanwooBirthDay = " + chanwooBirthDay.getTime()); // 1994년 3월 25일
        new GregorianCalendar(1994, Calendar.FEBRUARY, 25); // 이렇게 써야함
        // Month가 0부터 시작하는 문제점.
        // 그리고 매개변수에 아무 int값이나 들어올 수 있는 점 -> type safety 하지 못하다. new GregorianCalendar(1994124, -15, 35);
        // type safety 하게 받으려면? int가 아닌 enum값을 받도록 수정해야 함
    }

    /**
     * 자바 8 에서 제공하는 Date-Time API
     * 디자인 철학은 다음과 같다.
     *
     * 1. Clear
     * API의 메소드가 잘 정의되어 있어 동작이 명확하고 예상이 된다.
     * Date처럼 이름은 Date인데 시간을 꺼내고, 그 시간도 무슨 어느 시간을 기점으로 밀리세컨드를 꺼내고 이러면 안된다.
     * Date에서 getTime하면 long 나오고, Calendar에서 getTime하면 Date 나오고...
     *
     * 2. Fluent
     * API가 유창한 인터페이스를 제공하여 코드를 읽기 쉽게 만들었다.
     * 대부분의 메소드가 null값이 있는 매개 변수를 허용하지 않고 null을 반환하지 않는다.
     *
     * 3. Immutable
     * Date-Time API의 대부분의 클래스는 변경할 수 없는 객체를 생성한다.
     * 시간을 더하고 빼는 메소드가 실행되면 기존 인스턴스가 변하는 게 아니라 새로운 인스턴스를 반환하도록 변경
     *
     * 4. Extensible
     * Date-Time API는 가능한 모든 곳에서 확장할 수 있다.
     */
    public static void datetimeBasic() {
        /**
         * 자바 8 Date-Time 사용법
         */
        /**
         * Instant
         * 기계식 시간 사용법
         * EPOCH 시간 기준
         */
        Instant instant = Instant.now();
        System.out.println("instant = " + instant); // 기준시 UTC, GMT

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println("zonedDateTime = " + zonedDateTime); // 시스템

        /**
         * LocalDateTime
         * 인간용 시간 사용법
         * Local이 붙어있는 것으로 알 수 있듯이 현재 서버의 TimeZone 기준으로 시간을 반환한다.
         * 서버가 타 지역에 있으면 해당 존 시간을 반환할테니 주의할 것.
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);
        LocalDateTime birthDay = LocalDateTime.of(1994, 2, 25, 12, 0, 0);
        System.out.println("birthDay = " + birthDay);
        // 연산 가능
        LocalDateTime localDateTimePlus10 = localDateTime.plus(10, ChronoUnit.DAYS);

        /**
         * Period & Duration
         * 기간
         * Period는 인간용 LocalDate 시간 비교
         * Duration은 기계용 Instant 시간 비교
         */
        LocalDate today = LocalDate.now();
        LocalDate myBirthDay = LocalDate.of(1994, 2, 25);

        Period period1 = Period.between(myBirthDay, today);
        System.out.println("period1 = " + period1);
        // 이러면 단순 날짜 비교. 2/25과 9/27이 2일 차이 난다고 뜸. 27과 25만 비교한 것임.
        System.out.println("period1.getDays() = " + period1.getDays());
        System.out.println("period1.get(ChronoUnit.DAYS) = " + period1.get(ChronoUnit.DAYS));
        Period period2 = myBirthDay.until(today);
        System.out.println("period2.getDays() = " + period2.getDays());
        // 전체 일수를 계산하고 싶으면 아래처럼 사용하면 된다.
        long betweenDays = ChronoUnit.DAYS.between(myBirthDay, today);
        System.out.println("betweenDays = " + betweenDays);

        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration duration1 = Duration.between(now, plus);
        System.out.println("duration1.getSeconds() = " + duration1.getSeconds());

        /**
         * DateTimeFormatter
         * 시간을 원하는 형태로 출력해주는 포맷 도구
         */
        LocalDateTime localDateTime1 = LocalDateTime.now();
        // 직접 정의해도 되지만, 기존에 enum으로 미리 정의된 것이 많으니 그걸 써도 된다. API 문서 참조
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("localDateTime1.format(MMddyyyy) = " + localDateTime1.format(MMddyyyy));
        // 반대로 파싱도 가능
        LocalDate parse = LocalDate.parse("07/15/1982", MMddyyyy);
        System.out.println("parse = " + parse);

        /**
         * 자바 8 이전에 쓰였던 레거시 API도 지원
         * Date, Calendar, TimeZone
         */
        Date date = new Date();
        Instant toInstant = date.toInstant();
        Date from = Date.from(toInstant);

        Calendar calendar = new GregorianCalendar();
        ZonedDateTime zonedDateTime1 = calendar.toInstant().atZone(ZoneId.systemDefault());
        LocalDateTime toLocalDateTime = zonedDateTime1.toLocalDateTime();
        GregorianCalendar.from(zonedDateTime1);

        ZoneId zoneId1 = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId1);
    }

    public static void main(String[] args) throws InterruptedException {
//        date();
        datetimeBasic();
    }
}
