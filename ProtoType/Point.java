// TODO : 깊은 복사 VS 얕은 복사 구현 (2024.02.22 jbh)
// 참고 URL - https://cwkcw.tistory.com/389
// 참고 2 URL - https://m.blog.naver.com/adonise007/220578209008
// 참고 2 URL 주의사항
// - 2.1 Shallow Copy 참고 이미지와 2.2 Deep Copy 참고 이미지가 서로 정반대로 되어 있으므로 해당 이미지가 헷갈리면
// 참고 URL - https://cwkcw.tistory.com/389 로 들어가서 이미지를 참고하면 된다.

// 깊은복사 VS 얕은복사 관련 디자인 패턴  
// "GoF의 Design Pattern - 17. Prototype"
// 유튜브 참고 URL - https://youtu.be/UPv8u9ndqAs?si=uoB7arIdDd4EGhuJ
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
