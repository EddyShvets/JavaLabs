package controller;

import Factory.DAOFactory;
import model.State.State;
import model.State.StatePASS;
import model.State.StateSTOP;
import model.State.StateWARNING;
import model.Turnstile;
import model.card.Card;
import model.dbEntity.Passes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Station {
    private ArrayList<Turnstile> listOfTurnstiles;
    int currentTurnstileId;

    private static Station instance;

    public static Station getInstance() {
        if (instance == null) {
            instance = new Station(new ArrayList<>());
        }
        return instance;
    }


    private Station(ArrayList<Turnstile> listOfTurnstiles) {
        for (int i = 0; i < 5; ++i) {
            listOfTurnstiles.add(new Turnstile(i));
        }
        this.listOfTurnstiles = listOfTurnstiles;
    }

    public String proccessButton1() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DATE, 1);

        return workingOfCardReceiver(new Card(0, cal, 50));
    }

    public String proccessButton2() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2018);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DATE, 1);

        return workingOfCardReceiver(new Card(1, cal, 50));
    }

    public String proccessButton3() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2019);
        cal.set(Calendar.MONTH, Calendar.JULY);
        cal.set(Calendar.DATE, 1);

        return workingOfCardReceiver(new Card(2, cal, 0));
    }

    private String workingOfCardReceiver(Card inCard) {
        if (getCurrentTurnstile().workCardReceiver(inCard)) {
            State state = new StatePASS(getCurrentTurnstile());
            getCurrentTurnstile().changeState(state);
            getCurrentTurnstile().getIndicator().setIndicatorString("PASS");

            return getCurrentTurnstile().getIndicator().getIndicatorString();
        } else {
            State state = new StateWARNING(getCurrentTurnstile());
            getCurrentTurnstile().changeState(state);
            getCurrentTurnstile().getIndicator().setIndicatorString("WARNING");

            state = new StateSTOP(getCurrentTurnstile());
            getCurrentTurnstile().changeState(state);
            getCurrentTurnstile().getIndicator().setIndicatorString("STOP");
            return getCurrentTurnstile().getIndicator().getIndicatorString();
        }
    }

    public void proccessSensor1(HttpServletRequest request) {
        getCurrentTurnstile().getOpticalSensor1().setFlag(true);

        if (getCurrentTurnstile().getIndicator().getIndicatorString().equals("PASS")) {
            State state = new StateSTOP(getCurrentTurnstile());
            getCurrentTurnstile().changeState(state);
            getCurrentTurnstile().getIndicator().setIndicatorString("PASS");
        } else {
            getCurrentTurnstile().getDeviceForBlockingAccess().blockAccess(request);
            getCurrentTurnstile().getDeviceForSoundSignaling().playWarningSound(request);

            getCurrentTurnstile().getOpticalSensor1().changeStateOnFalse();
            getCurrentTurnstile().getIndicator().setIndicatorString("STOP");
        }
    }

    public void proccessSensor2(HttpServletRequest request) {
        getCurrentTurnstile().getOpticalSensor2().setFlag(true);

        if (getCurrentTurnstile().getIndicator().getIndicatorString().equals("PASS")) {
            State state = new StateSTOP(getCurrentTurnstile());
            getCurrentTurnstile().changeState(state);
            getCurrentTurnstile().getIndicator().setIndicatorString("PASS");
        } else {
            getCurrentTurnstile().getDeviceForBlockingAccess().blockAccess(request);
            getCurrentTurnstile().getDeviceForSoundSignaling().playWarningSound(request);

            getCurrentTurnstile().getOpticalSensor2().changeStateOnFalse();
            getCurrentTurnstile().getIndicator().setIndicatorString("STOP");
        }
    }

    public void proccessSensor3(HttpServletRequest request) {
        getCurrentTurnstile().getOpticalSensor1().setFlag(true);

        if (getCurrentTurnstile().getIndicator().getIndicatorString().equals("PASS")) {
            State state = new StateSTOP(getCurrentTurnstile());
            getCurrentTurnstile().changeState(state);
            getCurrentTurnstile().getIndicator().setIndicatorString("PASS");
        } else {
            getCurrentTurnstile().getDeviceForBlockingAccess().blockAccess(request);
            getCurrentTurnstile().getDeviceForSoundSignaling().playWarningSound(request);

            getCurrentTurnstile().getOpticalSensor3().changeStateOnFalse();
            getCurrentTurnstile().getIndicator().setIndicatorString("STOP");
        }
    }

    public void postToDb() throws SQLException {
        for (Turnstile turnstile : listOfTurnstiles) {
            if (turnstile.getNumberOfPasses() != 0) {
                Passes passes = new Passes();
                passes.setTurnstileId(turnstile.getId());
                passes.setNumOfPasses(turnstile.getNumberOfPasses());
                passes.setCurrentDay(LocalDateTime.now());

                //new PassesThroughTurnstilesDAO(new Database().getConn()).insert(passes);
                //getDatabase().getPassesThroughTurnstilesDAO().insert(passes);
                DAOFactory.getInstance().getDAO("PassesThroughTurnstilesDAO").insert(passes);
                turnstile.setNumberOfPasses(0);
            }
        }
    }

    public Turnstile getCurrentTurnstile() {
        return listOfTurnstiles.get(currentTurnstileId);
    }

    public ArrayList<Turnstile> getListOfTurnstiles() {
        return listOfTurnstiles;
    }

    public void setListOfTurnstiles(ArrayList<Turnstile> listOfTurnstiles) {
        this.listOfTurnstiles = listOfTurnstiles;
    }

    public int getCurrentTurnstileId() {
        return currentTurnstileId;
    }

    public void setCurrentTurnstileId(int currentTurnStileId) {
        this.currentTurnstileId = currentTurnStileId;
    }
}
