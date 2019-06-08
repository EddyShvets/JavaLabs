package model.State;

import model.Turnstile;
import model.card.Card;

public abstract class State {
    protected Turnstile turnstile;

    State(Turnstile turnstile) {
        this.turnstile = turnstile;
    }

    public abstract boolean processCard(Card card);
    public abstract void end();
}
