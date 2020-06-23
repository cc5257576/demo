package com.heque.eat.express.dao;

import java.util.List;
import java.util.Map;


import com.heque.common.vo.user.CityInfoExt;
import com.heque.common.vo.user.StoreStatus;
import com.heque.eat.express.pojo.eei.ExpressEmployeeInfo;
import com.heque.eat.express.pojo.fsi.DishesBusinessSituation;
import com.heque.eat.express.pojo.fsi.FoodStoreInfo;

public interface FoodStoreInfoMapper {
	
	/**查询门店或者餐点是否存在*/
	FoodStoreInfo selectByPrimaryKey(Long id);
	
	/**通过门店id找到对应的餐点的集合*/
	//List<FoodStoreIdName> getDinnerListByFoodStoreId(long id);
	
	/**查询当天的菜品集合,当前时间*/
	//List<DishesBusinessSituation>  getStoreDishesListByNow(Map<String,Object> paramMap);
	
	/**循环查询，按照每天是周几查询*/
	//List<DishesBusinessSituation> getStoreDishesListByWeek(Map<String,Object> paramMap);
	
	/**根据门店Id和时间查询门店菜品经营情况*/
	//List<DishesBusinessSituation> getStoreDishesListByTime(Map<String,Object> paramMap);
	
	/**点餐模式-根据门店id查询菜品*/
	List<DishesBusinessSituation> getDishesListByStoreId(Integer storeId);
	
	/**自助模式-获得公共的自助菜品*/
	List<DishesBusinessSituation> getSelfServiceDishes();
	
	/**待取菜品数量*/
	Integer getDaiQuCountByDishId(Map<String,Object> paramMap);
	
	/**已售菜品数量*/
	Integer getYiShouCountByDishId(Map<String,Object> paramMap);
	
	
    int deleteByPrimaryKey(Long id);

    int insert(FoodStoreInfo record);

    int insertSelective(FoodStoreInfo record);



    int updateByPrimaryKeySelective(FoodStoreInfo record);

    int updateByPrimaryKey(FoodStoreInfo record);

    /**
     * @Title: FoodStoreInfoMapper   
     * @Description: 根据门店id获取该门店下的所有快送员
     * @author TimBrian
     * @since Mar 11, 2019 3:08:58 PM   
     * @param foodStoreId
     * @return
     */
	List<ExpressEmployeeInfo> getEIds(Long foodStoreId);

	List<FoodStoreInfo> queryStoreListForTask();
	
	List<FoodStoreInfo> getAllStoresByCityCode(String codeC);

	int insertVirtualStoreInfo(List<FoodStoreInfo> list);

	List<String> queryStoreCityData();

	Integer querySumVARStore();

	List<FoodStoreInfo> queryRStoreList();

	List<FoodStoreInfo> queryVStoreList();
	
	List<CityInfoExt> getClickAllCity(Map<String,Object> map);
	
	StoreStatus getCodeCByStoreId(long storeId);


	
}