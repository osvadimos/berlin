package berlin


class LightBar {

    int numberOfLights
    int unitPerLamp
    int numberOfLightsOn

    LightBar(int numberOfLights, int unitPerLamp){
        this.numberOfLights = numberOfLights
        this.unitPerLamp = unitPerLamp
    }

    void defineNumberOfLightsOn(int numberOfUnits){
        numberOfLightsOn = numberOfUnits / unitPerLamp
    }

}