package com.statik.core.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;


@Aspect
@Component
public class EncryptAspect {

    private static final Logger log = LoggerFactory.getLogger(EncryptAspect.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before("@annotation(encrypt)")
    public Object decrypt(JoinPoint pjp, Encrypt encrypt) throws Throwable {
        String values[] = encrypt.values();
        MethodSignature signature = (MethodSignature) pjp.getSignature();

        Class<?> clazz = signature.getParameterTypes()[0];
        Object param = pjp.getArgs()[0];

        for (String value : values) {
            Field field = clazz.getDeclaredField(value);
            field.setAccessible(true);
            Object fieldValue = field.get(param);
            if (fieldValue != null)
                field.set(param, encrypt(fieldValue.toString()));
        }

        return param;
    }

    private String encrypt(String plainText) throws Exception {
        return bCryptPasswordEncoder.encode(plainText);
    }
}
