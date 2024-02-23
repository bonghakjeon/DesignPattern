package DesignPattern.ProtoType;

public class Point implements Shape, ProtoType {
    private int x;  // x 좌표
    private int y;  // y 좌표

    // x좌표에 값 할당 메서드 "setX"
    public Point setX(int x) {
        this.x = x;
        return this;
    }

    // y좌표에 값 할당 메서드 "setY"
    public Point setY(int y) {
        this.y = y;
        return this;
    }

    // x좌표 값 얻을 수 있는 메서드 "getX"
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // 깊은 복사 - 새로운 Point 클래스 객체 생성 메서드 "copy"
    @Override
    public Object copy() {
        Point newPoint = new Point();   // 새로운 Point 클래스 객체 newPoint 생성

        newPoint.x = this.x;
        newPoint.y = this.y;

        return newPoint;   // 새로운 Point 클래스 객체 newPoint 반환
    }

    // Shape 인터페이스의 draw 메서드 
    @Override
    public String draw() {
        return "(" + x + " " + y + ")";
    }

    // Shape 인터페이스의 moveOffset 메서드 
    // x, y에 좌표값에 이동 값인 dx, dy를 더해준다.
    @Override
    public void moveOffset(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
