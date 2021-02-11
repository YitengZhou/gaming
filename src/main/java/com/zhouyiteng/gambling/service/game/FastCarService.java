package com.zhouyiteng.gambling.service.game;

import com.zhouyiteng.gambling.dao.game.BetRaceMapper;
import com.zhouyiteng.gambling.dao.game.FastCarMapper;
import com.zhouyiteng.gambling.dao.game.FastCarResultMapper;
import com.zhouyiteng.gambling.dao.game.LongDragonMapper;
import com.zhouyiteng.gambling.dao.system.UserMapper;
import com.zhouyiteng.gambling.model.game.*;
import com.zhouyiteng.gambling.model.system.UserModel;
import com.zhouyiteng.gambling.model.web.PageDataModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 急速快车相关操作方法
 *
 * @author zhouyiteng@gambling.com
 *
 * Created by zhouyiteng on 2021/2/7.
 */
@Slf4j
@Service
public class FastCarService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    FastCarMapper fastCarMapper;

    @Autowired
    FastCarResultMapper fastCarResultMapper;

    @Autowired
    BetRaceMapper betRaceMapper;

    @Autowired
    LongDragonMapper longDragonMapper;

    /**
     * 手动添加随机生成的结果
     * @param generateType
     * @return
     */
    @Transactional
    public void raceDone(GenerateType generateType){
        // 更新比赛
        FastCarModel model = fastCarMapper.getLastRace();
        FastCarModel race = FastCarModel.getRandomRace(model, generateType);
        fastCarMapper.updateLastRace(race);
        // 设置长龙
        FastCarResultModel newLongDragon = FastCarAnalysisModel.LongDragonResult(race);
        newLongDragon.setRaceId(race.getEid());
        fastCarResultMapper.addResult(newLongDragon);
        Integer oldRaceId = Integer.parseInt(race.getEid())-1;
        FastCarResultModel oldLongDragon = longDragonMapper.getLongDragon(oldRaceId);
        if (oldLongDragon!=null){
            FastCarResultModel resultLongDragon = FastCarAnalysisModel.compareLongDragon(newLongDragon, oldLongDragon);
            resultLongDragon.setRaceId(race.getEid());
            longDragonMapper.addLongDragon(resultLongDragon);
        } else {
            longDragonMapper.addLongDragon(newLongDragon);
        }
        // 计算收益
        List<BetRaceModel> raceBets = betRaceMapper.getTotalRaceBet(model.getEid());
        if (CollectionUtils.isNotEmpty(raceBets)){
            for (BetRaceModel bet: raceBets){
                FastCarAnalysisModel.raceResult(race, bet);
                betRaceMapper.updateBetRace(bet);
                userMapper.updateProfitMoneyByUserId(bet.getUserId(), bet.getProfit());
            }
        }
        fastCarMapper.createNewRace();
    }

    /**
     * 获得极速赛车比赛结果
     * @return
     */
    public PageDataModel<FastCarModel> getFastCarList(@RequestParam(required = false) Long pageSize,
                                                      @RequestParam(required = false) Long pageIndex){
        PageDataModel<FastCarModel> ret = new PageDataModel<>(pageSize, pageIndex);
        ret.setTotalCount(fastCarMapper.getTotalCount());
        ret.setDataList(fastCarMapper.getPageList(ret.getPageStart(), ret.getPageEnd()));
        return ret;
    }

    /**
     * 获得极速赛车比赛结果标志分页
     * @param pageSize
     * @param pageIndex
     * @return
     */
    public PageDataModel<FastCarResultModel> getFastCarResultList(@RequestParam(required = false) Long pageSize,
                                                                  @RequestParam(required = false) Long pageIndex){
        PageDataModel<FastCarResultModel> ret = new PageDataModel<>(pageSize, pageIndex);
        ret.setTotalCount(fastCarResultMapper.getTotalCount());
        ret.setDataList(fastCarResultMapper.getPageList(ret.getPageStart(), ret.getPageEnd()));
        return ret;
    }

    /**
     * 添加投注
     * @param betRaceModel
     */
    @Transactional
    public void addBetRace(BetRaceModel betRaceModel){
        UserModel user = userMapper.getUserByUserId(betRaceModel.getUserId());
        Double remain = user.getMoney() - betRaceModel.getTotalMoney();
        Double profit = user.getProfit() - betRaceModel.getTotalMoney();
        userMapper.updateMoneyByUserId(user.getUserId(), remain, profit);
        betRaceMapper.addBetRace(betRaceModel);
    }

    /**
     * 获取最新长龙
     */
    public FastCarResultModel getLastLongDragon(){
        return longDragonMapper.getLastLongDragon();
    }
}
