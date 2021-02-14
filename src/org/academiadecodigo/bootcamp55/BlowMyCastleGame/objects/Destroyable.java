package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;

public interface Destroyable {

    void hit(int hit) throws InterruptedException;

    boolean isDestroyed();

}
