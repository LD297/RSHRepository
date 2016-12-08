package presentation.tools;

import java.util.Iterator;

/**
 * Created by john on 2016/12/8.
 */
public class UserInputFormCheckTool {
    private static UserInputFormCheckTool userInputFormCheckTool = null;
    private UserInputFormCheckTool(){}

    public static UserInputFormCheckTool getInstance(){
        if(userInputFormCheckTool==null){
            userInputFormCheckTool = new UserInputFormCheckTool();
        }
        return userInputFormCheckTool;
    }

    //检查用户id
    public String checkUserID(String id){
        if(id.equals("")){
            return "用户账号不能为空";
        }
        for(int i=0;i<id.length();i++){
            if(id.charAt(i)<'0'||id.charAt(i)>'9'){
                return "账号只能由阿拉伯数字构成";
            }
        }
        if(id.length()!=11) {
            return "账号长度必需为11位";
        }
        return "success";
    }

    //检查用户密码
    public String checkUserPassword(String password){
        if(password.equals("")){
            return "密码不能为空";
        }
        for(int i=0;i<password.length();i++){
            if(!((password.charAt(i)<='9'&&password.charAt(i)>='0')||
                    (password.charAt(i)<='z'&&password.charAt(i)>='a')||
                    (password.charAt(i)<='Z'&&password.charAt(i)>='A')||
                    password.charAt(i)=='_')){
                return "密码必须只包含数字、字母、下划线";
            }
        }
        if(password.length()>20){
            return "密码长度不能大于20";
        }
        return "success";
    }
}
