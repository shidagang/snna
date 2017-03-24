package cn.com.na.controller;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.na.bean.Authorization;
import cn.com.na.bean.ResponseBean;
import cn.com.na.bean.TUser;
import cn.com.na.bean.TUserInfo;
import cn.com.na.bean.User;
import cn.com.na.bean.VerificationCode;
import cn.com.na.service.RegisterValidateService;
import cn.com.na.service.TUserInfoService;
import cn.com.na.service.TUserService;
import cn.com.na.utils.ErrorCodeUtils;
import cn.com.na.utils.SendMailTool;

/**
 * 
 * @author David
 * @Date 2016-12-15 用户
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private TUserService tUserService;

	@Autowired
	private TUserInfoService tUserInfoService;

	@Autowired
	private RegisterValidateService registerValidateService;

	/**
	 * 返回消息
	 */
	private String msg = "";
	/**
	 * 返回错误标识
	 */
	private int errCode = ErrorCodeUtils.UNKNOWN_ERR;

	/**
	 * 用户登陆
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/isLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean isLogin(@RequestBody User user) {
		ResponseBean bean = new ResponseBean();
		try {
			if (null != user) {
				String account = user.getAccount();
				String pwd = user.getPassword();

				TUser tuser = new TUser();
				tuser.setPassword(pwd);
				tuser.setAccount(account);
				User tu = tUserService.isLogin(tuser);

				if (null != tu && tu.getUserId() == null) {
					msg = ErrorCodeUtils.LOGIN_FAIL_MSG;
					errCode = ErrorCodeUtils.LOGIN_FAILED;
				} else {
					if (0 == tu.getActivate()) {
						msg = ErrorCodeUtils.LOGIN_INACTIVE_MSG;
						errCode = ErrorCodeUtils.LOGIN_FAILED;
					} else {
						bean.setData(tu);
						msg = ErrorCodeUtils.LOGIN_SUESS_MSG;
						errCode = ErrorCodeUtils.SUCCESS;
					}
				}
			} else {
				msg = ErrorCodeUtils.PARAMETER_IS_NULL;
				errCode = ErrorCodeUtils.PARAM_ERROR;
			}
		} catch (Exception e) {
			msg = ErrorCodeUtils.DATA_EXCEPTION;
			errCode = ErrorCodeUtils.UNKNOWN_ERR;
			e.printStackTrace();
		}

		bean.setMsg(msg);
		bean.setRetCode(errCode);
		return bean;
	}

	/**
	 * 用户退出,目前没有处理。
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/exitLogin", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean exitLogin(@RequestBody User user) {
		ResponseBean bean = new ResponseBean();
		bean.setRetCode(ErrorCodeUtils.SUCCESS);
		bean.setMsg(msg);
		return bean;
	}

	/**
	 * 用户注册
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean registerUser(@RequestBody User user, HttpServletRequest request) {
		ResponseBean bean = new ResponseBean();
		String language = request.getHeader("language");
		if (StringUtils.isEmpty(language)) {
			language = "0"; // 默认中文（0）
		}
		if (null != user) {
			TUser tuser = new TUser();
			tuser.setAccount(user.getAccount());
			TUser tu = tUserService.userisExistence(tuser);
			if (null != tu && null != tu.getAccount()) {
				msg = ErrorCodeUtils.USER_IS_EXISTENCE;
				errCode = ErrorCodeUtils.USER_IS_EXIST;
			} else {
				tUserService.addUser(user);
				TUser tuser2 = tUserService.getUserByAccount(user.getAccount());
				if (null != tuser2) {
					System.out.println("插入后user info:" + tuser2.toString());
				}
				registerValidateService.sendRegisteremail(tuser2, language);
				if (null == tuser2 && tuser2.getUserId() <= 0) {
					msg = ErrorCodeUtils.REGISTRATION_FAILED_MSG;
					msg = ErrorCodeUtils.DATA_EXCEPTION;
					errCode = 2013;
				} else {
					msg = ErrorCodeUtils.REGISTRATION_SUESS_MSG;
					errCode = 200;
				}
			}
		}
		bean.setMsg(msg);
		bean.setRetCode(errCode);
		return bean;
	}

	/**
	 * 检测用户
	 * 
	 * @param category
	 * @return 传入参数
	 */
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getUsers(@RequestBody User user) {
		ResponseBean bean = new ResponseBean();
		Map<String, Object> map = null;
		if (null == user) {
			msg = ErrorCodeUtils.PARAMETER_IS_NULL;
		} else {
			int count = tUserService.getUser(user);
			if (0 < count) {
				map = new HashMap<String, Object>();
				int userId = tUserService.getUserId(user);
				map.put("count", count);
				map.put("userId", userId);
				bean.setData(map);
				errCode = ErrorCodeUtils.SUCCESS;
				msg = ErrorCodeUtils.GET_SUESS_MSG;
			} else {
				errCode = ErrorCodeUtils.USER_NOT_EXIST;
				msg = ErrorCodeUtils.USER_NOT_EXIST_MSG;
			}
		}
		bean.setRetCode(errCode);
		bean.setMsg(msg);
		return bean;
	}

	/**
	 * 通过用户id,查找用户信息
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean getUserInfoById(String userId) {
		ResponseBean bean = new ResponseBean();
		bean.setRetCode(ErrorCodeUtils.UNKNOWN_ERR);
		if (null == userId) {
			bean.setMsg(ErrorCodeUtils.PARAMETER_IS_NULL);
			return bean;
		}
		TUserInfo info = tUserInfoService.getUserInfoById(Integer.parseInt(userId));
		if (info == null) {
			bean.setMsg("该用户数据不存在!");
			bean.setRetCode(ErrorCodeUtils.USER_NOT_EXIST);
			return bean;
		}
		bean.setData(info);
		bean.setMsg("查询成功!");
		bean.setRetCode(ErrorCodeUtils.SUCCESS);
		return bean;
	}

	/**
	 * 
	 * @param userInfo
	 * 
	 *            { "address":"广东省深圳市福田区", //地址 "eMail":"snna@gmail.com", //邮箱
	 *            "mPhone":"135647895", //移动电话 "tPhone":"0755-12345678", //固定电话
	 *            "nickName":"小白", //昵称 "note":"修改用户信息", //备注 "sex":"1", //性别
	 *            1：男 0：女 "url":"http://2312", //域名URL "userId":1 //用户id }
	 * @return
	 */
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean updateUserInfo(@RequestBody TUserInfo userInfo) {
		ResponseBean bean = new ResponseBean();
		bean.setMsg("更新成功!");
		bean.setRetCode(ErrorCodeUtils.SUCCESS);
		TUserInfo info = tUserInfoService.getUserInfoById(userInfo.getUserId());
		if (info == null) {
			bean.setMsg("该用户数据不存在!");
			bean.setRetCode(ErrorCodeUtils.USER_NOT_EXIST);
			return bean;
		} else {
			info.setAddress(userInfo.getAddress());
			info.seteMail(userInfo.geteMail());
			info.setmPhone(userInfo.getmPhone());
			info.setNickName(userInfo.getNickName());
			info.setNote(userInfo.getNote());
			info.setSex(userInfo.getSex());
			info.settPhone(userInfo.gettPhone());
			info.setUrl(userInfo.getUrl());
			tUserInfoService.updateUserInfo(userInfo);
		}
		return bean;
	}

	/**
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/delUse", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean delCategory(@RequestBody User User) {
		ResponseBean bean = new ResponseBean();

		return bean;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getUserDeviceByUserId", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean getUserDeviceByUserId(@RequestBody User user) {
		ResponseBean bean = new ResponseBean();

		return bean;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/giveOtherUserLetterOfAuthorization", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean giveOtherUserLetterOfAuthorization(@RequestBody Authorization auth) {
		ResponseBean bean = new ResponseBean();

		return bean;
	}

	/**
	 * 重置密码-发送邮箱验证码
	 * 
	 * @param user
	 *            { "account":"p256225" }
	 * @return
	 */
	@RequestMapping(value = "/sendResetPwdEmailCode", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean sendResetPwdEmailCode(@RequestBody User user, HttpServletRequest request) {
		ResponseBean bean = new ResponseBean();
		String language = request.getHeader("language");
		if (StringUtils.isEmpty(language)) {
			language = "0"; // 默认中文（0）
		}
		if (user == null) {
			bean.setMsg(ErrorCodeUtils.USER_NOT_EXIST_MSG);
			bean.setRetCode(ErrorCodeUtils.USER_NOT_EXIST);
			return bean;
		}
		TUser tuser1 = new TUser();
		tuser1.setAccount(user.getAccount());
		TUser tu = tUserService.userisExistence(tuser1);
		if (null == tu) {
			bean.setMsg(ErrorCodeUtils.USER_NOT_EXIST_MSG);
			bean.setRetCode(ErrorCodeUtils.USER_NOT_EXIST);
			return bean;
		}
		SendMailTool tool = new SendMailTool();
		String verificationCode = tool.getVerificationCode();
		// 查询验证码
		VerificationCode code = tUserInfoService.queryVerificationCodeByAccount(user.getAccount());
		if (code != null) {
			// 删除验证码
			tUserInfoService.delVerificationCodeByAccount(user.getAccount());
		}
		code = new VerificationCode();
		code.setCode(verificationCode);
		code.setAccount(user.getAccount());
		code.setEffecttime(new Date());
		// 添加验证码
		tUserInfoService.addVerificationCode(code);
		bean.setMsg(ErrorCodeUtils.SENG_VERIFICATION_CODE_SUECC_MSG);
		bean.setRetCode(ErrorCodeUtils.SUCCESS);
		// 发送邮件
		TUser tuser = tUserService.getUserByAccount(user.getAccount());
		registerValidateService.sendResetPwdmail(tuser, code, language);
		return bean;
	}

	/**
	 * 重置密码
	 * 
	 * @param user
	 *            { "account":"p256225", "password":"1234567" }
	 * @return
	 */
	@RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean resetPwd(@RequestBody User user, HttpServletRequest request) {
		ResponseBean bean = new ResponseBean();
		if (user == null) {
			bean.setMsg(ErrorCodeUtils.USER_NOT_EXIST_MSG);
			bean.setRetCode(ErrorCodeUtils.USER_NOT_EXIST);
			return bean;
		}
		String verificationCode = request.getHeader("verificationCode");
		if (StringUtils.isBlank(verificationCode)) {
			bean.setMsg(ErrorCodeUtils.VERIFICATION_CODE_ISNULL_MSG);
			bean.setRetCode(ErrorCodeUtils.PARAM_ERROR);
			return bean;
		}
		TUser tuser1 = new TUser();
		tuser1.setAccount(user.getAccount());
		TUser tu = tUserService.userisExistence(tuser1);
		if (null == tu) {
			bean.setMsg(ErrorCodeUtils.USER_NOT_EXIST_MSG);
			bean.setRetCode(ErrorCodeUtils.USER_NOT_EXIST);
			return bean;
		}
		// 查询验证码
		VerificationCode code = tUserInfoService.queryVerificationCodeByAccount(user.getAccount());
		if (!verificationCode.equals(code.getCode())) {
			bean.setMsg(ErrorCodeUtils.ERROR_VERIFICATION_CODE_MSG);
			bean.setRetCode(ErrorCodeUtils.ERROR_VERIFICATION_CODE);
			return bean;
		}
		TUser tuser = new TUser();
		tuser.setAccount(user.getAccount());
		tuser.setPassword(user.getPassword());
		tUserService.updateUser(tuser);
		bean.setMsg(ErrorCodeUtils.RESETPWD_SUESS_MSG);
		bean.setRetCode(ErrorCodeUtils.SUCCESS);
		return bean;
	}

	@RequestMapping(value = "/saveUserHeadPic", method = RequestMethod.POST)
	public void saveUserHeadPic(HttpServletRequest request, HttpServletResponse response) {
		String result = "msg:修改头像成功!; code:200";
		String ids = request.getHeader("userId");
		TUserInfo info = tUserInfoService.getUserInfoById(Integer.parseInt(ids));
		String temp = System.getProperty("java.io.tmpdir");
		// 创建一个临时文件存放要上传的文件，第一个参数为上传文件大小，第二个参数为存放的临时目录
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024 * 5, new File(temp));
		// 设置缓冲区大小为 5M
		factory.setSizeThreshold(1024 * 1024 * 5);
		// 创建一个文件上传的句柄
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置上传文件的整个大小和上传的单个文件大小
		upload.setSizeMax(1024 * 1024 * 50);
		upload.setFileSizeMax(1024 * 1024 * 5);
		String[] fileExts = { "png", "gif", "jpg" };
		try { // 把页面表单中的每一个表单元素解析成一个
			FileItem fileItem = (FileItem) upload.parseRequest(request).get(0);
			// for (FileItem fileItem : items) {
			// 如果是一个普通的表单元素(type不是file的表单元素)
			if (!fileItem.isFormField()) {
				// 获取文件的后缀名
				String fileName = fileItem.getName();// 得到文件的名字
				String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
				if (Arrays.binarySearch(fileExts, fileExt) != -1) {
					try { // 将文件上传到项目的upload目录并命名，getRealPath可以得到该web项目下包含/upload的绝对路径//
						String path = request.getServletContext().getRealPath("/upload/");
						long now = System.currentTimeMillis();
						String img = path + "/" + now + "." + fileExt;
						info.setImg(now + "." + fileExt);
						info.setUrl("/upload/");
						File file = new File(img);
						fileItem.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					tUserInfoService.updateUserInfo(info);
				} else {
					System.out.println("该文件类型不能够上传");
				}
				// }
			}
		} catch (FileUploadBase.SizeLimitExceededException e) {
			result = "msg:整个请求的大小超过了规定的大小...!; code:201";
			// System.out.println("整个请求的大小超过了规定的大小...");
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			result = "msg:请求中一个上传文件的大小超过了规定的大小...!; code:201";
			// System.out.println("请求中一个上传文件的大小超过了规定的大小...");
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(result);
		} catch (Exception e) {

		}

	}
}
