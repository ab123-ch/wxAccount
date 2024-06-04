package com.tencent.wxcloudrun.config;

import org.apache.ibatis.transaction.TransactionFactory;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;

/**
 * 全局事务
 * @author fh
 * @date 2022-08-11
 * @since 3.1.0
 */
@Aspect
@Configuration
@ConditionalOnClass({TransactionManager.class, TransactionFactory.class})
public class TransactionAdviceConfig {
    private static final String AOP_POINTCUT_EXPRESSION =
            "execution(* com.example.accountbook.demos.web.controller.*.*(..)) || " +
                    "execution(* com.example.accountbook.demos.web.service.*.*(..))";
    @Lazy
    private TransactionManager transactionManager;

    /**
     * 事务拦截器
     * @return
     */
    @Bean
    public TransactionInterceptor txAdvice() {

        RuleBasedTransactionAttribute txAttrRequired = new RuleBasedTransactionAttribute();
        //支持一个已经存在的事务。如果没有事务，则开始一个新的事务；
        txAttrRequired.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttrRequired.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        //设置只读
        RuleBasedTransactionAttribute txAttrRequiredReadonly = new RuleBasedTransactionAttribute();
        txAttrRequiredReadonly.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        txAttrRequiredReadonly.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        //可以提交事务或回滚事务的方法
        source.addTransactionalMethod("insert*", txAttrRequired);
        source.addTransactionalMethod("save*", txAttrRequired);
        source.addTransactionalMethod("add*", txAttrRequired);
        source.addTransactionalMethod("create*", txAttrRequired);
        source.addTransactionalMethod("delete*", txAttrRequired);
        source.addTransactionalMethod("remove*", txAttrRequired);
        source.addTransactionalMethod("update*", txAttrRequired);
        source.addTransactionalMethod("modify*", txAttrRequired);
        source.addTransactionalMethod("exec*", txAttrRequired);
        source.addTransactionalMethod("set*", txAttrRequired);
        source.addTransactionalMethod("reset*", txAttrRequired);
        source.addTransactionalMethod("batch*", txAttrRequired);
        source.addTransactionalMethod("lock*", txAttrRequired);
        source.addTransactionalMethod("register*", txAttrRequired);
        source.addTransactionalMethod("login*", txAttrRequired);
        //其他方法无事务，只读
        source.addTransactionalMethod("*", txAttrRequiredReadonly);

        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }

}
