package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import pojo.ComputerComment;
import pojo.ComputerPojo;

public interface ComputerMapper {

	public List<ComputerPojo> getAllComputers();
	
	//按id进行查询
	public ComputerPojo getById(@Param(value="computerId")Integer cid);
	
	public ComputerPojo getByIdAndTradeMark(@Param(value="cid")Integer cid
				, @Param(value="tradeMark")String tradeMark);
	
	public ComputerPojo getByIdAndTradeMarkUsingParamMap(Integer cid, String tradeMark);
	
	public ComputerPojo getByPojo(ComputerPojo computerPojo);
	
	public List<ComputerPojo> getAllComputersByTabName(@Param(value="tableName")String tableName);
	
	public void insertComputer(ComputerPojo computerPojo);
	
	public void deleteComputer(@Param(value="cid") Integer cid);
	
	public void updateComputerPrice(ComputerPojo computerPojo);
	
	public ComputerPojo selectComputer(String pcName);
	
	public List<ComputerPojo> getDynamicComputer(ComputerPojo computerPojo);
	
	public void updateDynamicComputer(ComputerPojo computerPojo);
	
	public List<ComputerComment> getComputerCommentById(@Param(value="cid")Integer cid);
}
