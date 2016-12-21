package presentation.usercontrollertools;

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

    //检查邮件格式
    public String checkEmail(String email){
        boolean rightInput = true;
        String before = "";
        String after = "";
        try {
            before = email.split("@")[0];
            after = email.split("@")[1];
        }catch (Exception e){
            rightInput = false;
        }
        String end = "";
        try {
            end = after.substring(after.length()-4);
        }catch (Exception e){
            rightInput = false;
        }
        if(!end.equals(".com")){
            rightInput = false;
        }
        for(int i=0;i<before.length();i++){
            if(!((before.charAt(i)<='9'&&before.charAt(i)>='0')||
                    (before.charAt(i)<='z'&&before.charAt(i)>='a')||
                    (before.charAt(i)<='Z'&&before.charAt(i)>='A'))){
                rightInput = false;
            }
        }
        for(int i=0;i<end.length()-4;i++){
            if(!((end.charAt(i)<='9'&&end.charAt(i)>='0')||
                    (end.charAt(i)<='z'&&end.charAt(i)>='a')||
                    (end.charAt(i)<='Z'&&end.charAt(i)>='A'))){
                rightInput = false;
            }
        }
        if(!rightInput){
            return "电子邮件格式错误";
        }
        return "success";
    }

    //检查昵称格式
    public String checkNickName(String nickName){
    	if(nickName.equals("")){
    		return "昵称不能为空";
    	}
        for(int i=0;i<nickName.length();i++){
            if(!((nickName.charAt(i)<='9'&&nickName.charAt(i)>='0')||
                    (nickName.charAt(i)<='z'&&nickName.charAt(i)>='a')||
                    (nickName.charAt(i)<='Z'&&nickName.charAt(i)>='A')||
                    nickName.charAt(i)=='_')){
                return "昵称必须只包含数字、字母、下划线";
            }
        }
        if(nickName.length()>10){
            return "昵称长度不能大于10";
        }
        return "success";
    }

}
