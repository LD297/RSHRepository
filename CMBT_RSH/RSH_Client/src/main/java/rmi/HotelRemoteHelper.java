package rmi;

import data.dao.hoteldao.HotelDao;

import java.rmi.Remote;

/**
 * Created by a297 on 16/11/26.
 */
public class HotelRemoteHelper {
    private Remote remote;
    private static HotelRemoteHelper hotelRemoteHelper = new HotelRemoteHelper();

    public static HotelRemoteHelper getInstance(){
        return hotelRemoteHelper;
    }

    private HotelRemoteHelper(){

    }
    public void setRemote(Remote remote){
        this.remote = remote;
    }
    public HotelDao getHotelDao(){
        return (HotelDao)remote;
    }

}
