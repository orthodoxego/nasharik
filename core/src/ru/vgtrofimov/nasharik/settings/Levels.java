package ru.vgtrofimov.nasharik.settings;

import java.util.Vector;

import ru.vgtrofimov.nasharik.services.PositionUnit;

public class Levels {

    Vector<Vector<PositionUnit>> vpos;
    Vector<Vector<PositionUnit>> tech;
    Vector<Vector<Integer>> grabber;

    public Levels() {

        //
        // ТЕРРИТОРИЯ ИГРЫ 7584 * 512 = 3880000 кв. км., если считать
        // пиксель квадратным километром.
        //
        // Четырёхмегапиксельная игра, уии!
        //

        vpos = new Vector<>();
        grabber = new Vector<>();
        tech = new Vector<>();

        vpos.add(getLevel01());
        grabber.add(getGrabber01());
        tech.add(getTech01());

        vpos.add(getLevel02());
        grabber.add(getGrabber02());
        tech.add(getTech02());

        vpos.add(getLevel03());
        grabber.add(getGrabber03());
        tech.add(getTech03());

        vpos.add(getLevel04());
        grabber.add(getGrabber04());
        tech.add(getTech04());

        vpos.add(getLevel05());
        grabber.add(getGrabber05());
        tech.add(getTech05());

        vpos.add(getLevel06());
        grabber.add(getGrabber06());
        tech.add(getTech06());

        vpos.add(getLevel07());
        grabber.add(getGrabber07());
        tech.add(getTech07());

        vpos.add(getLevel08());
        grabber.add(getGrabber08());
        tech.add(getTech08());

        vpos.add(getLevel09());
        grabber.add(getGrabber09());
        tech.add(getTech09());

        vpos.add(getLevel10());
        grabber.add(getGrabber10());
        tech.add(getTech10());


        /*
        Линия
        level.add(new PositionUnit(75, 6400, GameConstant.MINE));
        level.add(new PositionUnit(150, 6400, GameConstant.MINE));
        level.add(new PositionUnit(225, 6400, GameConstant.MINE));
        level.add(new PositionUnit(300, 6400, GameConstant.MINE));
        level.add(new PositionUnit(375, 6400, GameConstant.MINE));
        level.add(new PositionUnit(450, 6400, GameConstant.MINE));
         */

    }

    public Vector<PositionUnit> getLevel(int level) {
        return vpos.elementAt(level);
    }

    public Vector<Integer> getGrabber(int level) {
        return grabber.elementAt(level);
    }

    public Vector<PositionUnit> getTech(int level) {
        return tech.elementAt(level);
    }

