package bl.hotelserviceimpl;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.*;
import data.dao.hoteldao.HotelDao;
import data.dao.hoteldao.HotelDao_Stub;

/**
 * TODO 应该放在bl层
 * Created by a297 on 16/12/7.
 */
public class HotelServiceFactory {

    // 当处理一些不依托具体酒店对象的业务逻辑（如：验证密码）时，得到此默认hotelController
    public static HotelController getDefaultHotelService(){
        return new HotelController();
    }

    // 得到具体酒店的逻辑实现
    public static HotelController getHotelService(String id){
        return new HotelController(id);
    }

    // 得到具体酒店（配置完逻辑实现）
    public static Hotel getHotel(String id){

        // 得到该id对应的酒店领域对象
        Hotel hotel = new Hotel(id);

        // 设置酒店业务逻辑所需的自身数据层的处理对象
        HotelDao hotelDao = new HotelDao_Stub();
        hotel.setHotelDao(hotelDao);

        // 新建房间管理的领域对象，并传入hotelbl的引用
        RoomManager roomManager = new RoomManager(hotelDao);
        // 新建酒店管理的领域对象，并传入房间管理和hotelbl的引用
        HotelManager hotelManager = new HotelManager(roomManager, hotelDao);
        // 设置酒店的酒店管理这一成员变量
        hotel.setHotelManager(hotelManager);

       // 新建可用客房管理的领域对象,并传入hotelbl的引用
        RoomAvail roomAvail = new RoomAvail(hotelDao);
        // 设置酒店的可用房间管理这一成员变量
        hotel.setRoomAvail(roomAvail);

        return hotel;
    }
}
