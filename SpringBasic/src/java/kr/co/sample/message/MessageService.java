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
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

// @Component
public class MessageService {
  private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

  // @Autowired
  // MessageSource messageSource;

  // // @Override
  // public void run(ApplicationContext args) throws Exception {
  //   Environment environment = args.getEnvironment();
  //   logger.debug("messageService getProperty : " + environment.getProperty("greeting"));
  // }

  // @Bean
  // public MessageSource messageSource() { // 빈 이름은 무조건 messageSource 여야 함 !!

  //   // 메시지 파일로 프로퍼티 형식 사용을 위한 MessageSource 구현체 클래스
  //   // ResourceBundleMessageSource messageSource = new
  //   // ResourceBundleMessageSource();
  //   ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

  //   messageSource.setBasename("classpath:/config/messages/messages");
  //   messageSource.setDefaultEncoding("UTF-8");
  //   messageSource.setCacheSeconds(3);

  //   return messageSource;

  // }

  // @Autowired
  private static MessageSourceAccessor msAcc = null;

  public void setMessageSourceAccessor(MessageSourceAccessor msAcc) {
    MessageService.msAcc = msAcc;
  }


  // res.getMessage(String code, Object[] args, Locale locale);

  public static String getMessage(String code) {
    logger.info("# Default Locale : {}" , Locale.getDefault());
    Locale.setDefault(Locale.KOREA);
    return msAcc.getMessage(code, Locale.getDefault());
  }

  public static String getMessage(String code, Object[] objs) {
    Locale.setDefault(Locale.KOREA);
    return msAcc.getMessage(code, objs, Locale.getDefault());
  }

}
