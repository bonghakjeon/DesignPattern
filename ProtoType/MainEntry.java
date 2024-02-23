// 디자인 패턴 "ProtoType" - 프로그램 실행 중에 만든 원본 객체 중에서 하나를 골라 새로운 복사본 객체 생성 및 원본 객체에 상태값을 복사(깊은복사) 해주는 패턴이다. 
// 이 때, 원본이 되는 객체와 복사본이 되는 객체의 상태값은 완전히 독립되어 있어서 서로 영향을 주지 않는다. (서로 다른 메모리 공간 점유)
// 이를 깊은복사가 되었다고 한다.
package DesignPattern.ProtoType;

public class MainEntry {
    public static void main(String[] args) {
        // 1 단계 : Point 클래스 객체 "pt1" 생성해서 x, y 좌표를 0, 0으로 설정 
        Point pt1 = new Point();
        pt1.setX(0).setY(0);
        // System.out.println(pt1.draw());

        // 2 단계 : Point 클래스 객체 "pt2" 생성해서 x, y 좌표를 100, 0으로 설정 
        Point pt2 = new Point();
        pt2.setX(100).setY(0);
        // System.out.println(pt2.draw());

        // 3 단계 : 2개의 Point 클래스 객체 "pt1", "pt2" 이용해서 하나의 선 객체 line1 생성 
        Line line1 = new Line();
        line1.setStartPoint(pt1).setEndPoint(pt2);
        // System.out.println(line1.draw());

        // 4 단계 : copy 메서드 사용해서 3단계 Line 클래스 객체 "line1"과 동일한 좌표를 갖는 선 객체 lineCopy 생성 
        Line lineCopy = (Line)line1.copy();

        // 5 단계 : 사각형 도형 생성하기 (사각형 클래스 객체를 따로 만들지 않아도 4개의 선을 사용하여 사각형을 따로 생성한다.)
        // 4개의 선 중 한개는 line1 객체 사용하고 나머지 3개의 선을 위한 포인트 객체 "pt3", "pt4"를 따로 생성
        Point pt3 = new Point();
        pt3.setX(100).setY(100);

        Point pt4 = new Point();
        pt4.setX(0).setY(100);

        // 6 단계 : 3개의 선 객체 "line2", "line3", "line4" 따로 생성 
        Line line2 = new Line();
        line2.setStartPoint(pt2).setEndPoint(pt3);

        Line line3 = new Line();
        line3.setStartPoint(pt3).setEndPoint(pt4);

        Line line4 = new Line();
        line4.setStartPoint(pt4).setEndPoint(pt1);

        // 7 단계 : 4개의 선 객체 "line1", "line2", "line3", "line4" 이용해서 사각형 도형 원본 객체 "rect" 만들기 
        Group rect = new Group("RECT");
        // 4개의 선 객체를 구성 도형으로 추가
        rect.addShape(line1).addShape(line2).addShape(line3).addShape(line4);

        // 8 단계 :  원본 객체 구성 도형 출력
        // System.out.println(rect.draw());

        // 9 단계 : 사각형 도형 객체 "rect"를 copy 메서드 사용해서 복사본 객체 "cloneRect"로 깊은 복사 진행
        Group cloneRect = (Group)rect.copy();

        // 10 단계 : 복사본 객체 "cloneRect" 좌표 x, y 이동 
        cloneRect.moveOffset(100, 100);

        // 11 단계 : 원본 객체 "rect", 복사본 객체 "cloneRect" 출력 
        // 두 가지 원본 객체 "rect", 복사본 객체 "cloneRect"는 독립적이다.
        System.out.println("Clone - " + cloneRect.draw());
        System.out.println("Origin - " + rect.draw());
    }
}
