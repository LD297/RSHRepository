package data.daohelper;

/**
 * Created by aa on 2016/12/3.
 */
public interface DaoHelperFactory {
    public WebManagerDaoHelper getWebManagerDaoHelper();

    public WebSalesmanDaoHelper getWebSalesManDaoHelper();

    public PromotionDaoHelper getPromotionDaoHelper();

    public HotelDaoHelper getHotelDaoHelper();

    public OrderDaoHelper getOrderDaoHelper();

    public UserDaoHelper getUserDaoHelper();

    public CreditRecordListDaoHelper getCrediRecordListDdaoHelper();

    public LoginDaoHelper getLoginDaoHelper();
}
