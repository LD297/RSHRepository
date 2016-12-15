package bl.hotelserviceimpl;

import bl.hotelserviceimpl.controller.HotelController;
import data.dao.hoteldao.HotelDao;
import data.dao_Stub.hoteldao_Stub.HotelDao_Stub;

/**
 * TODO 应该放在bl层
 * Created by a297 on 16/12/7.
 */
public class HotelServiceFactory {


    // 得到具体酒店的逻辑实现
    public static HotelController getHotelService(String id){
        return new HotelController(id);
    }

}
