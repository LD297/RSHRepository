package vo;

import java.util.ArrayList;

import javax.print.attribute.standard.RequestingUserName;

public class DistrictHelper {

	private String district;
	private String province;
	private String city;
	private String area;
	
	private static final String  provinces[] = {
			"上海市","江苏省"
			/**,"浙江省","安徽省","福建省","江西省","山东省",
			"北京市","天津市","河北省","山西省","内蒙古自治区",
			"辽宁省","吉林省","黑龙江省",
			
			"河南省","湖北省","湖南省","广东省","广西壮族自治区","海南省",
			"重庆市","四川省","贵州省","云南省","西藏自治区",
			"陕西省","甘肃省","青海省","宁夏回族自治区","新疆维吾尔自治区",
			"台湾省","香港特别行政区","澳门特别行政区"*/
	};
	
	private static final String cities[][] = {
			{"市辖区","县"
			},//上海
			{"南京市","无锡市","徐州市","常州市","苏州市","南通市","连云港市","淮阴市","盐城市",
				"扬州市","镇江市","泰州市","宿迁市","淮安市"	
			},//江苏
			
			/**
			{"杭州市","宁波市","温州市","嘉兴市","湖州市","绍兴市","金华市","衢州市","舟山市",
				"台州市","丽水地区","丽水市"	
			},//浙江
			{"合肥市","芜湖市","蚌埠市","淮南市","马鞍山市","淮北市","铜陵市","安庆市","黄山市",
				"滁州市","阜阳市","宿州市","六安地区","宣城地区","巢湖地区","池州地区","亳州市",
				"六安市","宣城市","巢湖市","池州市"
			},//安徽
			{"福州市","厦门市","莆田市","三明市","泉州市","漳州市","南平市","龙岩市","宁德地区",
				"宁德市"
			},//福建
			{"南昌市","景德镇市","萍乡市","九江市","新余市","鹰潭市","赣州市","宜春地区","上饶地区",
				"吉安地区","抚州地区","宜春市","上饶市","吉安市","抚州市"
			},//江西
			{"济南市","青岛市","淄博市","枣庄市","东营市","烟台市","潍坊市","济宁市","泰安市",
				"威海市","日照市","莱芜市","临沂市","德州市","聊城市","滨州地区","菏泽地区",
				"滨州市","菏泽市"	
			},//山东
			{"市辖区”，“北京县"
			},//北京市
			{"市辖区","天津县"
			},//天津市
			{"石家庄市","唐山市","秦皇岛市","邯郸市","邢台市","保定市","张家口市","承德市",
				"沧州市","廊坊市","衡水市"
			},//河北省
			{"太原市","大同市","阳泉市","长治市","晋城市","朔州市","忻州地区","吕梁地区",
				"晋中地区","临汾地区","运城地区","忻州市","吕梁市","晋中市","临汾市","运城市"
			},//山西省
			{},
			{},
			{},
			{},
			{},
			{},**/
	};

	private static final String areas[][][] = {
		{
			{
				"黄浦区","南市区","卢湾区","徐汇区","长宁区","静安区","普陀区","闸北区",
				"虹口区","杨浦区","闵行区","宝山区","嘉定区","浦东新区","金山区","松江区",
				"南汇区","奉贤区","青浦区"
			},//市辖区
			{
				"南汇县","奉贤县","青浦县","崇明县"
			}//上海县			
		},//上海市
		{
			{
				"市辖区","玄武区","白下区","秦淮区","建邺区","鼓楼区","下关区","浦口区",
				"大厂区","栖霞区","雨花台区","江宁县","江浦县","六合县","溧水县","高淳县",
				"江宁区","六合区"
			},//南京市
			{
				"市辖区","崇安区","南长区","北塘区","郊区","马山区","江阴市","宜兴市","锡山市",
				"锡山区","惠山区"
			},//无锡市
			{
				"市辖区","鼓楼区","云龙区","九里区","贾汪区","泉山区","丰县","沛县","铜山县",
				"睢宁县","新沂市","邳州市"
			},//徐州市
			{
				"市辖区","天宁区","钟楼区","戚墅堰区","郊区","溧阳市","金坛市","武进市","武进区"
			},//常州市
			{
				"市辖区","沧浪区","平江区","金阊区","郊区","常熟市",
				"张家港市","昆山市","吴江市","太仓市","吴县市","相城区",
				"吴中区","虎丘区"
			},//苏州市
			{
				"市辖区","崇川区","港闸区","海安县","如东县","启东市","如皋市","通州市","海门市"
			},//南通市
			{
				"市辖区","连云区","云台区","新浦区","海州区","赣榆县","东海县","灌云县","灌南县"
			},//连云港市
			{
				"市辖区","清河区","清浦区","淮阴县","涟水县","洪泽县","盱眙县","金湖县","淮安市","淮阴区","楚州区"
			},//淮阴市
			{
				"市辖区","城区","响水县","滨海县","阜宁县","射阳县","建湖县","盐都县","东台市","大丰市","盐都区"
			},//盐城市
			
			{
				"市辖区","广陵区","郊区","宝应县","邗江县","仪征市","高邮市","江都市","邗江区"
			},//扬州市"
			{
				"市辖区","京口区","润州区","丹徒县","丹阳市","扬中市","句容市","丹徒区"
			},//镇江市"
			{
				"市辖区","海陵区","高港区","兴化市","靖江市","泰兴市","姜堰市"
			},//泰州市",
			{
				"市辖区","宿城区","宿豫县","沭阳县","泗阳县","泗洪县"
			},//宿迁市"
			{
				"市辖区","清河区","清浦区","淮阴县","涟水县","洪泽县","盱眙县","金湖县","淮安市",
				"淮阴区","楚州区"
			},//淮安市"	
		},//江苏省
		
	};

