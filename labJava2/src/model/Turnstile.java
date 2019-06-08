package model;

import model.State.State;
import model.State.StatePASS;
import model.State.StateSTOP;
import model.State.StateWARNING;
import model.card.Card;
import model.turnstileSensors.*;

import java.util.Calendar;

public class Turnstile {
    private int id;
    private int numberOfPasses;
    private State state;

    private CardsReceiver cardsReceiver;
    private DeviceForBlockingAccess deviceForBlockingAccess;
    private MyTimer timer;
    private OpticalSensor opticalSensor1;
    private OpticalSensor opticalSensor2;
    private OpticalSensor opticalSensor3;
    private DeviceForSoundSignaling deviceForSoundSignaling;
    private Indicator indicator;

    private Calendar currentDay;

    public Turnstile(int id) {
        this.id = id;
        this.state = new StateSTOP(this);
        this.cardsReceiver = new CardsReceiver(this.id);
        this.deviceForBlockingAccess = new DeviceForBlockingAccess(this.id);
        this.timer = new MyTimer(this.id, 5);
        this.opticalSensor1 = new OpticalSensor(this.id);
        this.opticalSensor2 = new OpticalSensor(this.id);
        this.opticalSensor3 = new OpticalSensor(this.id);
        this.deviceForSoundSignaling = new DeviceForSoundSignaling(this.id, null);
        this.indicator = new Indicator(this.id);
        currentDay = Calendar.getInstance();
    }

    public Turnstile() {
    }

    public int getId() {
        return id;
    }


    public int getNumberOfPasses() {
        return numberOfPasses;
    }

    public boolean workCardReceiver(Card card) {
        if(state.processCard(card)) {
            ++numberOfPasses;
            return true;
        }
        else {
            return false;
        }
        //return state.processCard(card);
    }

    public void changeState(State state) {
        this.state = state;
        if (state.getClass() == StatePASS.class) {
            indicator.changeOnPASS();
        } else {
            if (state.getClass() == StateWARNING.class) {
                indicator.changeOnWARNING();
            } else {
                if (state.getClass() == StateSTOP.class) {
                    indicator.changeOnSTOP();
                }
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    //public void setExecutorService(ExecutorService executorService) {
    //    this.executorService = executorService;
    //}

    public void setNumberOfPasses(int numberOfPasses) {
        this.numberOfPasses = numberOfPasses;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCardsReceiver(CardsReceiver cardsReceiver) {
        this.cardsReceiver = cardsReceiver;
    }

    public void setDeviceForBlockingAccess(DeviceForBlockingAccess deviceForBlockingAccess) {
        this.deviceForBlockingAccess = deviceForBlockingAccess;
    }

    public void setTimer(MyTimer timer) {
        this.timer = timer;
    }

    public void setOpticalSensor1(OpticalSensor opticalSensor1) {
        this.opticalSensor1 = opticalSensor1;
    }

    public void setOpticalSensor2(OpticalSensor opticalSensor2) {
        this.opticalSensor2 = opticalSensor2;
    }

    public void setOpticalSensor3(OpticalSensor opticalSensor3) {
        this.opticalSensor3 = opticalSensor3;
    }

    public void setDeviceForSoundSignaling(DeviceForSoundSignaling deviceForSoundSignaling) {
        this.deviceForSoundSignaling = deviceForSoundSignaling;
    }


    public static Builder newBuilder() {
        return new Turnstile().new Builder();
    }

    public class Builder {
        private Builder() { }

        public Builder setId(int id) {
            Turnstile.this.id = id;
            return this;
        }

//        public Builder setExecutorService(ExecutorService executorService) {
//            Turnstile.this.executorService = executorService;
//            return this;
//        }

        public Builder setNumberOfPasses(int numberOfPasses) {
            Turnstile.this.numberOfPasses = numberOfPasses;
            return this;
        }

        public Builder setState(State state) {
            Turnstile.this.state = state;
            return this;
        }

        public Builder setCardsReceiver(CardsReceiver cardsReceiver) {
            Turnstile.this.cardsReceiver = cardsReceiver;
            return this;
        }

        public Builder setDeviceForBlockingAccess(DeviceForBlockingAccess deviceForBlockingAccess) {
            Turnstile.this.deviceForBlockingAccess = deviceForBlockingAccess;
            return this;
        }

        public Builder setTimer(MyTimer timer) {
            Turnstile.this.timer = timer;
            return this;
        }

        public Builder setOpticalSensor1(OpticalSensor opticalSensor1) {
            Turnstile.this.opticalSensor1 = opticalSensor1;
            return this;
        }

        public Builder setOpticalSensor2(OpticalSensor opticalSensor2) {
            Turnstile.this.opticalSensor2 = opticalSensor2;
            return this;
        }

        public Builder setOpticalSensor3(OpticalSensor opticalSensor3) {
            Turnstile.this.opticalSensor3 = opticalSensor3;
            return this;
        }

        public Builder setDeviceForSoundSignaling(DeviceForSoundSignaling deviceForSoundSignaling) {
            Turnstile.this.deviceForSoundSignaling = deviceForSoundSignaling;
            return this;
        }

        public Builder setIndicator(Indicator indicator) {
            Turnstile.this.indicator = indicator;
            return this;
        }

        public Turnstile build() {
            return Turnstile.this;
        }
    }

    public CardsReceiver getCardsReceiver() {
        return cardsReceiver;
    }

    public DeviceForBlockingAccess getDeviceForBlockingAccess() {
        return deviceForBlockingAccess;
    }

    public MyTimer getTimer() {
        return timer;
    }

    public OpticalSensor getOpticalSensor1() {
        return opticalSensor1;
    }

    public OpticalSensor getOpticalSensor2() {
        return opticalSensor2;
    }

    public OpticalSensor getOpticalSensor3() {
        return opticalSensor3;
    }

    public DeviceForSoundSignaling getDeviceForSoundSignaling() {
        return deviceForSoundSignaling;
    }

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }


    public Calendar getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(Calendar currentDay) {
        this.currentDay = currentDay;
    }
}