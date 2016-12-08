package presentation.Main;

import bl.hotelservice.HotelService;
import bl.orderservice.OtherOrderService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import bl.hotelserviceimpl.HotelServiceFactory;
import bl.orderserviceimpl.OrderServiceFactory;
import presentation.hotelcontroller.HotelHomepageUIController;
import presentation.tools.HotelUIFactory;
import vo.HotelVO;

import java.io.IOException;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUITest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = HotelUIFactory.getInstance().getHomepageUILoader();
        Parent root = loader.load();
        HotelHomepageUIController controller = loader.getController();

        // 得到该酒店的逻辑服务
        HotelService hotelService = HotelServiceFactory.getHotelService("0123456789");
        controller.setHotelService(hotelService);
        // 从数据层得到该酒店信息
        HotelVO hotelVO = hotelService.getHotel();
        controller.setHotelVO(hotelVO);

        // 得到订单的逻辑服务
        OtherOrderService otherOrderService = OrderServiceFactory.getOtherOrderService(hotelVO.id);
        // 从数据层得到该酒店所有订单
//        ArrayList<OrderPO> hotelOrders =

        // TODO 设置白色背景（目前看来似乎没什么用，我直接用的背景图片）
        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.setTitle("hotel");
        primaryStage.setScene(new Scene(root, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT));
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
