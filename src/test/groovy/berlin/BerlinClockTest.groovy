package berlin

import spock.lang.Specification


class BerlinClockTest extends Specification {

    Random random = new Random()

    void "test test odd seconds"() {
        given:
        Calendar calendar = Calendar.getInstance()
        BerlinClock berlinClock = new BerlinClock()
        Date date = new Date()
        when:
        calendar.setTimeInMillis(date.getTime())
        int second = random.nextInt(57)
        second = !(second % 2) ? (second + 1) : second
        calendar.set(Calendar.SECOND, second)
        berlinClock.convertTime(calendar.time)
        println berlinClock.displayTime()
        then:
        berlinClock.secondBar.numberOfLightsOn
    }

    void "test test even seconds"() {
        given:
        Calendar calendar = Calendar.getInstance()
        BerlinClock berlinClock = new BerlinClock()
        Date date = new Date()
        when:
        calendar.setTimeInMillis(date.getTime())
        int second = random.nextInt(57)
        second = !(second % 2) ? second : (second + 1)
        calendar.set(Calendar.SECOND, second)
        berlinClock.convertTime(calendar.time)
        println berlinClock.displayTime()
        then:
        !berlinClock.secondBar.numberOfLightsOn
    }

    void "test test hours"() {
        given:
        Calendar calendar = Calendar.getInstance()
        BerlinClock berlinClock = new BerlinClock()
        Date date = new Date()
        when:
        calendar.setTimeInMillis(date.getTime())
        calendar.set(Calendar.HOUR_OF_DAY, 12)
        berlinClock.convertTime(calendar.time)
        println berlinClock.displayTime()
        then:
        berlinClock.topHourBar.numberOfLightsOn == 2
        berlinClock.bottomHourBar.numberOfLightsOn == 2

    }

    void "test test minutes"() {
        given:
        Calendar calendar = Calendar.getInstance()
        BerlinClock berlinClock = new BerlinClock()
        Date date = new Date()
        when:
        calendar.setTimeInMillis(date.getTime())
        calendar.set(Calendar.HOUR_OF_DAY, 12)
        calendar.set(Calendar.MINUTE, 53)
        berlinClock.convertTime(calendar.time)
        println berlinClock.displayTime()
        then:
        berlinClock.topMinuteBar.numberOfLightsOn == 10
        berlinClock.bottomMinuteBar.numberOfLightsOn == 3

    }

}
