package com.zhouyiteng.gambling.service.game;

import com.zhouyiteng.gambling.dao.game.BetRaceMapper;
import com.zhouyiteng.gambling.dao.game.FastCarMapper;
import com.zhouyiteng.gambling.dao.system.UserMapper;
import com.zhouyiteng.gambling.model.game.BetRaceModel;
import com.zhouyiteng.gambling.model.game.FastCarModel;
import com.zhouyiteng.gambling.model.game.GenerateType;
import com.zhouyiteng.gambling.model.system.UserModel;
import com.zhouyiteng.gambling.model.web.PageDataModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

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
    BetRaceMapper betRaceMapper;

    /**
     * 手动添加随机生成的结果
     * @param generateType
     * @return
     */
    public boolean createNewRace(GenerateType generateType){
        FastCarModel model = FastCarModel.getRandomRace(generateType);
        return fastCarMapper.createNewRace();
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
     * 添加投注
     * @param betRaceModel
     */
    @Transactional
    public Double addBetRace(BetRaceModel betRaceModel){
        UserModel user = userMapper.getUserByUserId(betRaceModel.getUserId());
        Double remain = user.getMoney() - betRaceModel.getTotalMoney();
        userMapper.updateMoneyByUserId(user.getUserId(), remain);
        betRaceMapper.addBetRace(betRaceModel);
        return remain;
    }
}
