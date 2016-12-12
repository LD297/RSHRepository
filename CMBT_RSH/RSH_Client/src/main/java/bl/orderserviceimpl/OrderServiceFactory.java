package bl.orderserviceimpl;

import bl.hotelserviceimpl.HotelServiceFactory;
import data.dao.orderdao.OrderDao;
import data.dao.orderdao.OrderDao_Stub;

/**
 * Created by a297 on 16/12/8.
 */
public class OrderServiceFactory {

    // 处理订单生成界面的业务逻辑
    private static OrderGenerationController orderGenerationController;

    // 处理其他订单操作的业务逻辑
    private static OtherOrderController otherOrderController;

    private static OrderDao orderDao;

    static {
        if(orderDao==null)
            orderDao = new OrderDao_Stub();
    }

    public static OrderGenerationController getOrderGenerationService(String hotelid){

        if(orderGenerationController==null){

            // 传入hotelid，通过酒店业务逻辑的工厂得到"订单生成"所需的酒店业务逻辑处理对象
            HotelInfoService hotelInfoService = HotelServiceFactory.getHotelService(hotelid);
            // 新建"订单生成"的领域对象
            OrderGeneration orderGeneration = new OrderGeneration();

            // 实例化"订单生成"中"酒店业务逻辑服务"这一成员变量
            orderGeneration.setHotelInfoService(hotelInfoService);
            // 实例化"订单生成"中"自身数据库"这一成员变量
            orderGeneration.setOrderDao(orderDao);

            // 实例化"订单生成控制器"
            orderGenerationController = new OrderGenerationController();
            // 实例化"订单生成控制器"的"订单生成"这一成员变量
            orderGenerationController.setOrderGeneration(orderGeneration);
        }

        return orderGenerationController;
    }

    /**
     *针对婷婷的设计，吕丹给出声明：OtherOrderController中有三个成员变量，其中AbnormalOrder和NormalOrder
     * 分别又都持有酒店的业务逻辑的引用，而酒店业务逻辑的引用在实例化（找到堆上对象）时需要hotelid作为参数，
     * 所以，在从工厂得到OtherOrderService（接口）的实例（OtherOrderController）时，需要传入这个参数。
     * 但是成员变量CheckOrder却不需要这个引用。（且用到 CheckOrder的地方，未必有hotelid这个参数）
     * 所以，就算界面只想调用CheckOrder,也要硬性传入null作为参数，反正最后调用到的方法也和这个参数无关。声明完毕。
     *
     * @param hotelid
     * @return
     */
    public static OtherOrderController getOtherOrderService(String hotelid) {

        if(otherOrderController==null){

            // 传入hotelid，通过酒店业务逻辑的工厂得到"订单生成"所需的酒店业务逻辑处理对象
            HotelInfoService hotelInfoService = HotelServiceFactory.getHotelService(hotelid);

            // 新建"异常订单"领域对象
            AbnormalOrder abnormalOrder = new AbnormalOrder();
            // 实例化实例化"异常订单"中"酒店业务逻辑服务"这一成员变量
            abnormalOrder.setHotelInfoService(hotelInfoService);
            // 实例化"异常订单"中"自身数据库"这一成员变量
            abnormalOrder.setOrderDao(orderDao);

            NormalOrder normalOrder = new NormalOrder();
            normalOrder.setHotelInfoService(hotelInfoService);
            normalOrder.setOrderDao(orderDao);

            CheckOrder checkOrder = new CheckOrder();
            checkOrder.setOrderDao(orderDao);
        }
        return otherOrderController;
    }
}
