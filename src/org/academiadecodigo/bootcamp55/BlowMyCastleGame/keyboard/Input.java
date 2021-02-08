package org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard;

public class Input {
    private KEY key;
    private EVENT event;

    public Input(KEY key, EVENT keyPress) {
        this.key = key;
        this.event = keyPress;
    }

    public KEY getKey() {
        return this.key;
    }

    public EVENT getEvent() {
        return this.event;
    }

    public void setEvent(EVENT event) {
        this.event = event;
    }
}
