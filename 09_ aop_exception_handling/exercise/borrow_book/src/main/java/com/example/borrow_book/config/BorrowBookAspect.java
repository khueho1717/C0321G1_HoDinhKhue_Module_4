package com.example.borrow_book.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class BorrowBookAspect {
    int count = 0;
    int countBorrow = 0;

    @Pointcut("within(com.example.borrow_book.controler.BorrowBookController*)")
    public void actionPointcut() {

    }

    @Pointcut("execution(public String com.example.borrow_book.controler.BorrowBookController.borrowBook(..)))")
    public void borrowPointcut() {
    }

    @Pointcut("execution(public String com.example.borrow_book.controler.BorrowBookController.rollBook(..))")
    public void rollPointcut() {
    }

    @Around("actionPointcut()")
    public Object actionBorrow(ProceedingJoinPoint proceedingJoinPoint) {

        System.err.println("co nguoi tri cap vao he thong " + LocalDate.now() + " so lan try cap vao he thong: " + count++);
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        count++;
        System.err.println("sau khi goi method " + LocalDate.now() +
                " return value " + value + " so lan try cap vao he thong: " + count++);
        return value;
    }

    @Before("borrowPointcut()")
    public void actionBorrow(JoinPoint joinPoint) {
        System.err.println(LocalDate.now() + "so nguoi vao muon và tra: " + countBorrow++);
    }

    @Before("rollPointcut()")
    public void actionRoll(JoinPoint joinPoint) {
        System.err.println(LocalDate.now() + "so nguoi vao muon và tra: " + countBorrow++);
    }

}
