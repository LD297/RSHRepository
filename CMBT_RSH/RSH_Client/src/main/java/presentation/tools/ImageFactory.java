package presentation.tools;

import constant.Role;
import constant.StateOfOrder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import presentation.usercontrollertools.UserInfoUtil;
import vo.HotelVO;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by john on 2016/12/5.
 */
public class ImageFactory {
    private static ImageFactory imageFactory = null;
    private MyMap viewRoleMap = new MyMap();
    private MyMap turnDark = new MyMap();
    private MyMap turnBright = new MyMap();
    //image
    private Image user_bright = new Image("/images/身份选择界面素材/User_bright.jpg");
    private Image hotelStaff_bright = new Image("/images/身份选择界面素材/HM_bright.jpg");
    private Image webSalesman_bright = new Image("/images/身份选择界面素材/WS_bright.jpg");
    private Image webManager_bright = new Image("/images/身份选择界面素材/WM_bright.jpg");
    private Image user_dark = new Image("/images/身份选择界面素材/User_dark.png");
    private Image hotelStaff_dark = new Image("/images/身份选择界面素材/HM_dark.png");
    private Image webSalesman_dark = new Image("/images/身份选择界面素材/WS_dark.png");
    private Image webManager_dark = new Image("/images/身份选择界面素材/WM_dark.png");
    private Image showImage = new Image("/images/下拉箭头.png");
    private Image hideImage = new Image("/images/收回箭头.png");
    private Image cancel_gray = new Image("images/cancel.png");
    private Image cancel_red = new Image("images/red_cancel.png");
    private Image female = new Image("/images/female.png");
    private Image male = new Image("/images/male.png");
    private Image lastImageArrow = new Image("/images/返回左箭头 - 副本.png");
    private Image nextImageArrow = new Image("/images/返回右箭头 - 副本.png");
    private Image hotelImage = new Image("/images/hotel/酒店背景图111.png");
    private Image headImage = new Image("/images/用户头像.jpg");
    private Image headImagebackground = new Image("/images/头像背景.png");
    private Image orderExecutedImage = new Image("/images/TICK.png");//执行订单
    private Image chargeForCreditImage = new Image("/images/PLUS.png");//信用充值
    private Image abmormalOrderImage = new Image("/images/question14.png");//异常订单
    private Image cancelAbnormalImage = new Image("/images/撤销.png");//撤销订单
    private Image delayCheckinImage = new Image("/images/NOTEPAD _ OK.png");//回复异常订单
    private Image unexecutedOrderImage = new Image("/images/exclamation.png");//未执行订单
    private Image phoneImage = new Image("/images/电话图标.png");
    private Image penImage = new Image("/images/pen.png");
    private Image address = new Image("/images/地址图标（黑色）.png");
    public Image getAddress() {
		return address;
	}
	private Map<String, ArrayList<Image>> hotelImageMap = new TreeMap<>();//酒店id，对应该酒店的所有图片
  //图片地址，对应图片，用来存储加载过的图片，这样就不用再次加载； 
    private Map<String, Image> getImageByUrl = new TreeMap<>();
   

    public Image getPenImage() {
		return penImage;
	}

	public Image getPhoneImage() {
		return phoneImage;
	}

	public Image getHeadImage() {
		return headImage;
	}

	public Image getHeadImagebackground() {
		return headImagebackground;
	}

	public Image getHotelImage() {
		return hotelImage;
	}

	public Image getLastImageArrow() {
		return lastImageArrow;
	}

	public Image getNextImageArrow() {
		return nextImageArrow;
	}

	private ImageFactory(){
    }

    public Image getFemale() {
		return female;
	}

	public Image getMale() {
		return male;
	}

	public static ImageFactory getImageFactory() {
        if(imageFactory==null){
            imageFactory = new ImageFactory();
        }
        return imageFactory;
    }

    public Image getShowImage(){return showImage;}

    public Image getHideImage(){return hideImage;}

    public Image getCancel_gray(){return cancel_gray;}

    public Image getCancel_red(){return cancel_red;}