    public Vector<PositionUnit> getLevel01() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(120, 7100, GameConstant.STAR));
        level.add(new PositionUnit(380, 6700, GameConstant.TRIANGLE));
        level.add(new PositionUnit(240, 6300, GameConstant.PENTAGON));
        return level;
    }

    public Vector<Integer> getGrabber01() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.PENTAGON);
        return grab;
    }

    public Vector<PositionUnit> getTech01() {
        Vector<PositionUnit> tech = new Vector<>();
        tech.add(new PositionUnit(75, 5800, GameConstant.MINE));
        tech.add(new PositionUnit(150, 5800, GameConstant.MINE));
        tech.add(new PositionUnit(225, 5800, GameConstant.MINE));
        tech.add(new PositionUnit(300, 5800, GameConstant.MINE));
        tech.add(new PositionUnit(375, 5800, GameConstant.MINE));
        tech.add(new PositionUnit(450, 5800, GameConstant.MINE));
        return tech;
    }


    public Vector<PositionUnit> getTech02() {
        Vector<PositionUnit> tech = new Vector<>();
        tech.add(new PositionUnit(100, 5600, GameConstant.MINE));
        tech.add(new PositionUnit(400, 5600, GameConstant.MINE));
        return tech;
    }

    public Vector<PositionUnit> getLevel02() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(240, 7100, GameConstant.TRIANGLE));
        level.add(new PositionUnit(400, 6800, GameConstant.CIRCLE));
        level.add(new PositionUnit(368, 6500, GameConstant.POLYGOON));
        level.add(new PositionUnit(312, 6200, GameConstant.SQUARE));
        level.add(new PositionUnit(240, 5900, GameConstant.SIXSTAR));
        return level;
    }

    public Vector<Integer> getGrabber02() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SIXSTAR);
        return grab;
    }



    public Vector<PositionUnit> getTech03() {
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(100, 5600, GameConstant.MINE));
        level.add(new PositionUnit(400, 5600, GameConstant.MINE));

        level.add(new PositionUnit(240, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 240;
        level.lastElement().teleportToY = 6000;

        return level;
    }

    public Vector<PositionUnit> getLevel03() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(240, 6500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 5800, GameConstant.CIRCLE));
        level.add(new PositionUnit(200, 5500, GameConstant.POLYGOON));
        level.add(new PositionUnit(300, 5200, GameConstant.SQUARE));
        level.add(new PositionUnit(400, 4900, GameConstant.SIXSTAR));
        level.add(new PositionUnit(300, 4600, GameConstant.PENTAGON));
        level.add(new PositionUnit(200, 4300, GameConstant.POLYGOON));
        return level;
    }

    public Vector<Integer> getGrabber03() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.POLYGOON);
        return grab;
    }



    // УРОВЕНЬ 4
    public Vector<PositionUnit> getTech04() {
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(250, 6900, GameConstant.MINE));
        level.add(new PositionUnit(250, 6200, GameConstant.MINE));
        return level;
    }

    public Vector<PositionUnit> getLevel04() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(100, 7000, GameConstant.POLYGOON));
        level.add(new PositionUnit(400, 7000, GameConstant.CIRCLE));
        level.add(new PositionUnit(100, 6800, GameConstant.SIXSTAR));
        level.add(new PositionUnit(400, 6800, GameConstant.PENTAGON));
        level.add(new PositionUnit(100, 6400, GameConstant.SIXSTAR));
        level.add(new PositionUnit(400, 6400, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 6000, GameConstant.SIXSTAR));
        level.add(new PositionUnit(400, 6000, GameConstant.SQUARE));
        return level;
    }

    public Vector<Integer> getGrabber04() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.SQUARE);
        return grab;
    }




    // УРОВЕНЬ 5
    public Vector<PositionUnit> getTech05() {
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(150, 6700, GameConstant.MINE));
        level.add(new PositionUnit(300, 6700, GameConstant.MINE));
        level.add(new PositionUnit(250, 6600, GameConstant.MINE));
        return level;
    }

    public Vector<PositionUnit> getLevel05() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(100, 7000, GameConstant.POLYGOON));
        level.add(new PositionUnit(400, 7000, GameConstant.POLYGOON));
        level.add(new PositionUnit(250, 6800, GameConstant.POLYGOON));
        level.add(new PositionUnit(100, 6500, GameConstant.STAR));
        level.add(new PositionUnit(400, 6500, GameConstant.PENTAGON));
        level.add(new PositionUnit(250, 6200, GameConstant.CIRCLE));

        return level;
    }

    public Vector<Integer> getGrabber05() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.CIRCLE);

        return grab;
    }



    // УРОВЕНЬ 6
    public Vector<PositionUnit> getTech06() {
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(75, 6400, GameConstant.MINE));
        level.add(new PositionUnit(150, 6400, GameConstant.MINE));
        level.add(new PositionUnit(225, 6400, GameConstant.MINE));
        level.add(new PositionUnit(300, 6400, GameConstant.MINE));
        level.add(new PositionUnit(375, 6400, GameConstant.MINE));
        level.add(new PositionUnit(450, 6400, GameConstant.MINE));
        return level;
    }

    public Vector<PositionUnit> getLevel06() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(150, 7000, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 7000, GameConstant.STAR));
        level.add(new PositionUnit(200, 6800, GameConstant.CIRCLE));
        level.add(new PositionUnit(300, 6800, GameConstant.TRIANGLE));

        return level;
    }

    public Vector<Integer> getGrabber06() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.STAR);
        return grab;
    }


    // УРОВЕНЬ 7
    public Vector<PositionUnit> getTech07() {
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(75, 4000, GameConstant.MINE));
        level.add(new PositionUnit(150, 4000, GameConstant.MINE));
        level.add(new PositionUnit(225, 4000, GameConstant.MINE));
        level.add(new PositionUnit(300, 4000, GameConstant.MINE));
        level.add(new PositionUnit(375, 4000, GameConstant.MINE));
        level.add(new PositionUnit(450, 4000, GameConstant.MINE));

        level.add(new PositionUnit(240, 4100,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 240;
        level.lastElement().teleportToY = 2000;
        return level;
    }

    public Vector<PositionUnit> getLevel07() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(255, 6000, GameConstant.STAR));
        level.add(new PositionUnit(255, 5500, GameConstant.STAR));
        level.add(new PositionUnit(255, 5000, GameConstant.CIRCLE));
        level.add(new PositionUnit(255, 4500, GameConstant.CIRCLE));

        level.add(new PositionUnit(255, 3500, GameConstant.PENTAGON));
        level.add(new PositionUnit(255, 3500, GameConstant.SQUARE));
        level.add(new PositionUnit(255, 3000, GameConstant.SQUARE));
        level.add(new PositionUnit(255, 3000, GameConstant.SQUARE));

        return level;
    }

    public Vector<Integer> getGrabber07() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.PENTAGON);
        return grab;
    }


    // УРОВЕНЬ 8
    public Vector<PositionUnit> getTech08() {

        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(252, 6200, GameConstant.MINE));
        level.add(new PositionUnit(375, 6200, GameConstant.MINE));
        level.add(new PositionUnit(252, 5700, GameConstant.MINE));
        level.add(new PositionUnit(125, 5700, GameConstant.MINE));
        level.add(new PositionUnit(252, 5200, GameConstant.MINE));
        level.add(new PositionUnit(375, 5200, GameConstant.MINE));
        level.add(new PositionUnit(252, 4700, GameConstant.MINE));
        level.add(new PositionUnit(125, 4700, GameConstant.MINE));

        level.add(new PositionUnit(125, 6200,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 125;
        level.lastElement().teleportToY = 5800;

        level.add(new PositionUnit(375, 5700,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 375;
        level.lastElement().teleportToY = 5300;

        level.add(new PositionUnit(125, 5200,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 125;
        level.lastElement().teleportToY = 4800;

        level.add(new PositionUnit(375, 4700,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 375;
        level.lastElement().teleportToY = 4300;

        return level;
    }

    public Vector<PositionUnit> getLevel08() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(255, 6000, GameConstant.STAR));
        level.add(new PositionUnit(255, 5500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(255, 5000, GameConstant.POLYGOON));
        level.add(new PositionUnit(255, 4500, GameConstant.POLYGOON));
        return level;
    }

    public Vector<Integer> getGrabber08() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);
        return grab;
    }


    // УРОВЕНЬ 9
    public Vector<PositionUnit> getTech09() {

        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(152, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 152;
        level.lastElement().teleportToY = 5000;

        level.add(new PositionUnit(152, 5100,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 152;
        level.lastElement().teleportToY = 3000;

        level.add(new PositionUnit(152, 3100,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 152;
        level.lastElement().teleportToY = 1500;

        level.add(new PositionUnit(352, 1300,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 352;
        level.lastElement().teleportToY = 2700;

        return level;
    }

    public Vector<PositionUnit> getLevel09() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(125, 2000, GameConstant.STAR));
        level.add(new PositionUnit(255, 2500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(330, 2000, GameConstant.POLYGOON));
        level.add(new PositionUnit(450, 2500, GameConstant.POLYGOON));
        return level;
    }

    public Vector<Integer> getGrabber09() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.TRIANGLE);
        return grab;
    }


    // УРОВЕНЬ 10
    public Vector<PositionUnit> getTech10() {

        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(50, 6900, GameConstant.MINE));
        level.add(new PositionUnit(115, 6900, GameConstant.MINE));
        level.add(new PositionUnit(190, 6900, GameConstant.MINE));
        level.add(new PositionUnit(255, 6900, GameConstant.MINE));
        level.add(new PositionUnit(320, 6900, GameConstant.MINE));
        level.add(new PositionUnit(385, 6900, GameConstant.MINE));
        level.add(new PositionUnit(450, 6900, GameConstant.MINE));

        level.add(new PositionUnit(250, 7200,  GameConstant.WIZARD));

        return level;
    }

    public Vector<PositionUnit> getLevel10() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(255, 7000, GameConstant.STAR));
        level.add(new PositionUnit(100, 6750, GameConstant.CIRCLE));
        level.add(new PositionUnit(220, 6750, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 6750, GameConstant.TRIANGLE));
        return level;
    }

    public Vector<Integer> getGrabber10() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.CIRCLE);
        return grab;
    }





}
