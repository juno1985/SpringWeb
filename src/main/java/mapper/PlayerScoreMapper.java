package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import model.PlayerScore;

public interface PlayerScoreMapper {

	public List<PlayerScore> getPlayerScoresInRange(@Param(value="start")Integer start, @Param(value="length")Integer length);
}