    /**
     * 浏览酒店界面调用，得到订单状态图片
     * @param stateOfOrder
     * @return
     */
    public Image getOrderStateImage(StateOfOrder stateOfOrder) {
		String state = stateOfOrder.getString();
		Image image = new Image("/images/"+state+".png");
		return image;
	}
    //用于身份选择界面的头像明暗变化
    public MyMap getTurnDark(ImageView userImage,ImageView hotelStaffImage,
                                            ImageView webSalsmanImage,ImageView webManagerImage){
        turnDark.put(userImage,user_dark);
        turnDark.put(hotelStaffImage,hotelStaff_dark);
        turnDark.put(webManagerImage,webManager_dark);
        turnDark.put(webSalsmanImage,webSalesman_dark);
        return turnDark;
    }
    //用于身份选择界面的头像明暗变化
    public MyMap getTurnBright(ImageView userImage,ImageView hotelStaffImage,
                                               ImageView webSalsmanImage,ImageView webManagerImage) {
        turnBright.put(userImage,user_bright);
        turnBright.put(hotelStaffImage,hotelStaff_bright);
        turnBright.put(webManagerImage,webManager_bright);
        turnBright.put(webSalsmanImage,webSalesman_bright);
        return turnBright;
    }

    //用于身份选择界面根据头像的点击得到用户身份
    public MyMap getViewRoleMap(ImageView userImage,ImageView hotelStaffImage,
                                               ImageView webSalsmanImage,ImageView webManagerImage) {
        viewRoleMap.put(userImage,Role.user);
        viewRoleMap.put(hotelStaffImage,Role.hotel);
        viewRoleMap.put(webManagerImage,Role.webmanager);
        viewRoleMap.put(webSalsmanImage,Role.websalesman);
        return viewRoleMap;
    }

	public Image getOrderExecutedImage() {
		return orderExecutedImage;
	}

	public Image getDelayCheckinImage() {
		return delayCheckinImage;
	}

	public Image getChargeForCreditImage() {
		return chargeForCreditImage;
	}

	public Image getAbmormalOrderImage() {
		return abmormalOrderImage;
	}

	public Image getCancelAbnormalImage() {
		return cancelAbnormalImage;
	}


	public Image getUnexecutedOrderImage() {
		return unexecutedOrderImage;
	}
	/**
	 * 根据地址得到酒店的所有图片
	 * @param hotelID
	 * @param urls
	 * @return
	 */
	public ArrayList<Image> getHotelImages(String hotelID) {
		ArrayList<Image> images = hotelImageMap.get(hotelID);
		return images;
	}
	
	/**
	 * 在输入地址和商圈之后就立马下载图片
	 * @param hotelID
	 * @return
	 */
	public void setHotelImages() {
		hotelImageMap.clear();
		ArrayList<HotelVO> hotelVOs = UserInfoUtil.getInstance().getHotelVOs();
		for(int i=0;i<hotelVOs.size();i++){
			ArrayList<String> urls = UserInfoUtil.getInstance().getImageUrls(hotelVOs.get(i).getHotelID());
			ArrayList<Image> images = new ArrayList<Image>();
			for(int j = 0;j<urls.size();j++){
				Image image = null;
				if(getImageByUrl.containsKey(urls.get(j))){
					image = getImageByUrl.get(urls.get(j));
				}else {
					if(j==0){
						image = new Image(urls.get(j),800,400,false,true);
					}else {
						image = new Image(urls.get(j),400,240,false,true);
					}
					getImageByUrl.put(urls.get(j), image);
				}
				images.add(image);
			}
			hotelImageMap.put(hotelVOs.get(i).getHotelID(), images);
		}
	}
	
	/**
	 * 得到酒店本身的图片
	 * @param hotelID
	 * @return
	 */
	public Image getHotelImage(String hotelID) {
		return hotelImageMap.get(hotelID).get(0);
	}
	/**
	 * 根据房间类型得到房间
	 * @param roomType
	 * @return
	 */
	public Image getRoomImage(String roomType) {
		String url = UserInfoUtil.getInstance().getImageUrl(roomType);
		return getImageByUrl.get(url);
	}
	
	/**
	 * 根据用户id得到用户头像
	 */
	public Image getHeadImage(String userID) {
		String url = UserInfoUtil.getInstance().getUserHeadImageUrl(userID);
		return getHeadImageByUrl(url);
	}
	/**
	 * 传入图片地址，得到图片
	 */
	public Image getHeadImageByUrl(String url) {
		if(getImageByUrl.containsKey(url)){
			return getImageByUrl.get(url);
		}else {
			Image image = new Image(url, 250, 250, false, true);
			getImageByUrl.put(url, image);
			return image;
		}
	}
}
