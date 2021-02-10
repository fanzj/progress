package com.jary.progress.common.jvm;

import java.io.InputStream;

/**
 * @author fanzhengjie
 * @create 2019/10/5 下午10:10
 * @description
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            /**
             * Loads the class with the specified <a href="#name">binary name</a>. This method searches for classes in the same
             * manner as the {@link #loadClass(String, boolean)} method.  It is invoked by the Java virtual machine to resolve
             * class references.  Invoking this method is equivalent to invoking {@link #loadClass(String, boolean)
             * <tt>loadClass(name, false)</tt>}.
             *
             * @param name The <a href="#name">binary name</a> of the class
             * @return The resulting <tt>Class</tt> object
             * @throws ClassNotFoundException If the class was not found
             */
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (Exception e){
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj = classLoader.loadClass("com.daily.demo.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }

}
