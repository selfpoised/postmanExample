package classloader.test.bean;

public class ClassIdentity {

    public static void main(String[] args) {
        new ClassIdentity().testClassIdentity();
    }

    public void testClassIdentity() {
        String classDataRootPath = "E:\\";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "xxx.Person";
        try {
            Class<?> class1 = fscl1.loadClass(className);  // 加载Sample类
            Object obj1 = class1.newInstance();  // 创建对象
            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();

            System.out.println(class1.equals(class2));
            class1.getMethod("setPerson", Object.class).invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}