	public DistrictHelper(String district){
		if(district==null ||district.length()<6){
			district = "010009";
		}
		int iProvince = Integer.parseInt(district.substring(0,2));
		int iCity = Integer.parseInt(district.substring(2,4));
		int iArea = Integer.parseInt(district.substring(4,6));
		if(iProvince>=provinces.length){
			return ;
		}
		province = provinces[iProvince];
		if(iCity>=cities[iProvince].length){
			return ;
		}
		city = cities[iProvince][iCity];
		if(iArea>=areas[iProvince][iCity].length){
			return ;
		}
		area = areas[iProvince][iCity][iArea];
	}
	
	public DistrictHelper(String province, String city, String area){
		this.province = province;
		this.city = city;
		this.area = area;
		district = getProvinceID(province)+getCityID(province, city)
		+getAreaID(province, city, area);
	}
	
	public static String getAddress(String district){
		DistrictHelper districtHelper = new DistrictHelper(district);
		String result = districtHelper.province+districtHelper.city+districtHelper.area;
		return result;
	}
	
	public String getProvince(){
		return province;
	}
	
	public String getCity(){
		
		return city;
	}
	
	public String getArea(){
		return area;
	}
	
	public static String getDistrict(String province,String city, String area){
		DistrictHelper districtHelper = new DistrictHelper(province, city, area);
		return districtHelper.district;
	}
	
	
	public static String getDistrict(String address){
		String result = null;
		
		return result;
	}
	
	public static void main(String args[]){
	
		DistrictHelper districtHelper  ;
		System.out.println(getAreaID("江苏省","南京市", "栖霞区"));
		System.out.println(getAddress("010009"));
		System.out.println(DistrictHelper.areas[1][0][9]);
	}

	/**
	 * for presentation
	 * @return
	 */
	public static ArrayList<String> getProvinces(){
		ArrayList<String> result = new ArrayList<>();
		for(int i=0;i<provinces.length;i++){
			result.add(provinces[i]);
		}
		return result;
	}

	/**
	 * for presentation
	 * @param province
	 * @return
	 */
	public static ArrayList<String> getCities(String province){
		ArrayList<String> result = new ArrayList<>();
		int provinceID = Integer.parseInt(getProvinceID(province));
		for(int i=0;i<cities[provinceID].length;i++){
			result.add(cities[provinceID][i]);
		}
		return result;
	}
	
	/**
	 * for presentation
	 * @param province
	 * @param city
	 * @return
	 */
	public static ArrayList<String> getAreas(String province,String city){
		ArrayList<String > result = new ArrayList<>();
		int provinceID = Integer.parseInt(getProvinceID(province));
		int cityID = Integer.parseInt(getCityID(province, city));
		for(int i=0;i<areas[provinceID][cityID].length;i++){
			result.add(areas[provinceID][cityID][i]);
		}
		return result;
	}
	

	public static String getProvinceID(String province) {
		// TODO Auto-generated method stub
		int i=0;
		for(;i<provinces.length;i++){
			if(province.equals(provinces[i]))
				break;
		}
		if(i==provinces.length)
			return null;
		char a='0',b='0';
		if(i>10){
			a+=i/10;
			i=i%10;
		}
		b+=i;
		String res = String.valueOf(a)+String.valueOf(b);
		return res;
	}

	public static String getCityID(String province,String city ) {
		// TODO Auto-generated method stub
		int provinceID = Integer.parseInt(getProvinceID(province));
		int i=0;
		for(i=0;i<cities[provinceID].length;i++){
			if(city.equals(cities[provinceID][i]))
				break;
		}
		if(i==cities[provinceID].length)
			return null;
		char a='0',b='0';
		if(i>10){
			a+=i/10;
			i=i%10;
		}
		b+=i;
		String res = String.valueOf(a)+String.valueOf(b);
		return res;
	}

	public static String getAreaID(String province,String city,String area) {
		// TODO Auto-generated method stub
		int provinceID = Integer.parseInt(getProvinceID(province));
		int cityID = Integer.parseInt(getCityID(province, city));
		int i=0;
		for(;i<areas[provinceID][cityID].length;i++){
			if(area.equals(areas[provinceID][cityID][i]))
				break;
		}
		if(i==areas[provinceID][cityID].length)
			return null;
		char a='0',b='0';
		if(i>10){
			a+=i/10;
			i=i%10;
		}
		b+=i;
		String res = String.valueOf(a)+String.valueOf(b);
		return res;
	}

	public String getDistrict() {
		// TODO Auto-generated method stub
		return district;
	}
}
