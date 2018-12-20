package week10;

import javafx.scene.shape.Line;

@FunctionalInterface
public interface DisplayLineInfo {
    enum DisplayType{
        DisplayTrueLevel,
        DisplayDistanceInfo,
        DisplayMidPointInfo,
        DisplayVertHorzInfo
    }

    String getInfo(Line line);

    public static DisplayLineInfo createDisplayLineInfo(DisplayType type) {
        switch(type)
        {
            case DisplayTrueLevel:
                return (Line line) -> {
                    if(line.getStartX() == line.getEndX()
                            || line.getStartY() == line.getEndY())
                        return "This line is truly level";
                    else
                        return "This line is not level";
                };
            case DisplayDistanceInfo:
                return (Line line) -> {
                    double powDistance = Math.pow(line.getStartX() - line.getEndX(),2) + Math.pow(line.getStartY() - line.getEndY(),2);
                    double distance = Math.sqrt(powDistance);
                    return "The distance between these two points is " + distance + " !";
                };
            case DisplayMidPointInfo:
                return (Line line) -> {
                    double halfwayPointX = (line.getStartX() + line.getEndX()) / 2;
                    double halfwayPointY = (line.getStartY() + line.getEndY()) / 2;
                    return "The halfway point is " + halfwayPointX + " X , " + halfwayPointY + " Y";
                };
            case DisplayVertHorzInfo:
                return (Line line) -> {
                    double verticalNumber = Math.abs(line.getStartX() - line.getEndX());
                    double horizontalNumber = Math.abs(line.getStartY() - line.getEndY());

                    if (horizontalNumber < 10)
                        return "The line is horizontal";
                    else if (verticalNumber < 10) {
                        return "The line is vertical";
                    } else {
                        return "The line is sideways";
                    }
                };
            default:
                return null;
        }
    }
}
