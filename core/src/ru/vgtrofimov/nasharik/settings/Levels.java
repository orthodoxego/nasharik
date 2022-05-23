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

        vpos.add(getLevel02());
        grabber.add(getGrabber02());

        vpos.add(getLevel03());
        grabber.add(getGrabber03());

        vpos.add(getLevel04());
        grabber.add(getGrabber04());

        vpos.add(getLevel05());
        grabber.add(getGrabber05());

        vpos.add(getLevel06());
        grabber.add(getGrabber06());

        vpos.add(getLevel07());
        grabber.add(getGrabber07());

        vpos.add(getLevel08());
        grabber.add(getGrabber08());

        vpos.add(getLevel09());
        grabber.add(getGrabber09());

        vpos.add(getLevel10());
        grabber.add(getGrabber10());

        vpos.add(getLevel11());
        grabber.add(getGrabber11());

        vpos.add(getLevel12());
        grabber.add(getGrabber12());

        vpos.add(getLevel13());
        grabber.add(getGrabber13());

        vpos.add(getLevel14());
        grabber.add(getGrabber14());

        vpos.add(getLevel15());
        grabber.add(getGrabber15());

        vpos.add(getLevel16());
        grabber.add(getGrabber16());

        vpos.add(getLevel17());
        grabber.add(getGrabber17());

        vpos.add(getLevel18());
        grabber.add(getGrabber18());

        vpos.add(getLevel19());
        grabber.add(getGrabber19());

        vpos.add(getLevel20());
        grabber.add(getGrabber20());

        vpos.add(getLevel20());
        grabber.add(getGrabber20());

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

    public int getCountAllLevel() {
        return vpos.size();
    }

    public Vector<PositionUnit> getLevel(int level) {
        if (level >= vpos.size()) level = 0;
        return vpos.elementAt(level);
    }

    public Vector<Integer> getGrabber(int level) {
        if (level >= vpos.size()) level = 0;
        return grabber.elementAt(level);
    }

    public Vector<PositionUnit> getLevel01() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(120, 7100, GameConstant.STAR));
        level.add(new PositionUnit(380, 6700, GameConstant.TRIANGLE));
        level.add(new PositionUnit(240, 6300, GameConstant.PENTAGON));

        level.add(new PositionUnit(75, 5800, GameConstant.MINE));
        level.add(new PositionUnit(150, 5800, GameConstant.MINE));
        level.add(new PositionUnit(225, 5800, GameConstant.MINE));
        level.add(new PositionUnit(300, 5800, GameConstant.MINE));
        level.add(new PositionUnit(375, 5800, GameConstant.MINE));
        level.add(new PositionUnit(450, 5800, GameConstant.MINE));

        return level;
    }

    public Vector<Integer> getGrabber01() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.PENTAGON);
        return grab;
    }

    public Vector<PositionUnit> getLevel02() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(240, 7100, GameConstant.TRIANGLE));
        level.add(new PositionUnit(400, 6900, GameConstant.CIRCLE));
        level.add(new PositionUnit(360, 6800, GameConstant.POLYGOON));
        level.add(new PositionUnit(320, 6700, GameConstant.SQUARE));
        level.add(new PositionUnit(300, 6600, GameConstant.SIXSTAR));
        level.add(new PositionUnit(280, 6500, GameConstant.PENTAGON));
        level.add(new PositionUnit(300, 6400, GameConstant.STAR));
        level.add(new PositionUnit(320, 6300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(340, 6200, GameConstant.STAR));
        level.add(new PositionUnit(320, 6100, GameConstant.POLYGOON));
        level.add(new PositionUnit(280, 6000, GameConstant.TRIANGLE));
        level.add(new PositionUnit(240, 5900, GameConstant.CIRCLE));

        level.add(new PositionUnit(100, 5600, GameConstant.MINE));
        level.add(new PositionUnit(400, 5600, GameConstant.MINE));
        level.add(new PositionUnit(150, 6800, GameConstant.MINE));
        level.add(new PositionUnit(150, 6700, GameConstant.MINE));
        level.add(new PositionUnit(150, 6600, GameConstant.MINE));
        level.add(new PositionUnit(150, 6500, GameConstant.MINE));
        level.add(new PositionUnit(150, 6400, GameConstant.MINE));
        level.add(new PositionUnit(150, 6300, GameConstant.MINE));
        level.add(new PositionUnit(150, 6200, GameConstant.MINE));
        return level;
    }

    public Vector<Integer> getGrabber02() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        return grab;
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

        level.add(new PositionUnit(100, 5600, GameConstant.MINE));
        level.add(new PositionUnit(400, 5600, GameConstant.MINE));

        level.add(new PositionUnit(240, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 240;
        level.lastElement().teleportToY = 6000;

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

        level.add(new PositionUnit(250, 6900, GameConstant.MINE));
        level.add(new PositionUnit(250, 6200, GameConstant.MINE));
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
    public Vector<PositionUnit> getLevel05() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(100, 7000, GameConstant.POLYGOON));
        level.add(new PositionUnit(400, 7000, GameConstant.POLYGOON));
        level.add(new PositionUnit(250, 6800, GameConstant.POLYGOON));
        level.add(new PositionUnit(100, 6500, GameConstant.STAR));
        level.add(new PositionUnit(400, 6500, GameConstant.PENTAGON));
        level.add(new PositionUnit(250, 6200, GameConstant.CIRCLE));

        level.add(new PositionUnit(150, 5800, GameConstant.PENTAGON));
        level.add(new PositionUnit(350, 5800, GameConstant.TRIANGLE));

        level.add(new PositionUnit(100, 5600, GameConstant.CIRCLE));
        level.add(new PositionUnit(400, 5600, GameConstant.POLYGOON));

        level.add(new PositionUnit(50, 5500, GameConstant.CIRCLE));
        level.add(new PositionUnit(450, 5500, GameConstant.POLYGOON));

        level.add(new PositionUnit(200, 6700, GameConstant.MINE));
        level.add(new PositionUnit(252, 6930, GameConstant.MINE));
        level.add(new PositionUnit(300, 6700, GameConstant.MINE));
        level.add(new PositionUnit(250, 6600, GameConstant.MINE));

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

        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.POLYGOON);

        return grab;
    }



    // УРОВЕНЬ 6
    public Vector<PositionUnit> getLevel06() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(150, 7000, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 7000, GameConstant.STAR));
        level.add(new PositionUnit(200, 6800, GameConstant.CIRCLE));
        level.add(new PositionUnit(300, 6800, GameConstant.TRIANGLE));

        level.add(new PositionUnit(50, 6600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 6600, GameConstant.POLYGOON));
        level.add(new PositionUnit(250, 6600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(400, 6600, GameConstant.POLYGOON));
        level.add(new PositionUnit(450, 6600, GameConstant.TRIANGLE));

        level.add(new PositionUnit(75, 6400, GameConstant.MINE));
        level.add(new PositionUnit(150, 6400, GameConstant.MINE));
        level.add(new PositionUnit(225, 6400, GameConstant.MINE));
        level.add(new PositionUnit(300, 6400, GameConstant.MINE));
        level.add(new PositionUnit(375, 6400, GameConstant.MINE));
        level.add(new PositionUnit(450, 6400, GameConstant.MINE));
        return level;
    }

    public Vector<Integer> getGrabber06() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        return grab;
    }


    // УРОВЕНЬ 7
    public Vector<PositionUnit> getLevel07() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(255, 6000, GameConstant.STAR));
        level.add(new PositionUnit(255, 5900, GameConstant.STAR));
        level.add(new PositionUnit(255, 5800, GameConstant.STAR));
        level.add(new PositionUnit(255, 5700, GameConstant.STAR));
        level.add(new PositionUnit(255, 5600, GameConstant.STAR));
        level.add(new PositionUnit(255, 5500, GameConstant.STAR));
        level.add(new PositionUnit(255, 5000, GameConstant.CIRCLE));
        level.add(new PositionUnit(255, 4900, GameConstant.CIRCLE));
        level.add(new PositionUnit(255, 4800, GameConstant.CIRCLE));
        level.add(new PositionUnit(255, 4500, GameConstant.CIRCLE));

        level.add(new PositionUnit(225, 3500, GameConstant.PENTAGON));
        level.add(new PositionUnit(285, 3500, GameConstant.SQUARE));
        level.add(new PositionUnit(225, 3000, GameConstant.SQUARE));
        level.add(new PositionUnit(285, 3000, GameConstant.SQUARE));

        level.add(new PositionUnit(100, 2700, GameConstant.SQUARE));
        level.add(new PositionUnit(200, 2700, GameConstant.SQUARE));
        level.add(new PositionUnit(300, 2700, GameConstant.SQUARE));
        level.add(new PositionUnit(400, 2700, GameConstant.SQUARE));

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

    public Vector<Integer> getGrabber07() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        return grab;
    }


    // УРОВЕНЬ 8
    public Vector<PositionUnit> getLevel08() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(155, 6000, GameConstant.STAR));
        level.add(new PositionUnit(355, 6000, GameConstant.STAR));
        level.add(new PositionUnit(155, 5900, GameConstant.STAR));
        level.add(new PositionUnit(355, 5900, GameConstant.STAR));


        level.add(new PositionUnit(155, 5500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(355, 5500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(155, 5400, GameConstant.TRIANGLE));
        level.add(new PositionUnit(355, 5400, GameConstant.TRIANGLE));


        level.add(new PositionUnit(155, 5000, GameConstant.POLYGOON));
        level.add(new PositionUnit(355, 5000, GameConstant.POLYGOON));
        level.add(new PositionUnit(155, 4900, GameConstant.POLYGOON));
        level.add(new PositionUnit(355, 4900, GameConstant.POLYGOON));


        level.add(new PositionUnit(155, 4500, GameConstant.PENTAGON));
        level.add(new PositionUnit(355, 4500, GameConstant.POLYGOON));
        level.add(new PositionUnit(155, 4400, GameConstant.PENTAGON));
        level.add(new PositionUnit(355, 4400, GameConstant.POLYGOON));


        level.add(new PositionUnit(252, 6200, GameConstant.MINE));
        level.add(new PositionUnit(375, 6200, GameConstant.MINE));
        level.add(new PositionUnit(252, 5700, GameConstant.MINE));
        level.add(new PositionUnit(125, 5700, GameConstant.MINE));
        level.add(new PositionUnit(252, 5200, GameConstant.MINE));
        level.add(new PositionUnit(375, 5200, GameConstant.MINE));
        level.add(new PositionUnit(252, 4700, GameConstant.MINE));
        level.add(new PositionUnit(125, 4700, GameConstant.MINE));

        level.add(new PositionUnit(125, 6200,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 75;
        level.lastElement().teleportToY = 5800;

        level.add(new PositionUnit(375, 5700,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 425;
        level.lastElement().teleportToY = 5300;

        level.add(new PositionUnit(125, 5200,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 75;
        level.lastElement().teleportToY = 4800;

        level.add(new PositionUnit(375, 4700,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 425;
        level.lastElement().teleportToY = 4300;

        return level;
    }

    public Vector<Integer> getGrabber08() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);

        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.POLYGOON);

        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.POLYGOON);
        return grab;
    }


    // УРОВЕНЬ 9
    public Vector<PositionUnit> getLevel09() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(152, 2000, GameConstant.STAR));
        level.add(new PositionUnit(152, 2100, GameConstant.STAR));
        level.add(new PositionUnit(152, 2200, GameConstant.STAR));
        level.add(new PositionUnit(152, 2300, GameConstant.STAR));
        level.add(new PositionUnit(152, 2400, GameConstant.STAR));
        level.add(new PositionUnit(152, 2500, GameConstant.STAR));

        level.add(new PositionUnit(255, 2500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(330, 2600, GameConstant.POLYGOON));

        level.add(new PositionUnit(255, 2700, GameConstant.CIRCLE));
        level.add(new PositionUnit(330, 2800, GameConstant.CIRCLE));

        level.add(new PositionUnit(152, 2700, GameConstant.PENTAGON));
        level.add(new PositionUnit(152, 2800, GameConstant.PENTAGON));

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

    public Vector<Integer> getGrabber09() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);


        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);



        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.PENTAGON);
        return grab;
    }


    // УРОВЕНЬ 10
    public Vector<PositionUnit> getLevel10() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(255, 7000, GameConstant.STAR));
        level.add(new PositionUnit(100, 6750, GameConstant.CIRCLE));
        level.add(new PositionUnit(220, 6750, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 6750, GameConstant.TRIANGLE));

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

    public Vector<Integer> getGrabber10() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.CIRCLE);
        return grab;
    }

    // УРОВЕНЬ 11
    public Vector<PositionUnit> getLevel11() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(250, 6900, GameConstant.SQUARE));
        level.add(new PositionUnit(150, 6800, GameConstant.SQUARE));
        level.add(new PositionUnit(350, 6800, GameConstant.SQUARE));


        level.add(new PositionUnit(100, 6500, GameConstant.STAR));
        level.add(new PositionUnit(400, 6500, GameConstant.STAR));


        level.add(new PositionUnit(300, 6300, GameConstant.CIRCLE));
        level.add(new PositionUnit(200, 6200, GameConstant.CIRCLE));
        level.add(new PositionUnit(100, 6100, GameConstant.CIRCLE));

        level.add(new PositionUnit(450, 6000, GameConstant.TRIANGLE));
        level.add(new PositionUnit(250, 6000, GameConstant.TRIANGLE));
        level.add(new PositionUnit(50, 6000, GameConstant.TRIANGLE));

        level.add(new PositionUnit(100, 5200, GameConstant.PENTAGON));

        level.add(new PositionUnit(50, 4800, GameConstant.CIRCLE));
        level.add(new PositionUnit(150, 4500, GameConstant.POLYGOON));
        level.add(new PositionUnit(455, 4000, GameConstant.TRIANGLE));
        level.add(new PositionUnit(300, 3500, GameConstant.PENTAGON));

        level.add(new PositionUnit(100, 6600, GameConstant.MINE));
        level.add(new PositionUnit(400, 6600, GameConstant.MINE));

        level.add(new PositionUnit(220, 5600, GameConstant.MINE));
        level.add(new PositionUnit(280, 5600, GameConstant.MINE));
        level.add(new PositionUnit(100, 5400, GameConstant.MINE));
        level.add(new PositionUnit(400, 5400, GameConstant.MINE));
        level.add(new PositionUnit(200, 5800, GameConstant.MINE));
        level.add(new PositionUnit(300, 5800, GameConstant.MINE));

        level.add(new PositionUnit(100, 4600, GameConstant.MINE));
        level.add(new PositionUnit(400, 4600, GameConstant.MINE));

        level.add(new PositionUnit(255, 3700,  GameConstant.WIZARD));
        level.add(new PositionUnit(255, 5900,  GameConstant.WIZARD));

        return level;
    }

    public Vector<Integer> getGrabber11() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SQUARE);
        return grab;
    }

    // УРОВЕНЬ 12
    public Vector<PositionUnit> getLevel12() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(250, 6810, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 6810, GameConstant.TRIANGLE));
        level.add(new PositionUnit(420, 6810, GameConstant.TRIANGLE));

        level.add(new PositionUnit(200, 6850, GameConstant.MINE));
        level.add(new PositionUnit(300, 6850, GameConstant.MINE));
        level.add(new PositionUnit(250, 6750, GameConstant.MINE));

        level.add(new PositionUnit(250, 6510, GameConstant.SQUARE));
        level.add(new PositionUnit(150, 6510, GameConstant.SQUARE));
        level.add(new PositionUnit(370, 6510, GameConstant.SQUARE));

        level.add(new PositionUnit(200, 6550, GameConstant.MINE));
        level.add(new PositionUnit(300, 6550, GameConstant.MINE));
        level.add(new PositionUnit(250, 6450, GameConstant.MINE));

        level.add(new PositionUnit(350, 6000, GameConstant.SQUARE));
        level.add(new PositionUnit(250, 6000, GameConstant.TRIANGLE));
        level.add(new PositionUnit(300, 6000, GameConstant.MINE));
        level.add(new PositionUnit(300, 5950, GameConstant.PENTAGON));


        level.add(new PositionUnit(150, 5900, GameConstant.CIRCLE));
        level.add(new PositionUnit(200, 5900, GameConstant.MINE));
        level.add(new PositionUnit(250, 5900, GameConstant.POLYGOON));

        level.add(new PositionUnit(255, 6200,  GameConstant.WIZARD));

        return level;
    }

    public Vector<Integer> getGrabber12() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.PENTAGON);
        return grab;
    }

    // УРОВЕНЬ 13
    public Vector<PositionUnit> getLevel13() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(150, 7000, GameConstant.TRIANGLE));
        level.add(new PositionUnit(370, 7000, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 6900, GameConstant.CIRCLE));
        level.add(new PositionUnit(420, 6900, GameConstant.CIRCLE));
        level.add(new PositionUnit(250, 6900, GameConstant.TRIANGLE));
        level.add(new PositionUnit(250, 7100, GameConstant.TRIANGLE));

        level.add(new PositionUnit(50, 6400, GameConstant.MINE));
        level.add(new PositionUnit(140, 6400, GameConstant.MINE));
        level.add(new PositionUnit(250, 6400, GameConstant.MINE));
        level.add(new PositionUnit(360, 6400, GameConstant.MINE));
        level.add(new PositionUnit(470, 6400, GameConstant.MINE));

        level.add(new PositionUnit(50, 6200, GameConstant.PENTAGON));
        level.add(new PositionUnit(140, 6200, GameConstant.PENTAGON));
        level.add(new PositionUnit(250, 6200, GameConstant.POLYGOON));
        level.add(new PositionUnit(360, 6200, GameConstant.PENTAGON));
        level.add(new PositionUnit(470, 6200, GameConstant.PENTAGON));

        level.add(new PositionUnit(50, 4800, GameConstant.MINE));
        level.add(new PositionUnit(140, 4800, GameConstant.MINE));
        level.add(new PositionUnit(250, 4800, GameConstant.MINE));
        level.add(new PositionUnit(360, 4800, GameConstant.MINE));
        level.add(new PositionUnit(470, 4800, GameConstant.MINE));

        level.add(new PositionUnit(50, 4600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(140,4600, GameConstant.CIRCLE));
        level.add(new PositionUnit(250,4600, GameConstant.SQUARE));
        level.add(new PositionUnit(360,4600, GameConstant.CIRCLE));
        level.add(new PositionUnit(470,4600, GameConstant.TRIANGLE));

        level.add(new PositionUnit(250, 5300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(250,5400, GameConstant.SIXSTAR));
        level.add(new PositionUnit(250, 5500,  GameConstant.WIZARD));
        level.add(new PositionUnit(250,5600, GameConstant.SIXSTAR));
        level.add(new PositionUnit(250, 5700,  GameConstant.WIZARD));
        level.add(new PositionUnit(250,5800, GameConstant.SIXSTAR));
        level.add(new PositionUnit(250,5900, GameConstant.SIXSTAR));


        level.add(new PositionUnit(250, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 6000;

        level.add(new PositionUnit(250, 6300,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 4000;

        level.add(new PositionUnit(250, 4200,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 5000;

        level.add(new PositionUnit(250, 3300,  GameConstant.WIZARD));

        return level;
    }

    public Vector<Integer> getGrabber13() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);

        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.PENTAGON);

        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.TRIANGLE);

        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);




        return grab;
    }

    // УРОВЕНЬ 14
    public Vector<PositionUnit> getLevel14() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(150, 6900,  GameConstant.MINE));
        level.add(new PositionUnit(150, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 6000;

        level.add(new PositionUnit(250, 6200,  GameConstant.WIZARD));

        level.add(new PositionUnit(250, 6600,  GameConstant.SQUARE));

        level.add(new PositionUnit(250, 6700,  GameConstant.MINE));
        level.add(new PositionUnit(250, 6800,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 350;
        level.lastElement().teleportToY = 5800;
        level.add(new PositionUnit(350, 6000,  GameConstant.WIZARD));

        level.add(new PositionUnit(350, 6400,  GameConstant.TRIANGLE));

        level.add(new PositionUnit(350, 6500,  GameConstant.MINE));
        level.add(new PositionUnit(350, 6600,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 450;
        level.lastElement().teleportToY = 5600;
        level.add(new PositionUnit(450, 5800,  GameConstant.WIZARD));

        level.add(new PositionUnit(450, 6200,  GameConstant.STAR));

        level.add(new PositionUnit(150, 6200,  GameConstant.STAR));
        level.add(new PositionUnit(150, 6000,  GameConstant.PENTAGON));
        level.add(new PositionUnit(150, 5800,  GameConstant.POLYGOON));


        level.add(new PositionUnit(75, 7000,  GameConstant.STAR));
        level.add(new PositionUnit(250, 7000,  GameConstant.STAR));
        level.add(new PositionUnit(425, 7000,  GameConstant.STAR));

        level.add(new PositionUnit(310, 7000,  GameConstant.SIXSTAR));
        level.add(new PositionUnit(310, 6800,  GameConstant.SIXSTAR));
        level.add(new PositionUnit(310, 6700,  GameConstant.SIXSTAR));




        return level;
    }

    public Vector<Integer> getGrabber14() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.STAR);
        return grab;
    }



    // УРОВЕНЬ 15
    public Vector<PositionUnit> getLevel15() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(100, 7000, GameConstant.STAR));
        level.add(new PositionUnit(400, 6800, GameConstant.CIRCLE));
        level.add(new PositionUnit(100, 6600, GameConstant.POLYGOON));
        level.add(new PositionUnit(450, 6400, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 6200, GameConstant.PENTAGON));
        level.add(new PositionUnit(400, 6000, GameConstant.PENTAGON));
        level.add(new PositionUnit(100, 5800, GameConstant.CIRCLE));
        level.add(new PositionUnit(75, 3800, GameConstant.SQUARE));
        level.add(new PositionUnit(150, 3700, GameConstant.POLYGOON));
        level.add(new PositionUnit(225, 3600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(300, 3500, GameConstant.PENTAGON));

        level.add(new PositionUnit(50, 4000, GameConstant.MINE));
        level.add(new PositionUnit(115, 4000, GameConstant.MINE));
        level.add(new PositionUnit(190, 4000, GameConstant.MINE));
        level.add(new PositionUnit(255, 4000, GameConstant.MINE));
        level.add(new PositionUnit(320, 4000, GameConstant.MINE));
        level.add(new PositionUnit(385, 4000, GameConstant.MINE));
        level.add(new PositionUnit(450, 4000, GameConstant.MINE));

        level.add(new PositionUnit(255, 6600, GameConstant.MINE));
        level.add(new PositionUnit(255, 5600, GameConstant.MINE));
        level.add(new PositionUnit(255, 6900, GameConstant.MINE));

        level.add(new PositionUnit(255, 6400,  GameConstant.WIZARD));
        level.add(new PositionUnit(255, 5400,  GameConstant.WIZARD));


        return level;
    }

    public Vector<Integer> getGrabber15() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.STAR);
        return grab;
    }


    // УРОВЕНЬ 16
    public Vector<PositionUnit> getLevel16() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(100, 7000, GameConstant.STAR));
        level.add(new PositionUnit(400, 7000, GameConstant.STAR));
        level.add(new PositionUnit(100, 6900, GameConstant.STAR));
        level.add(new PositionUnit(400, 6900, GameConstant.STAR));
        level.add(new PositionUnit(100, 6800, GameConstant.STAR));
        level.add(new PositionUnit(400, 6800, GameConstant.STAR));

        level.add(new PositionUnit(250, 6900, GameConstant.WIZARD));

        level.add(new PositionUnit(100, 6500, GameConstant.SQUARE));
        level.add(new PositionUnit(400, 6500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 6400, GameConstant.PENTAGON));
        level.add(new PositionUnit(400, 6400, GameConstant.PENTAGON));
        level.add(new PositionUnit(100, 6300, GameConstant.TRIANGLE));
        level.add(new PositionUnit(400, 6300, GameConstant.SQUARE));

        level.add(new PositionUnit(180, 6400, GameConstant.MINE));
        level.add(new PositionUnit(250, 6400, GameConstant.MINE));
        level.add(new PositionUnit(320, 6400, GameConstant.MINE));

        level.add(new PositionUnit(100, 6000, GameConstant.POLYGOON));
        level.add(new PositionUnit(400, 6000, GameConstant.PENTAGON));
        level.add(new PositionUnit(100, 5900, GameConstant.TRIANGLE));
        level.add(new PositionUnit(400, 5900, GameConstant.TRIANGLE));
        level.add(new PositionUnit(100, 5800, GameConstant.PENTAGON));
        level.add(new PositionUnit(400, 5800, GameConstant.POLYGOON));

        return level;
    }

    public Vector<Integer> getGrabber16() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        return grab;
    }

    // УРОВЕНЬ 17
    public Vector<PositionUnit> getLevel17() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(250, 7000, GameConstant.STAR));

        level.add(new PositionUnit(50,  6000, GameConstant.MINE));
        level.add(new PositionUnit(150, 6000, GameConstant.MINE));
        level.add(new PositionUnit(250, 6000, GameConstant.MINE));
        level.add(new PositionUnit(350, 6000, GameConstant.MINE));
        level.add(new PositionUnit(450, 6000, GameConstant.MINE));

        level.add(new PositionUnit(250, 6900, GameConstant.STAR));
        level.add(new PositionUnit(150, 6900, GameConstant.SQUARE));
        level.add(new PositionUnit(350, 6900, GameConstant.SQUARE));

        level.add(new PositionUnit(250, 6800, GameConstant.STAR));
        level.add(new PositionUnit(50, 6800, GameConstant.PENTAGON));
        level.add(new PositionUnit(150, 6800, GameConstant.PENTAGON));
        level.add(new PositionUnit(350, 6800, GameConstant.PENTAGON));
        level.add(new PositionUnit(450, 6800, GameConstant.PENTAGON));


        level.add(new PositionUnit(250, 6700, GameConstant.STAR));
        level.add(new PositionUnit(150, 6700, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 6700, GameConstant.POLYGOON));


        level.add(new PositionUnit(250, 6600, GameConstant.STAR));
        level.add(new PositionUnit(150, 6600, GameConstant.MINE));
        level.add(new PositionUnit(350, 6600, GameConstant.MINE));

        level.add(new PositionUnit(250, 6500, GameConstant.STAR));
        level.add(new PositionUnit(150, 6500, GameConstant.MINE));
        level.add(new PositionUnit(350, 6500, GameConstant.MINE));

        level.add(new PositionUnit(250, 6400, GameConstant.STAR));
        level.add(new PositionUnit(150, 6400, GameConstant.MINE));
        level.add(new PositionUnit(350, 6400, GameConstant.MINE));

        level.add(new PositionUnit(250, 6300, GameConstant.WIZARD));

        level.add(new PositionUnit(250, 6200, GameConstant.STAR));
        level.add(new PositionUnit(150, 6200, GameConstant.MINE));
        level.add(new PositionUnit(350, 6200, GameConstant.MINE));


        return level;
    }

    public Vector<Integer> getGrabber17() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);

        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.SQUARE);

        grab.add(GameConstant.STAR);
        return grab;
    }

    // УРОВЕНЬ 18
    public Vector<PositionUnit> getLevel18() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(150, 6900, GameConstant.MINE));
        level.add(new PositionUnit(362, 6900, GameConstant.MINE));
        level.add(new PositionUnit(250, 6850, GameConstant.STAR));
        level.add(new PositionUnit(440, 6850, GameConstant.TRIANGLE));
        level.add(new PositionUnit(60, 6850, GameConstant.SQUARE));

        level.add(new PositionUnit(60, 6950, GameConstant.TELEPORT));
        level.lastElement().teleportToX = 440;
        level.lastElement().teleportToY = 6550;
        level.add(new PositionUnit(440, 6650, GameConstant.SQUARE));

        level.add(new PositionUnit(440, 6750, GameConstant.TELEPORT));
        level.lastElement().teleportToX = 60;
        level.lastElement().teleportToY = 6750;

        level.add(new PositionUnit(150, 6800, GameConstant.MINE));
        level.add(new PositionUnit(362, 6800, GameConstant.MINE));
        level.add(new PositionUnit(250, 6650, GameConstant.STAR));

        level.add(new PositionUnit(150, 6700, GameConstant.MINE));
        level.add(new PositionUnit(362, 6700, GameConstant.MINE));
        level.add(new PositionUnit(250, 6550, GameConstant.STAR));

        level.add(new PositionUnit(250, 6750, GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 5200;

        level.add(new PositionUnit(50,  5800, GameConstant.MINE));
        level.add(new PositionUnit(150, 5800, GameConstant.MINE));
        level.add(new PositionUnit(250, 5800, GameConstant.MINE));
        level.add(new PositionUnit(350, 5800, GameConstant.MINE));
        level.add(new PositionUnit(450, 5800, GameConstant.MINE));

        level.add(new PositionUnit(150, 5550, GameConstant.SQUARE));
        level.add(new PositionUnit(400, 5550, GameConstant.POLYGOON));
        level.add(new PositionUnit(200, 5400, GameConstant.PENTAGON));
        level.add(new PositionUnit(450, 5400, GameConstant.PENTAGON));

        level.add(new PositionUnit(250, 5700, GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 4000;

        level.add(new PositionUnit(50,  4100, GameConstant.MINE));
        level.add(new PositionUnit(150, 4100, GameConstant.MINE));
        level.add(new PositionUnit(250, 4100, GameConstant.MINE));
        level.add(new PositionUnit(350, 4100, GameConstant.MINE));
        level.add(new PositionUnit(450, 4100, GameConstant.MINE));

        level.add(new PositionUnit(50, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(100, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(150, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(200, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(250, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(300, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(350, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(400, 3100, GameConstant.SIXSTAR));
        level.add(new PositionUnit(450, 3100, GameConstant.SIXSTAR));

        level.add(new PositionUnit(75,  3040, GameConstant.MINE));
        level.add(new PositionUnit(150, 3040, GameConstant.MINE));
        level.add(new PositionUnit(225, 3040, GameConstant.MINE));
        level.add(new PositionUnit(300, 3040, GameConstant.MINE));
        level.add(new PositionUnit(375, 3040, GameConstant.MINE));
        level.add(new PositionUnit(450, 3040, GameConstant.MINE));

        level.add(new PositionUnit(250, 3300, GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 1000;

        level.add(new PositionUnit(450, 1200, GameConstant.MINE));
        level.add(new PositionUnit(350, 1300, GameConstant.MINE));
        level.add(new PositionUnit(150, 1500, GameConstant.MINE));
        level.add(new PositionUnit(50, 1600, GameConstant.MINE));

         level.add(new PositionUnit(50, 1200, GameConstant.SIXSTAR));
        level.add(new PositionUnit(100, 1250, GameConstant.STAR));
        level.add(new PositionUnit(150, 1300, GameConstant.SQUARE));
        level.add(new PositionUnit(200, 1350, GameConstant.STAR));
        level.add(new PositionUnit(250, 1400, GameConstant.PENTAGON));
        level.add(new PositionUnit(300, 1450, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 1500, GameConstant.STAR));
        level.add(new PositionUnit(400, 1550, GameConstant.STAR));
        level.add(new PositionUnit(450, 1600, GameConstant.TRIANGLE));

        return level;
    }

    public Vector<Integer> getGrabber18() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);

        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.PENTAGON);

        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);

        grab.add(GameConstant.STAR);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.POLYGOON);

        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.TRIANGLE);

        return grab;
    }

    // УРОВЕНЬ 19
    public Vector<PositionUnit> getLevel19() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(50,  5000, GameConstant.MINE));
        level.add(new PositionUnit(150, 5000, GameConstant.MINE));
        level.add(new PositionUnit(250, 5000, GameConstant.MINE));
        level.add(new PositionUnit(350, 5000, GameConstant.MINE));
        level.add(new PositionUnit(450, 5000, GameConstant.MINE));

        level.add(new PositionUnit(100, 7000, GameConstant.STAR));
        level.add(new PositionUnit(200, 7000, GameConstant.STAR));
        level.add(new PositionUnit(300, 7000, GameConstant.STAR));
        level.add(new PositionUnit(400, 7000, GameConstant.STAR));

        level.add(new PositionUnit(50, 6800, GameConstant.MINE));
        level.add(new PositionUnit(450, 6800, GameConstant.WIZARD));
        level.add(new PositionUnit(150, 6700, GameConstant.MINE));
        level.add(new PositionUnit(350, 6700, GameConstant.WIZARD));
        level.add(new PositionUnit(250, 6600, GameConstant.MINE));

        level.add(new PositionUnit(450, 6600, GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 5800;

        level.add(new PositionUnit(150, 5900, GameConstant.MINE));
        level.add(new PositionUnit(350, 5900, GameConstant.MINE));
        level.add(new PositionUnit(250, 6000, GameConstant.MINE));

        level.add(new PositionUnit(150, 6500, GameConstant.WIZARD));
        level.add(new PositionUnit(350, 6500, GameConstant.MINE));
        level.add(new PositionUnit(50, 6400, GameConstant.WIZARD));
        level.add(new PositionUnit(450, 6400, GameConstant.MINE));

        level.add(new PositionUnit(150, 6600, GameConstant.SQUARE));
        level.add(new PositionUnit(350, 6600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(250, 6500, GameConstant.SQUARE));
        level.add(new PositionUnit(250, 6700, GameConstant.TRIANGLE));

        level.add(new PositionUnit(150, 5700, GameConstant.SQUARE));
        level.add(new PositionUnit(350, 5600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(250, 5500, GameConstant.SQUARE));
        level.add(new PositionUnit(250, 5400, GameConstant.TRIANGLE));

        level.add(new PositionUnit(50, 6300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(150, 6300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(250, 6300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(350, 6300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(450, 6300, GameConstant.SIXSTAR));

        level.add(new PositionUnit(50, 6200, GameConstant.STAR));
        level.add(new PositionUnit(150, 6200, GameConstant.STAR));
        level.add(new PositionUnit(250, 6200, GameConstant.STAR));
        level.add(new PositionUnit(350, 6200, GameConstant.STAR));
        level.add(new PositionUnit(450, 6200, GameConstant.STAR));

        return level;
    }

    public Vector<Integer> getGrabber19() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);

        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);

        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);

        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.STAR);

        return grab;
    }


    // УРОВЕНЬ 20
    public Vector<PositionUnit> getLevel20() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();

        level.add(new PositionUnit(100, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 150;
        level.lastElement().teleportToY = 6700;

        level.add(new PositionUnit(130, 6800, GameConstant.TRIANGLE));
        level.add(new PositionUnit(260, 6800, GameConstant.TRIANGLE));
        level.add(new PositionUnit(390, 6800, GameConstant.TRIANGLE));


        level.add(new PositionUnit(350, 6700,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 150;
        level.lastElement().teleportToY = 4200;

        level.add(new PositionUnit(150, 4300, GameConstant.CIRCLE));
        level.add(new PositionUnit(350, 4000, GameConstant.CIRCLE));
        level.add(new PositionUnit(250, 3800, GameConstant.CIRCLE));

        level.add(new PositionUnit(350, 3700,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 100;
        level.lastElement().teleportToY = 7100;

        level.add(new PositionUnit(200, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 6200;

        level.add(new PositionUnit(250, 6400, GameConstant.POLYGOON));
        level.add(new PositionUnit(150, 6500, GameConstant.PENTAGON));
        level.add(new PositionUnit(350, 6500, GameConstant.CIRCLE));

        level.add(new PositionUnit(250, 6500,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 3000;

        level.add(new PositionUnit(50, 3300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(450, 3300, GameConstant.SIXSTAR));
        level.add(new PositionUnit(100, 3200, GameConstant.STAR));
        level.add(new PositionUnit(400, 3200, GameConstant.STAR));
        level.add(new PositionUnit(150, 3100, GameConstant.STAR));
        level.add(new PositionUnit(350, 3100, GameConstant.STAR));
        level.add(new PositionUnit(200, 2800, GameConstant.SIXSTAR));
        level.add(new PositionUnit(300, 2800, GameConstant.SIXSTAR));

        level.add(new PositionUnit(250, 2850,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 200;
        level.lastElement().teleportToY = 7100;

        level.add(new PositionUnit(50,  2700, GameConstant.MINE));
        level.add(new PositionUnit(150, 2700, GameConstant.MINE));
        level.add(new PositionUnit(250, 2700, GameConstant.MINE));
        level.add(new PositionUnit(350, 2700, GameConstant.MINE));
        level.add(new PositionUnit(450, 2700, GameConstant.MINE));


        level.add(new PositionUnit(50, 6600, GameConstant.MINE));
        level.add(new PositionUnit(150, 6600, GameConstant.MINE));
        level.add(new PositionUnit(250, 6600, GameConstant.MINE));
        level.add(new PositionUnit(350, 6600, GameConstant.MINE));
        level.add(new PositionUnit(450, 6600, GameConstant.MINE));


        level.add(new PositionUnit(50, 5900, GameConstant.MINE));
        level.add(new PositionUnit(150, 5900, GameConstant.MINE));
        level.add(new PositionUnit(250, 5900, GameConstant.MINE));
        level.add(new PositionUnit(350, 5900, GameConstant.MINE));
        level.add(new PositionUnit(450, 5900, GameConstant.MINE));


        level.add(new PositionUnit(50, 4500, GameConstant.MINE));
        level.add(new PositionUnit(150, 4500, GameConstant.MINE));
        level.add(new PositionUnit(250, 4500, GameConstant.MINE));
        level.add(new PositionUnit(350, 4500, GameConstant.MINE));
        level.add(new PositionUnit(450, 4500, GameConstant.MINE));


        level.add(new PositionUnit(50, 3500, GameConstant.MINE));
        level.add(new PositionUnit(150, 3500, GameConstant.MINE));
        level.add(new PositionUnit(250, 3500, GameConstant.MINE));
        level.add(new PositionUnit(350, 3500, GameConstant.MINE));
        level.add(new PositionUnit(450, 3500, GameConstant.MINE));

        level.add(new PositionUnit(50, 6900, GameConstant.MINE));
        level.add(new PositionUnit(150, 6900, GameConstant.MINE));
        level.add(new PositionUnit(250, 6900, GameConstant.MINE));
        level.add(new PositionUnit(350, 6900, GameConstant.MINE));
        level.add(new PositionUnit(450, 6900, GameConstant.MINE));


        level.add(new PositionUnit(300, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 4600;

        level.add(new PositionUnit(250, 4800, GameConstant.SQUARE));
        level.add(new PositionUnit(250, 4900, GameConstant.SIXSTAR));
        level.add(new PositionUnit(250, 5000, GameConstant.PENTAGON));
        level.add(new PositionUnit(250, 5100, GameConstant.POLYGOON));
        level.add(new PositionUnit(250, 5200, GameConstant.TRIANGLE));
        level.add(new PositionUnit(250, 5300, GameConstant.STAR));
        level.add(new PositionUnit(250, 5400, GameConstant.SQUARE));
        level.add(new PositionUnit(250, 5500, GameConstant.STAR));

        level.add(new PositionUnit(250, 5600,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 300;
        level.lastElement().teleportToY = 7100;

        level.add(new PositionUnit(400, 7000,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 250;
        level.lastElement().teleportToY = 2500;

        level.add(new PositionUnit(250, 1500,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 400;
        level.lastElement().teleportToY = 7100;

        level.add(new PositionUnit(100, 2400, GameConstant.WIZARD));
        level.add(new PositionUnit(200, 2400, GameConstant.WIZARD));
        level.add(new PositionUnit(300, 2400, GameConstant.WIZARD));
        level.add(new PositionUnit(400, 2400, GameConstant.WIZARD));

        level.add(new PositionUnit(50, 2000, GameConstant.STAR));
        level.add(new PositionUnit(450, 2000, GameConstant.SQUARE));
        level.add(new PositionUnit(150, 1950, GameConstant.TRIANGLE));
        level.add(new PositionUnit(350, 1950, GameConstant.SQUARE));
        level.add(new PositionUnit(250, 1900, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 1850, GameConstant.STAR));
        level.add(new PositionUnit(150, 1850, GameConstant.PENTAGON));
        level.add(new PositionUnit(450, 1800, GameConstant.STAR));
        level.add(new PositionUnit(50, 1800, GameConstant.PENTAGON));

        level.add(new PositionUnit(50, 1800, GameConstant.STAR));
        level.add(new PositionUnit(150, 1750, GameConstant.TRIANGLE));
        level.add(new PositionUnit(250, 1700, GameConstant.POLYGOON));
        level.add(new PositionUnit(350, 1650, GameConstant.PENTAGON));
        level.add(new PositionUnit(450, 1600, GameConstant.PENTAGON));


        return level;
    }

    public Vector<Integer> getGrabber20() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.POLYGOON);

        // 4200
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);

        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.TRIANGLE);

        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SIXSTAR);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.STAR);

        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.PENTAGON);


        return grab;
    }
}
