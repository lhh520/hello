package testproject;

//深度拷贝
class CloneClass implements Cloneable {
    public int a;
    public Class1 t;

    public CloneClass(int a, Class1 t) {
        this.a = a;
        this.t = t;
    }



}
    //Class1 也必须实现Cloneable接口
    class Class1 implements Cloneable {
        public Object clone() {
            Class1 o = null;
            try {
                o = (Class1) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return o;
        }
    }

