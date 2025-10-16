package fr.dawan.i.genericite;

public class MyGeneric<T>{
    private T data;

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public MyGeneric(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyGeneric [data=" + data + "]";
    }
}
