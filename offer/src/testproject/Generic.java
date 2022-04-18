package testproject;

//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}
class tt
{
    public static void main(String[] args) {
        Generic<Integer> genericInteger = new Generic<Integer>(123456);
        int a=genericInteger.getKey();
        System.out.println(a);
    }
}


