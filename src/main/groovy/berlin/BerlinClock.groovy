package berlin

class BerlinClock {

    Date date
    LightBar secondBar
    LightBar topHourBar
    LightBar bottomHourBar
    LightBar topMinuteBar
    LightBar bottomMinuteBar

    BerlinClock() {
        this.secondBar = new LightBar(1, 2)
        this.topHourBar = new LightBar(4, 5)
        this.bottomHourBar = new LightBar(4, 1)
        this.topMinuteBar = new LightBar(11, 5)
        this.bottomMinuteBar = new LightBar(4, 1)
    }

    /**
     *
     * @param Date date
     *      Coverting actual time to Berlin Clock display
     */
    void convertTime(Date date) {
        this.date = date
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(date)
        int seconds = calendar.get(Calendar.SECOND)
        secondBar.numberOfLightsOn = (seconds % 2) ? 1 : 0
        int hours = calendar.get(Calendar.HOUR_OF_DAY)
        topHourBar.defineNumberOfLightsOn(hours)
        bottomHourBar.numberOfLightsOn = hours - (topHourBar.numberOfLightsOn * topHourBar.unitPerLamp)
        int minutes = calendar.get(Calendar.MINUTE)
        topMinuteBar.defineNumberOfLightsOn(minutes)
        bottomMinuteBar.numberOfLightsOn = minutes - (topMinuteBar.numberOfLightsOn * topMinuteBar.unitPerLamp)
    }

    String displayTime() {
        String output = "Date: ${date}\n"
        output += "Seconds: ${secondBar.numberOfLightsOn ? "even" : "odd"}\n"
        output += "Top Hour bar : ${topHourBar.numberOfLightsOn}\n"
        output += "Bottom Hour bar: ${bottomHourBar.numberOfLightsOn}\n"
        output += "Top Minute bar: ${topMinuteBar.numberOfLightsOn}\n"
        output += "Bottom Minute bar: ${bottomMinuteBar.numberOfLightsOn}"
        return output
    }

}
