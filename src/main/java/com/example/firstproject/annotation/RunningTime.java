package com.example.firstproject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// < 특정 메소드 수행시간 측정 -> 메소드 성능 측정 >
@Target({ ElementType.TYPE, ElementType.METHOD}) // 어노테이션 적용 대상
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 유지기간
public @interface RunningTime {
}
