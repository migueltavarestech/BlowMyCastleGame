package org.academiadecodigo.bootcamp55.BlowMyCastleGame.objects.castle;

import org.academiadecodigo.bootcamp55.BlowMyCastleGame.Grids.Grid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HealthBar {

    private static final int healthBarLength = 200;
    private static int count = 0;
    private int damageTaken = 0;
    private int healthBarNumber;

    public HealthBar(int healthBarNumber) {
        this.healthBarNumber = healthBarNumber;
        if (healthBarNumber == 1) {
            drawC1HealthBar();
        } else if (healthBarNumber == 2) {
            drawC2HealthBar();
        }
    }

    public void drawC1HealthBar() {
        Rectangle healthBarRED = new Rectangle(Grid.columnToX(1), Grid.rowToY(17),healthBarLength,10);
        healthBarRED.setColor(Color.RED);
        healthBarRED.fill();

        Picture healthNameIcon = new Picture(Grid.columnToX(1), Grid.rowToY(17)+10, "HealthNameIcon.png");
        healthNameIcon.draw();
    }

    public void drawC2HealthBar() {
        Rectangle healthBarRED = new Rectangle(Grid.columnToX(19), Grid.rowToY(17),healthBarLength,10);
        healthBarRED.setColor(Color.RED);
        healthBarRED.fill();

        Rectangle healthBarWHITE = new Rectangle(Grid.columnToX(19)+healthBarLength-damageTaken, Grid.rowToY(17), damageTaken, 10);
        healthBarWHITE.setColor(Color.WHITE);
        healthBarWHITE.fill();

        Picture healthNameIcon = new Picture(Grid.columnToX(19), Grid.rowToY(17)+10, "HealthNameIcon.png");
        healthNameIcon.draw();
    }

    public void showDamage(Castle castle, int damage) {
        if (castle.getCastleNumber() == 1) {
            damageTaken += damage*2;

            Rectangle healthBarWHITE = new Rectangle(Grid.columnToX(1)+healthBarLength-damageTaken, Grid.rowToY(17), damageTaken, 10);
            healthBarWHITE.setColor(Color.WHITE);
            healthBarWHITE.fill();
        } else {
            damageTaken += damage*2;

            Rectangle healthBarWHITE = new Rectangle(Grid.columnToX(19)+healthBarLength-damageTaken, Grid.rowToY(17), damageTaken, 10);
            healthBarWHITE.setColor(Color.WHITE);
            healthBarWHITE.fill();
        }
    }

}
