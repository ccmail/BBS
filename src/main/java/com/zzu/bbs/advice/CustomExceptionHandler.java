package com.zzu.bbs.advice;
/*
 * User:程成
 * Date:2021/5/16
 * Time:17:03
 * Description:
 */

import com.zzu.bbs.exception.CustomErrorCode;
import com.zzu.bbs.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e,
                        Model model,
                        HttpServletRequest request,
                        HttpServletResponse response) {
        String contentType = request.getContentType();

  /*      if ("application/json".equals(contentType)) {

        }
*/

        //页面错误跳转
        if(e instanceof CustomException){
            model.addAttribute("message",e.getMessage());

        }else {
            model.addAttribute("message", CustomErrorCode.SYS_ERROR.getMessage());
        }
        return new ModelAndView("error");
    }

}
