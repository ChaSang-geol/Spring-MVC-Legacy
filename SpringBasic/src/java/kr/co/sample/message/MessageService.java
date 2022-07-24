package kr.co.sample.message;

import kr.co.sample.common.SessionInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

public class MessageService {
    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);
//    //@Override
//    public void run(ApplicationContext args) throws Exception {
//        Environment environment = context.getEnvironment();
//        logger.debug("messageService getProperty : " +environment.getProperty("greeting"));
//    }
//    @Bean
//    public MessageSource messageSource() { // 빈 이름은 무조건 messageSource 여야 함 !!
//
//        // 메시지 파일로 프로퍼티 형식 사용을 위한 MessageSource 구현체 클래스
//        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
//        ms.setDefaultEncoding("UTF-8");
//        ms.import java.util.Locale;
//
//}
//

    private static MessageSourceAccessor msAcc = null;

    public void setMessageSourceAccessor(MessageSourceAccessor msAcc) {
        MessageService.msAcc = msAcc;
    }

    public static String getMessage(String code) {
        return msAcc.getMessage(code, Locale.getDefault());
    }

    public static String getMessage(String code, Object[] objs) {
        return msAcc.getMessage(code, objs, Locale.getDefault());
    }

}
