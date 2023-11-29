package com.four.Mybatis.Mapper;

import com.four.Mybatis.Bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	//使用的函数
	public User getUser(User user);//用户登录验证
	public Admin getAdmin(Admin admin);//管理员登陆验证
	public Order getOrderByIDAndTime(@Param("UserID")Integer UserID, @Param("DateTime")String DateTime);
	public boolean addUserCard(Card card);//注册会员
	public boolean deleteUserCard(Card card);//注销会员卡
	public boolean addOrder(Order order);//添加记录
	public List<User> getWashedOrder();//得到洗涤完成的记录
	public List<User> getUnwashedRecords();//得到未洗涤的记录
	public boolean setDetermined(Integer OrderID);//将未洗涤记录改为已洗涤记录
	public List<User> getWashedRecord();//获取已洗涤的记录
	public List<User> getMyOrder(@Param("UserID")Integer UserID);//获取已洗涤的记录
	public Cloth getCloth(Integer ClothID);//获取单个衣服信息
	public boolean setClothPrice(Cloth cloth);//设置衣物价格
	public boolean RegisterMember(@Param("UserID")Integer UserID);//给用户添加会员卡
	public boolean userRegister(User user);//用户注册
	public Double getUserBalance(Integer UserID);//获取用户余额
	public boolean updateUserBalance(@Param("Balance")Double Balance, @Param("UserID")Integer UserID);//修改用户余额
	public boolean deleteMember(Integer UserID);//注销会员
	public Double getOrdersByDatetime(@Param("Datetime")String Datetime);//通过时间来统计受益
	public boolean AddUserBalance(@Param("Balance")Double Balance,@Param("UserID")Integer UserID);//用户进行充值
	public boolean UpdatePwd(@Param("Password")String Password,@Param("Phone")String Phone,@Param("Address")String Address,@Param("UserID")Integer UserID);//用户进行修改密码
	public Integer determineUserMember(Integer UserID);//判断用户是否是会员

	public List<Admin> getAllAdmin();//获取所有员工
	public boolean deleteAdmin(int AdminId);
	public Admin getOneAdmin(int AdmingID);
	public boolean updateAdmin(Admin admin);
	public boolean addAdmin(Admin admin);
}
