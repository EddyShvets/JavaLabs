package view;

import model.State.State;
import model.State.StatePASS;
import model.State.StateSTOP;
import model.State.StateWARNING;
import model.card.Card;
import model.turnstileSensors.OpticalSensor;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class View {
    private final Font myFont;
    private final JLabel cardReceiver;
    private final JLabel backForCardReceiver;
    private final ImageIcon opticalSensorIconEnabled;

    private final ImageIcon opticalSensorIconDisabled;
    private final JLabel nfc;
    private final JButton btn1;
    private final JButton btn2;
    private final JButton btn3;
    private final JLabel opticalSensors;
    private final JLabel backForOpticalSensors;
    private final JLabel opticalSensor1;
    private final JLabel opticalSensor2;
    private final JLabel indicatorText;
    private final JLabel backForIndicator;
    private final ImageIcon indicatorPASS;
    private final ImageIcon indicatorSTOP;
    private final JLabel indicator;
    private final JLabel opticalSensor3;
    private final ImageIcon indicatorWARNING;
    private JFrame frame;


    public View() {
//        frame = new JFrame();

        myFont = new Font("MyFont", Font.PLAIN, 24);

        cardReceiver = new JLabel("Card receiver");
        cardReceiver.setBounds(160, 40, 200, 40);
        cardReceiver.setFont(myFont);

        backForCardReceiver = new JLabel();
        backForCardReceiver.setBounds(30, 30, 400, 510);
        backForCardReceiver.setBackground(Color.white);
        backForCardReceiver.setOpaque(true);

        opticalSensorIconEnabled = new ImageIcon("img/opticalSensorEnable.png");
        opticalSensorIconDisabled = new ImageIcon("img/opticalSensorDisable.png");

        nfc = new JLabel();
        nfc.setBounds(80, 100, 290, 187);
        nfc.setIcon(new ImageIcon("img/cardReceiver.png"));

        btn1 = new JButton("Attach a valid card");
        btn1.setBounds(90, 320, 275, 40);
        btn1.setBackground(new Color(201, 230, 238));
        btn1.setBorder(null);

        btn2 = new JButton("Attach an invalid card (expiration date)");
        btn2.setBounds(90, 395, 275, 40);

        btn3 = new JButton("Attach an invalid card (number of trips)");
        btn2.setBackground(new Color(201, 230, 238));
        btn2.setBorder(null);

        btn3.setBounds(90, 470, 275, 40);
        btn3.setBackground(new Color(201, 230, 238));
        btn3.setBorder(null);


        opticalSensors = new JLabel("Optical sensors");
        opticalSensors.setBounds(620, 40, 200, 40);
        opticalSensors.setFont(myFont);

        backForOpticalSensors = new JLabel();
        backForOpticalSensors.setBounds(495, 30, 400, 190);
        backForOpticalSensors.setBackground(Color.white);
        backForOpticalSensors.setOpaque(true);

        opticalSensor1 = new JLabel();
        opticalSensor1.setBounds(530, 100, 90, 90);
        opticalSensor1.setIcon(opticalSensorIconDisabled);
        opticalSensor1.setDisabledIcon(opticalSensorIconDisabled);


        opticalSensor2 = new JLabel();
        opticalSensor2.setBounds(650, 100, 90, 90);
        opticalSensor2.setIcon(opticalSensorIconDisabled);
        opticalSensor2.setDisabledIcon(opticalSensorIconDisabled);


        opticalSensor3 = new JLabel();
        opticalSensor3.setBounds(770, 100, 90, 90);
        opticalSensor3.setIcon(opticalSensorIconDisabled);
        opticalSensor3.setDisabledIcon(opticalSensorIconDisabled);

        indicatorText = new JLabel("Indicator");
        indicatorText.setBounds(660, 300, 200, 40);
        indicatorText.setFont(myFont);

        backForIndicator = new JLabel();
        backForIndicator.setBounds(495, 280, 400, 280);
        backForIndicator.setBackground(Color.white);
        backForIndicator.setOpaque(true);

        indicatorPASS = new ImageIcon("img/pass.png");
        indicatorSTOP = new ImageIcon("img/stop.png");
        indicatorWARNING = new ImageIcon("img/warning.png");

        indicator = new JLabel();
        indicator.setBounds(550, 350, 290, 187);
        indicator.setIcon(indicatorSTOP);
//
//        frame.add(indicatorText);
//        frame.add(indicator);
//        frame.add(opticalSensors);
//        frame.add(cardReceiver);
//        frame.add(opticalSensor1);
//        frame.add(opticalSensor2);
//        frame.add(opticalSensor3);
//        frame.add(btn1);
//        frame.add(btn2);
//        frame.add(btn3);
//        frame.add(nfc);
//        frame.add(backForCardReceiver);
//        frame.add(backForOpticalSensors);
//        frame.add(backForIndicator);
//
//        frame.setSize(1000, 650);//400 width and 500 height
//        frame.setLayout(null);//using no layout managers
//        frame.setVisible(true);//making the frame visible
    }

    public void changeIndicatorOnPASS() {
        indicator.setIcon(indicatorPASS);
    }

    public void changeIndicatorOnSTOP() {
        indicator.setIcon(indicatorSTOP);
    }

    public void changeIndicatorOnWARNING() {
        indicator.setIcon(indicatorWARNING);
    }

    public void showWarning(Card card) {
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        String formatter = formmat1.format(ldt);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate = card.getExpirationDate().getTime();

        JOptionPane.showMessageDialog(null,
                "Current date: "       + formatter + '\n' +
                         "Id of the card: "     + card.getId() + '\n' +
                         "Expiration date: "    + dateFormat.format(expirationDate) + '\n' +
                         "Number of trips: "    + card.getNumberOfTrips()
        );
    }

    public void changeIndicatorState(State state) {
        if (state.getClass() == StatePASS.class) {
            changeIndicatorOnPASS();
        } else {
            if (state.getClass() == StateWARNING.class) {
                changeIndicatorOnWARNING();
            } else {
                if (state.getClass() == StateSTOP.class) {
                    changeIndicatorOnSTOP();
                }
            }
        }
    }

    public void blockButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
    }

    public void unBlockButtons() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
    }


    public void checkOpticalSensor1(OpticalSensor opticalSensor) {
        if (opticalSensor.isFlag()) {
            opticalSensor1.setIcon(opticalSensorIconEnabled);
        } else {
            opticalSensor1.setIcon(opticalSensorIconDisabled);
        }
    }

    public void checkOpticalSensor2(OpticalSensor opticalSensor) {
        if (opticalSensor.isFlag()) {
            opticalSensor2.setIcon(opticalSensorIconEnabled);
        } else {
            opticalSensor2.setIcon(opticalSensorIconDisabled);
        }
    }

    public void checkOpticalSensor3(OpticalSensor opticalSensor) {
        if (opticalSensor.isFlag()) {
            opticalSensor3.setIcon(opticalSensorIconEnabled);
        } else {
            opticalSensor3.setIcon(opticalSensorIconDisabled);
        }
    }

    public void blockAccess() {
        JOptionPane.showMessageDialog(null,
                "ERROR: Access denied!"
        );
    }

    public void timerMessage() {
        JOptionPane.showMessageDialog(null,
                "Timer will be started!"
        );
    }


    public Font getMyFont() {
        return myFont;
    }

    public JLabel getCardReceiver() {
        return cardReceiver;
    }

    public JLabel getBackForCardReceiver() {
        return backForCardReceiver;
    }

    public ImageIcon getOpticalSensorIconEnabled() {
        return opticalSensorIconEnabled;
    }

    public ImageIcon getOpticalSensorIconDisabled() {
        return opticalSensorIconDisabled;
    }

    public JLabel getNfc() {
        return nfc;
    }

    public JButton getBtn1() {
        return btn1;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public JButton getBtn3() {
        return btn3;
    }

    public JLabel getOpticalSensors() {
        return opticalSensors;
    }

    public JLabel getBackForOpticalSensors() {
        return backForOpticalSensors;
    }

    public JLabel getOpticalSensor1() {
        return opticalSensor1;
    }

    public JLabel getOpticalSensor2() {
        return opticalSensor2;
    }

    public JLabel getIndicatorText() {
        return indicatorText;
    }

    public JLabel getBackForIndicator() {
        return backForIndicator;
    }

    public ImageIcon getIndicatorPASS() {
        return indicatorPASS;
    }

    public ImageIcon getIndicatorSTOP() {
        return indicatorSTOP;
    }

    public JLabel getIndicator() {
        return indicator;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }


    public JLabel getOpticalSensor3() {
        return opticalSensor3;
    }


    public void displayPassIndicator() {
        // TODO
    }

    public void displayStopIndicator() {
        // TODO
    }
}
