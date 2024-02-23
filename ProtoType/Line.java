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


public class Line implements Shape, ProtoType {
    private Point startPt;  // 선의 시작점
    private Point endPt;    // 선의 끝점

    // 선의 시작점 지정 메서드 
    public Line setStartPoint(Point pt) {
        this.startPt = pt;
        return this;
    }

    // 선의 끝점 지정 메서드 
    public Line setEndPoint(Point pt) {
        this.endPt = pt;
        return this;
    }

    // 선의 시작점 얻는 메서드 
    public Point getStartPoint() {
        return startPt;
    }

    // 선의 끝점 얻는 메서드 
    public Point getEndPoint() {
        return endPt;
    }

    // 새로운 Line 객체 생성 
    // copy 메서드 기능 - 깊은 복사 기능(복사본 객체와 원본 객체에 존재하는 필드(또는 프로퍼티) 값들이 서로 다른 메모리 상에 위치 하도록 복사) 
    // 이는 복사본 객체의 시작점과 끝점에 좌표를 변경해도 원본의 시작점과 끝점의 좌표가 변경되지 않도록 해주는 기능이다.
    // 또 반대로 원본 객체의 시작점이나 끝점에 좌표를 변경해도 복사본의 시작점과 끝점의 좌표가 변경되지 않도록 해주는 기능이다.
    @Override
    public Object copy() {
        Line newLine = new Line();

        newLine.startPt = (Point)startPt.copy(); 
        newLine.endPt   = (Point)endPt.copy();

        return newLine;   // 새로운 Line 객체 반환
    }

    // Shape 인터페이스의 메서드 draw
    @Override
    public String draw() {
        return "LINE(" + startPt.draw() + "," + endPt.draw() + ")";
    }

    // Shape 인터페이스의 메서드 
    // 선을 구성하는 시작점과 끝점의 위치를 dx, dy 만큼 이동 
    @Override
    public void moveOffset(int dx, int dy) {
        startPt.moveOffset(dx, dy);
        endPt.moveOffset(dx, dy);
    }
}
