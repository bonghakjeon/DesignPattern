package DesignPattern.ProtoType;

import java.util.ArrayList;
import java.util.Iterator;

public class Group implements Shape, ProtoType {
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private String name;

    public Group(String name) {
        this.name = name;
    }

    // 그룹을 구성하는 도형 객체를 추가하는 메서드 
    Group addShape(Shape shape) {
        shapeList.add(shape);
        return this;
    }

    // 동일한 이름을 갖는 새로운 그룹 객체 생성 
    @Override
    public Object copy() {
        Group newGroup = new Group(name);
        
        // 원본 객체가 가진 모든 도형 객체에 대해서 copy 메서드로 복사를 해서 
        // 새로운 그룹(newGroup)에 추가함.
        Iterator<Shape> iter = shapeList.iterator();
        while(iter.hasNext()) {
            ProtoType shape = (ProtoType)iter.next();
            newGroup.shapeList.add((Shape)shape.copy());
        }

        return newGroup; // 새로운 그룹 객체 반환
    }

    // Shape 인터페이스에 구현된 draw 메서드 
    @Override
    public String draw() {
        StringBuffer result = new StringBuffer(name);
        result.append("(");

        // 그룹의 이름과 함께 그룹을 구성하는 모든 도형들에 대해서 
        // draw 메서드 호출해서 결과 값을 생성해서 반환한 코드 
        Iterator<Shape> iter = shapeList.iterator();
        while(iter.hasNext()) {
            Shape shape = iter.next();
            result.append(shape.draw());
            if (iter.hasNext()) {
                result.append(" ");
            }
        }

        result.append(")");
        return result.toString();
    }

    // Shape 인터페이스에 구현된 moveOffset 메서드 
    @Override
    public void moveOffset(int dx, int dy) {
        // 그룹을 구성하는 모든 도형들에 대해서 
        // moveOffset 메서드 호출
        Iterator<Shape> iter = shapeList.iterator();
        while(iter.hasNext()) {
            Shape shape = iter.next();
            shape.moveOffset(dx, dy);
        }
    }
}
