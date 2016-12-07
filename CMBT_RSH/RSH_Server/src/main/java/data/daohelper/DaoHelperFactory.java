package data.daohelper;

/**
 * Created by aa on 2016/12/3.
 */
public interface DaoHelperFactory {
    public WebManagerDaoHelper getWebStaffDaoHelper();

    public PromotionDaoHelper getPromotionDaoHelper();

    public HotelDaoHelperMySql getHotelDaoHelper();

    public OrderDaoHelper getOrderDaoHelper();

    public UserDaoHelper getUserDaoHelper();

    public CreditRecordListDaoHelper getCrediRecordListDdaoHelper();

    public LoginDaoHelper getLoginDaoHelper();
}
