package com.webprague.StudentSign.action;

import com.opensymphony.xwork2.ActionSupport;
import com.webprague.StudentSign.EmaiUtil.SendEmail;
import com.webprague.StudentSign.service.UserService;
import com.webprague.StudentSign.service.UserTeacherService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ZhangPeng on 2017/5/17.
 */
public class ForgetPassword extends ActionSupport {

    HttpServletRequest request = ServletActionContext.getRequest();
    @Override
    public String execute() throws Exception {
        if (ServletActionContext.getRequest().getMethod().equals("POST")) {

            String username = request.getParameter("username");
            String mail = request.getParameter("mail");
            HttpSession session = request.getSession();
            //		session.setAttribute("username", username);
            //		session.setAttribute("password", password);
            boolean teacher_forgetPassword_result = UserTeacherService.forgetPassword(username, mail);
            if(teacher_forgetPassword_result){

                String teacher_num = username;
                session.setAttribute("username", teacher_num);
                //发送邮件
                String user_passwd = UserTeacherService.getUserPasswd(username);
                String teacher_name =UserTeacherService.getNameByUsername(teacher_num);

                boolean result = SendEmail.sendFotgotPasswordEmail(mail,teacher_name, user_passwd);
                session.setAttribute("teacher", true);
                //response.sendRedirect("ForgetPassword.java");
                return "ForgetPassword";


            }else {
                boolean student_forgetPassword_result = UserService.forgetPassword(username, mail);
                if(student_forgetPassword_result){
                    String student_num = username;
                    session.setAttribute("username", username);
                    session.setAttribute("teacher", false);
                    String user_passwd = UserService.getUserPasswd(student_num);
                    String student_name =UserService.getNameByUsername(student_num);
                    SendEmail.sendFotgotPasswordEmail(mail,student_name, user_passwd);
                    //response.sendRedirect("ForgetPassword.java");
                    request.setAttribute("msg", "激活邮件发送成功！");
                    request.setAttribute("location", "login.java");
                    //request.getRequestDispatcher("jump.jsp").forward(request, response);

                    return "jump";

                }else {
                    request.setAttribute("msg", "<script>alert('用户不存在！');</script>");
                    //转发 不改变url
                    //request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);

                    return "ForgetPassword";

                }
            }


        }else{
            //request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
            return "ForgetPassword";
        }
    }
}
