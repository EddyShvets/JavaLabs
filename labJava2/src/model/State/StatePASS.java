package model.State;

import model.Turnstile;
import model.card.Card;

public class StatePASS extends State {

    public StatePASS(Turnstile turnstile) {
        super(turnstile);
    }

    @Override
    public boolean processCard(Card card) {
        return false;
    }

    @Override
    public void end() {

    }
}
