package com.google.code._7_DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Robot sitting on the top left corner, can move in 2 directions - right and down
// possible paths for robot to go form (00) to (xy) 
class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Point)) {
            return false;
        }
        Point p = (Point) obj;

        return (p.x == this.x) && (p.y == this.y);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class _2_GL_PossiblePaths {
    public static void main(String[] args) {
        int x = 2;
        int y = 2;
        System.out.println(possiblePathsRec(x, y));

        List<Point> path = new ArrayList<>();
        Map<Point, Boolean> cache = new HashMap<>();
        System.out.println(getPaths(x, y, path, cache));
//        System.out.println(path.size() + ": " + cache.size());
    }

    // Rec
    public static int possiblePathsRec(int x, int y) {
        if (x < 0 || y < 0)
            return 0;
        if (x == 0 && y == 0)
            return 1;
        return possiblePathsRec(x - 1, y) + possiblePathsRec(x, y - 1);
    }

    // Dp - just checks if path exists
    public static boolean getPaths(int x, int y, List<Point> path, Map<Point, Boolean> cache) {
        if (x < 0 || y < 0 || !isFree(x, y)) {
            return false;
        }

        if ((x == 0) && (y == 0)) {
            return true;
        }

        Point p = new Point(x, y);

        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        boolean pathExists = getPaths(x - 1, y, path, cache) || getPaths(x, y - 1, path, cache);

        cache.put(p, pathExists);
        return pathExists;
    }

    private static boolean isFree(int x, int y) {
        return true;
    }

    // Object test
    private static void checkObjEquals() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(2, 2);
        if (p1.equals(p2)) {
            System.out.println("First Equal");
        }

        System.out.println("p1 hash code: " + p1.hashCode() + "\np2 hash code: " + p2.hashCode());
        Map<Point, Boolean> map = new HashMap<>();
        map.put(p1, true);
        System.out.println("p1: " + map.get(p1) + "\np2: " + map.get(p2));
        if (map.get(p2) != null && map.get(p2)) {
            System.out.println("Second Equal");
        }
    }
}
