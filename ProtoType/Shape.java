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

public interface Shape {
    String draw();

    void moveOffset(int dx, int dy);
}


