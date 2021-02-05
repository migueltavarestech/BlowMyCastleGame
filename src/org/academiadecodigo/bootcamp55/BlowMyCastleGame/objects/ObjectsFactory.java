package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects;

public class ObjectsFactory {

    public void init(int bombs, int wallBlocks) {

        for (int i=0; i<=bombs; i++){
            Bomb bomb = new Bomb();
        }

        for (int a=0; a<=wallBlocks; a++) {
            Wall wallBlock = new Wall();
        }
    }

}
