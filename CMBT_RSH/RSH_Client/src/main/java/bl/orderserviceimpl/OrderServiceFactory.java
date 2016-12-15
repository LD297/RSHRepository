package bl.orderserviceimpl;

import bl.hotelservice.HotelInfoService;
import bl.hotelserviceimpl.HotelController;
import bl.hotelserviceimpl.HotelServiceFactory;
import bl.orderservice.OrderForHotel;
import bl.orderservice.OrderForUser;
import bl.orderservice.OrderForWebsite;
import data.dao.orderdao.OrderDao;
import data.dao.orderdao.OrderDao_Stub;

/**
 * Created by a297 on 16/12/8.
 */
public class OrderServiceFactory {
    // 单件
    private static OrderForHotelController orderForHotelController = null;

    // 处理订单生成界面的业务逻辑
    private static OrderForUserController orderForUserController = null;

    // 处理其他订单操作的业务逻辑
    private static OrderForWebsiteController orderForWebsiteController = null;

    private static OrderDao orderDao = null;

    static {
        if(orderDao==null)
            orderDao = new OrderDao_Stub();
    }

    public static OrderForHotelController getOrderForHotelService(String hotelID){

        if(orderForHotelController==null){

           // 新建"订单生成"的领域对象
            OrderForHotelImpl orderForHotel = new OrderForHotelImpl();

            // 实例化"订单生成"中"自身数据库"这一成员变量
            orderForHotel.setOrderDao(orderDao);

            orderForHotelController = new OrderForHotelController();
        }

        return orderForHotelController;
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
    public static OrderForUserController getOrderForUserService(String hotelid) {

        if(orderForUserController==null){

            // 传入hotelid，通过酒店业务逻辑的工厂得到"订单生成"所需的酒店业务逻辑处理对象
            HotelController hotelController = HotelServiceFactory.getHotelService(hotelid);

            // 新建"异常订单"领域对象
            OrderForUserImpl orderForUser = new OrderForUserImpl();
            // 实例化实例化"异常订单"中"酒店业务逻辑服务"这一成员变量
            orderForUser.setHotelInfoService(hotelController);
            orderForUser.setHotelService(hotelController);
            // 实例化"异常订单"中"自身数据库"这一成员变量
            orderForUser.setOrderDao(orderDao);

            orderForUserController = new OrderForUserController();

        }
        return orderForUserController;
    }
    public static OrderForWebsiteController getOrderForWebsiteService(String hotelid) {

        if(orderForWebsiteController==null){

            // 传入hotelid，通过酒店业务逻辑的工厂得到"订单生成"所需的酒店业务逻辑处理对象
            HotelController hotelController = HotelServiceFactory.getHotelService(hotelid);

            // 新建"异常订单"领域对象
            OrderForWebsiteImpl orderForWebsite = new OrderForWebsiteImpl();
            // 实例化实例化"异常订单"中"酒店业务逻辑服务"这一成员变量
            orderForWebsite.setHotelService(hotelController);
            // 实例化"异常订单"中"自身数据库"这一成员变量
            orderForWebsite.setOrderDao(orderDao);

            orderForWebsiteController = new OrderForWebsiteController();
        }
        return orderForWebsiteController;
    }
}
