package com.github.xuqplus.jvmtest.day03;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BClassLoader extends ClassLoader {

    String path = "D:\\work\\jvm-test\\src\\test\\java\\com\\github\\xuqplus\\jvmtest\\day03\\bbb\\%s.class";

    @Override
    protected synchronized Class<?> findClass(String name) throws ClassNotFoundException {
        log.info("1 try load class {}, ", name);
        if (!name.startsWith("com.github.xuqplus.jvmtest.day03")) {
            return super.loadClass(name);
        }
        if (loadedClasses.containsKey(name)) {
            return loadedClasses.get(name);
        }
        try {
            String[] names = name.split("\\.");
            File file = new File(String.format(path, names[names.length - 1]));
            if (file.exists()) {
                byte[] bytes = FileUtil.readAsByteArray(file);
                Class<?> c = defineClass(name, bytes, 0, bytes.length);
                loadedClasses.put(name, c);
                log.info("0 loaded class {}, ", name);
                return c;
            }
        } catch (Exception e) {
            // not care
        }
        return super.loadClass(name, true);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        log.info("2 try load class {}, ", name);
        if (!name.startsWith("com.github.xuqplus.jvmtest.day03")) {
            return super.loadClass(name, resolve);
        }
        return findClass(name);
    }

    private Map<String, Class<?>> loadedClasses = new HashMap<>();
}
