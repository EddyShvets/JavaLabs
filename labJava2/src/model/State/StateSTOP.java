package model.State;

import model.Turnstile;
import model.card.Card;

public class StateSTOP extends State {
    public StateSTOP(Turnstile turnstile) {
        super(turnstile);
    }

    @Override
    public boolean processCard(Card card) {
        if (turnstile.getCardsReceiver().processCard(card)) {
            turnstile.changeState(new StatePASS(turnstile));
            return true;
        }
        return false;
    }

    @Override
    public void end() {

    }
}
