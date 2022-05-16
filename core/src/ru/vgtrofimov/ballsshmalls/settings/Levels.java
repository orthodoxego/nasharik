package ru.vgtrofimov.ballsshmalls.settings;

import java.util.Vector;

public class Levels {

    Vector<Vector<PositionUnit>> vpos;
    Vector<Vector<Integer>> grabber;

    public Levels() {
        vpos = new Vector<>();
        grabber = new Vector<>();

        vpos.add(getLevel01());
        grabber.add(getGrabber01());
    }

    public Vector<PositionUnit> getLevel(int level) {
        return vpos.elementAt(level);
    }

    public Vector<Integer> getGrabber(int level) {
        return grabber.elementAt(level);
    }

    public Vector<PositionUnit> getLevel01() {
        /* Высота игрового мира 512 * 15 = 7584 (Setup.count_background) */
        Vector<PositionUnit> level = new Vector<>();
        level.add(new PositionUnit(200, 100, GameConstant.STAR));
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

    public Vector<Integer> getGrabber01() {
        Vector<Integer> grab = new Vector<>();
        grab.add(GameConstant.STAR);
        grab.add(GameConstant.PENTAGON);
        grab.add(GameConstant.SQUARE);
        grab.add(GameConstant.POLYGOON);
        grab.add(GameConstant.STAR);
        return grab;
    }
}
