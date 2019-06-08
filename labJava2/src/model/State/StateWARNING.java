package model.State;

import model.Turnstile;
import model.card.Card;

public class StateWARNING extends State {
    public StateWARNING(Turnstile turnstile) {
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