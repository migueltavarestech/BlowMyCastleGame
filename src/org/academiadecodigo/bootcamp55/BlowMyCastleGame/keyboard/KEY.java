package org.academiadecodigo.bootcamp55.BlowMyCastleGame.keyboard;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public enum KEY {
    A(65),
    D(68),
    DOWN(40),
    LEFT(37),
    RIGHT(39),
    S(83),
    SPACE(32),
    UP(38),
    W(87),
    I(KeyboardEvent.KEY_I),
    Q(KeyboardEvent.KEY_Q),
    ESC(KeyboardEvent.KEY_ESC),
    ENTER(KeyboardEvent.KEY_ENTER),
    F11(KeyboardEvent.KEY_F11),        //Decrease sound volume
    F12(KeyboardEvent.KEY_F12),        //Increase sound volume
    F10(KeyboardEvent.KEY_F10),        //Sound mute / un-mute
    P(KeyboardEvent.KEY_P),
    ZERO(KeyboardEvent.KEY_0);


    private int keyCode;

    private KEY(int keyCode) {
        this.keyCode = keyCode;
    }

    public static KEY withCode(int code) {
        KEY[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            KEY key = var1[var3];
            if (key.keyCode == code) {
                return key;
            }
        }

        return null;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

}
