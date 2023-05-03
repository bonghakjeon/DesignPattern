package Template;

public abstract class DisplayArticleTemplate {
    protected Article article;

    public DisplayArticleTemplate(Article article) {
        this.article = article;
    }

    // final 사용해서 DisplayArticleTemplate 클래스를 상속받는 파생 클래스에서 display 메서드 변경 못하도록 강제함. 
    public final void display() {
        title();
        content();
        footer();
    }

    protected abstract void title();
    protected abstract void content();
    protected abstract void footer();
}
