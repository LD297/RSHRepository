package presentation.tools;

import constant.Role;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private Image headImagebackground = new Image("/images/头像背景.jpg");
    private Image orderExecutedImage = new Image("/images/TICK.png");
    private Image chargeForCreditImage = new Image("/images/PLUS.png");
    private Image abmormalOrderImage = new Image("/images/question14.png");
    private Image cancelAbnormalImage = new Image("/images/撤销.png");//撤销订单
    private Image delayCheckinImage = new Image("/images/NOTEPAD _ OK.png");//回复异常订单
    private Image unexecutedOrderImage = new Image("/images/exclamation.png");

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

}
