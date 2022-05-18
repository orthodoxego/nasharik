package ru.vgtrofimov.ballsshmalls.settings;

import java.util.Vector;

import ru.vgtrofimov.ballsshmalls.services.PositionUnit;

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
        level.add(new PositionUnit(240, 7100, GameConstant.STAR));
        level.add(new PositionUnit(128, 6100, GameConstant.TRIANGLE));
        level.add(new PositionUnit(384, 5100, GameConstant.PENTAGON));
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
        tech.add(new PositionUnit(50, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(100, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(200, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(240, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(300, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(400, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(500, 4500, GameConstant.MINE));
        return tech;
    }


    public Vector<PositionUnit> getTech02() {
        Vector<PositionUnit> tech = new Vector<>();
        tech.add(new PositionUnit(100, 7100, GameConstant.MINE));
        tech.add(new PositionUnit(412, 7100, GameConstant.MINE));
        tech.add(new PositionUnit(196, 6200, GameConstant.MINE));
        tech.add(new PositionUnit(450, 4000, GameConstant.MINE));
        tech.add(new PositionUnit(160, 4000, GameConstant.MINE));
        tech.add(new PositionUnit(50, 2000, GameConstant.MINE));
        tech.add(new PositionUnit(200, 2000, GameConstant.MINE));
        tech.add(new PositionUnit(350, 2000, GameConstant.MINE));
        tech.add(new PositionUnit(490, 2000, GameConstant.MINE));
        return tech;
    }

    public Vector<PositionUnit> getLevel02() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(240, 7100, GameConstant.TRIANGLE));
        level.add(new PositionUnit(400, 6800, GameConstant.CIRCLE));
        level.add(new PositionUnit(368, 6200, GameConstant.POLYGOON));
        level.add(new PositionUnit(312, 4000, GameConstant.SQUARE));
        level.add(new PositionUnit(240, 2000, GameConstant.SIXSTAR));
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
        Vector<PositionUnit> tech = new Vector<>();
        tech.add(new PositionUnit(200, 240, GameConstant.MINE));
        tech.add(new PositionUnit(400, 7000, GameConstant.MINE));
        tech.add(new PositionUnit(200, 6400, GameConstant.MINE));
        tech.add(new PositionUnit(400, 5400, GameConstant.MINE));
        tech.add(new PositionUnit(200, 3400, GameConstant.MINE));
        tech.add(new PositionUnit(400, 2400, GameConstant.MINE));
        tech.add(new PositionUnit(200, 1500, GameConstant.MINE));
        return tech;
    }

    public Vector<PositionUnit> getLevel03() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(200, 150, GameConstant.STAR));
        level.add(new PositionUnit(400, 7100, GameConstant.STAR));
        level.add(new PositionUnit(200, 6500, GameConstant.CIRCLE));
        level.add(new PositionUnit(400, 5500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(200, 3500, GameConstant.SQUARE));
        level.add(new PositionUnit(400, 2400, GameConstant.SIXSTAR));
        level.add(new PositionUnit(200, 2000, GameConstant.PENTAGON));
        level.add(new PositionUnit(400, 1500, GameConstant.POLYGOON));
        level.add(new PositionUnit(200, 1000, GameConstant.SIXSTAR));
        level.add(new PositionUnit(400, 500, GameConstant.TRIANGLE));
        return level;
    }

    public Vector<Integer> getGrabber03() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.STAR);
        return grab;
    }

    public Vector<PositionUnit> getTech04() {
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(220, 7000, GameConstant.MINE));
        level.add(new PositionUnit(300, 6000, GameConstant.MINE));
        level.add(new PositionUnit(400, 4500, GameConstant.MINE));
        level.add(new PositionUnit(240, 3800, GameConstant.MINE));
        level.add(new PositionUnit(240, 3600, GameConstant.MINE));
        level.add(new PositionUnit(240, 3200, GameConstant.MINE));
        level.add(new PositionUnit(240, 2600, GameConstant.MINE));
        level.add(new PositionUnit(240, 2200, GameConstant.MINE));
        level.add(new PositionUnit(400, 1200, GameConstant.MINE));
        level.add(new PositionUnit(400, 600,  GameConstant.MINE));

        level.add(new PositionUnit(240, 6500,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 100;
        level.lastElement().teleportToY = 1200;

        return level;
    }

    public Vector<PositionUnit> getLevel04() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(200, 7100, GameConstant.PENTAGON));
        level.add(new PositionUnit(400, 6900, GameConstant.PENTAGON));
        level.add(new PositionUnit(200, 6900, GameConstant.CIRCLE));
        level.add(new PositionUnit(400, 5800, GameConstant.TRIANGLE));
        level.add(new PositionUnit(200, 5500, GameConstant.SQUARE));
        level.add(new PositionUnit(400, 5200, GameConstant.SIXSTAR));
        level.add(new PositionUnit(100, 4500, GameConstant.PENTAGON));
        level.add(new PositionUnit(240, 4500, GameConstant.POLYGOON));
        level.add(new PositionUnit(412, 4500, GameConstant.SIXSTAR));
        level.add(new PositionUnit(200, 3500, GameConstant.TRIANGLE));
        level.add(new PositionUnit(300, 3200, GameConstant.PENTAGON));
        level.add(new PositionUnit(400, 2600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(300, 1000, GameConstant.STAR));
        level.add(new PositionUnit(150, 900, GameConstant.TRIANGLE));
        level.add(new PositionUnit(180, 800, GameConstant.SIXSTAR));
        level.add(new PositionUnit(260, 700, GameConstant.POLYGOON));
        level.add(new PositionUnit(320, 250, GameConstant.TRIANGLE));
        return level;
    }

    public Vector<Integer> getGrabber04() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.PENTAGON);
        return grab;
    }

    public Vector<PositionUnit> getTech05() {
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(130, 6800, GameConstant.MINE));
        level.add(new PositionUnit(400, 6800, GameConstant.MINE));
        level.add(new PositionUnit(130, 6000, GameConstant.MINE));
        level.add(new PositionUnit(400, 6000, GameConstant.MINE));
        level.add(new PositionUnit(130, 5200, GameConstant.MINE));
        level.add(new PositionUnit(400, 5200, GameConstant.MINE));
        level.add(new PositionUnit(130, 4800, GameConstant.MINE));
        level.add(new PositionUnit(400, 4800, GameConstant.MINE));

        level.add(new PositionUnit(260, 6800,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 260;
        level.lastElement().teleportToY = 6400;

        level.add(new PositionUnit(260, 6100,  GameConstant.TELEPORT));
        level.lastElement().teleportToX = 260;
        level.lastElement().teleportToY = 4800;

        return level;
    }

    public Vector<PositionUnit> getLevel05() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(240, 7000, GameConstant.STAR));
        level.add(new PositionUnit(240, 6600, GameConstant.TRIANGLE));
        level.add(new PositionUnit(240, 6200, GameConstant.SIXSTAR));
        level.add(new PositionUnit(140, 6100, GameConstant.CIRCLE));
        level.add(new PositionUnit(380, 6100, GameConstant.CIRCLE));
        level.add(new PositionUnit(240, 5800, GameConstant.SQUARE));
        level.add(new PositionUnit(240, 5400, GameConstant.CIRCLE));
        level.add(new PositionUnit(240, 5000, GameConstant.POLYGOON));
        level.add(new PositionUnit(240, 4600, GameConstant.PENTAGON));
        return level;
    }

    public Vector<Integer> getGrabber05() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.TRIANGLE);
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.CIRCLE);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.POLYGOON);
        return grab;
    }
}
