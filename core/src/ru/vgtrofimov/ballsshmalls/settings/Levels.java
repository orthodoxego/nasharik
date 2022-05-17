package ru.vgtrofimov.ballsshmalls.settings;

import java.util.Vector;

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
        level.add(new PositionUnit(256, 7100, GameConstant.STAR));
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
        tech.add(new PositionUnit(256, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(300, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(400, 4500, GameConstant.MINE));
        tech.add(new PositionUnit(500, 4500, GameConstant.MINE));
        return tech;
    }

    public Vector<PositionUnit> getLevel02() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(100, 7100, GameConstant.TRIANGLE));
        level.add(new PositionUnit(400, 6800, GameConstant.CIRCLE));
        level.add(new PositionUnit(256, 6200, GameConstant.POLYGOON));
        level.add(new PositionUnit(312, 4000, GameConstant.SQUARE));
        level.add(new PositionUnit(256, 2000, GameConstant.SIXSTAR));
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

    public Vector<PositionUnit> getTech02() {
        Vector<PositionUnit> tech = new Vector<>();
        tech.add(new PositionUnit(50, 7100, GameConstant.MINE));
        tech.add(new PositionUnit(250, 7100, GameConstant.MINE));
        tech.add(new PositionUnit(350, 7100, GameConstant.MINE));
        tech.add(new PositionUnit(450, 6500, GameConstant.MINE));
        tech.add(new PositionUnit(160, 6900, GameConstant.MINE));
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
        level.add(new PositionUnit(400, 2500, GameConstant.SIXSTAR));
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
}
