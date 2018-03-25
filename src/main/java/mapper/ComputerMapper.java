package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.ComputerPojo;

public interface ComputerMapper {

	public List<ComputerPojo> getAllComputers();
	
	//按id进行查询
	public ComputerPojo getById(@Param(value="computerId")Integer cid);
	
	public ComputerPojo getByIdAndTradeMark(@Param(value="cid")Integer cid
				, @Param(value="tradeMark")String tradeMark);
}
