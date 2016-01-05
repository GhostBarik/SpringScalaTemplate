package com.template.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * profiling aspect
 */
@Aspect
public class ProfilingAspect {

    private static final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);

    @Around("execution(public * *(..)) && @annotation(Profiling)")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {

        // start stopwatch
        final long start = System.currentTimeMillis();

        try {
            // calling method
            return pjp.proceed();

        } finally {

            // stop stopwatch
            final long end = System.currentTimeMillis();

            logger.info("time elapsed (millisec): " + (end-start));
        }
    }
}