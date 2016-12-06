package presentation.tools;


import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 * Created by john on 2016/12/5.
 */
public class Locator {
    private static Locator locator = null;
    private Locator(){}

    public static Locator getLocator() {
        if(locator==null){
            locator = new Locator();
        }
        return locator;
    }

    //用于设置组件的位置，参数分别是上下左右
    public void setLocation(Node child,double top,double bottom,double left,double right){
        AnchorPane.setTopAnchor(child,top);
        AnchorPane.setBottomAnchor(child,bottom);
        AnchorPane.setLeftAnchor(child,left);
        AnchorPane.setRightAnchor(child,right);
    }

}
