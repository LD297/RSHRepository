package presentation.tools;

/**
 * Created by john on 2016/12/6.
 */
public class CorrespondenceTool {
    private static CorrespondenceTool correspondenceTool = null;
    private CorrespondenceTool(){}

    public static CorrespondenceTool getInstance(){
        if(correspondenceTool == null){
            correspondenceTool = new CorrespondenceTool();
        }
        return correspondenceTool;
    }
}
