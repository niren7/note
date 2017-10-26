package passbyvalue;

public class Test {
    public static void main(String[] args) {
        /*int num = 20;
        Test test = new Test();
        test.changeBasicType(num);
        System.out.println(num);    //20*/
        Test test = new Test();

        AAA a = new AAA("aaa");
        AAA b = a;
        test.change(a);
        System.out.println(a.getAa());
        System.out.println(b.getAa());
        test.change2(a);
        System.out.println(a.getAa());
        System.out.println(b.getAa());
        AAA c = new AAA("ddd");
        a=c;
        System.out.println(a.getAa());
        System.out.println(b.getAa());
    }
    void change(AAA str) {
        str.setAa("bbbb");
    }

    void change2(AAA str) {
        str = new AAA("ccc");
        System.out.println("-----------------");
        System.out.println(str.getAa());
        System.out.println("-----------------");
    }
}
