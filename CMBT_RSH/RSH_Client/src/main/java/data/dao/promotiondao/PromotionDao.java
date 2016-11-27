package data.dao.promotiondao;

import constant.ResultMessage;
import po.PromotionPO;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Created by aa on 2016/11/27.
 */
public interface PromotionDao extends Remote{

    public ResultMessage insert(PromotionPO po);

    public ResultMessage del(String id, String reason);

    public ResultMessage  update (PromotionPO po);

    public PromotionPO find(String id,String reason);

    public ArrayList<PromotionPO> finds(String str);
}
