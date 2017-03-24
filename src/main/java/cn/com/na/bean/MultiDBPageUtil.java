package cn.com.na.bean;

import java.util.List;
		
/**   
 * 分表分库数据 分页查询工具
 * @author LIUYONG
 * 2016-12-20
 */
public abstract class MultiDBPageUtil {
	private final static SnnaLogger logger = SnnaLogger.getLogger(MultiDBPageUtil.class);
	public QueryResult getPageData(QueryParam queryParam){
		QueryResult result = null;
		try{
			//数据有效性校验
			if(queryParam == null){
				logger.info("获取分页数据错误(传入条件为空)!");
				return null;
			}
			if(queryParam.getCurrentPageIndex() == null){
				logger.info("获取分页数据错误(页码为空)!");
				return null;
			}
			if(queryParam.getPageSize() == null){
				logger.info("获取分页数据错误(每页记录数为空)!");
				return null;
			}
			List<Long> nums = this.countQuery(queryParam);//各库满足条件的数据量
			long numCountLast = this.numCounting(nums);//各库满足条件的总数量
			//返回当页数据
			result = new QueryResult();
			result.setResult(this.queryData(queryParam));
			result.setPageSize(queryParam.getPageSize());//每页记录数
			result.setCurrentPageIndex(queryParam.getCurrentPageIndex());//当前页码
			queryParam.setTotalNum(new Long(numCountLast).intValue());
			result.setTotalNum(Long.valueOf(queryParam.getTotalNum()));
			result.setTotalPage(Long.valueOf(queryParam.getTotalPage()));
		}catch(Exception e){
			logger.error("获取分页数据异常!", e);
			result = null;
		}
		return result;
	}

	

   protected long numCounting(List<Long> nums){
		//初始化 返回值
		long result = 0l;
		if(nums == null || nums.size() <= 0){
			//未传入数据
			result = 0l;
		}else{
			//有值,遍历相加
			for(Long num : nums){
				if(num != null){
					result += num.longValue();
				}
			}
		}
		//返回 结果
		return result;
	}
	
	/**
	 * 查询满足条件的数据记录数
	 * @param queryParam
	 * @return
	 */
	public abstract List<Long> countQuery(QueryParam queryParam);
	
	/**
	 * 查询满足条件的数据集合
	 * @param queryParam
	 * @return
	 */
	public abstract List<?> queryData(QueryParam queryParam);
	
	
}